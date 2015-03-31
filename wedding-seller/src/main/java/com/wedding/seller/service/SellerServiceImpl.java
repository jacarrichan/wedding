package com.wedding.seller.service;

import com.wedding.common.exception.SystemException;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.DateRegExp;
import com.wedding.common.util.StringUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.domain.dto.DomainDto;
import com.wedding.domain.service.DomainService;
import com.wedding.seller.constants.SellerInternalStatusEnum;
import com.wedding.seller.dao.SellerDao;
import com.wedding.seller.dao.SellerManageDao;
import com.wedding.seller.dao.SellerProfileDao;
import com.wedding.seller.dao.ShopDao;
import com.wedding.seller.dao.search.SellerSearchDao;
import com.wedding.seller.dto.SellerCurdDto;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.ShopDto;
import com.wedding.seller.pojo.Seller;
import com.wedding.seller.pojo.SellerProfile;
import com.wedding.seller.pojo.Shop;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tool.service.IAreaQueryService;
import com.wedding.user.dao.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by arroganter on 14-9-16.
 */
@Service
public class SellerServiceImpl implements SellerService {

//    @Value("#{app.seller_default_score}")
//    private int score;

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private SellerProfileDao sellerProfileDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private UserAccountDao userAccountDao;
    
    @Autowired
    private DomainService domainService;
    
	@Autowired
	private SellerManageDao sellerManageDao;
	
	@Autowired
	private SellerSearchDao sellerSearchDao;
	
	@Autowired
	private IAreaQueryService areaQueryService;


    /*
        创建店铺逻辑
     */
    @Override
    public int addShop(ShopDto shopdto) {
        Date date = new Date();
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopdto, shop);
        shop.setCreateTime(date);
        shop.setCreatePerson("System");
        return shopDao.insert(shop);

    }

    @Override
    public SellerDto querySellerByUserId(String sellerId) {
        Seller seller = sellerDao.querySellerByUserId(sellerId);
        if(seller!=null){
            SellerDto sellerDto = new SellerDto();
            BeanUtils.copyProperties(seller, sellerDto);
            return sellerDto;
        }else{
            return null;
        }
    }

    @Transactional
    @Override
    public String registerSeller(SellerDto sellerDto) {
        Seller seller = BeanUtils.createBeanByTarget(sellerDto,Seller.class);
        seller.setInternalStatus(SellerInternalStatusEnum.APPLY_PROCESSING.getIndex());
        this.sellerDao.insert(seller);
        SellerProfile sellerProfile = new SellerProfile();
        sellerProfile.setSellerId(seller.getId());
        //sellerProfile.setScore(this.score);
        this.sellerProfileDao.insert(sellerProfile);
        return seller.getId();
    }

    /**
     * 创建商家，后台管理用
     */
    @Transactional
	@Override
	public RequestResult create(SellerCurdDto sellerDto) {
    	 String uuid = UUIDGenerator.getUUID();
		 Seller seller = changeTo(sellerDto);
		 seller.setId(uuid);
		 seller.setLevel(0);
		 
		 DomainDto domainDto = wrapDomain(sellerDto);
		 domainService.saveDomain(domainDto);		
		 
		 seller.setDomainId(domainDto.getId());
		 sellerDao.insert(seller);
		 
	    SellerProfile sellerProfile = new SellerProfile();
        sellerProfile.setSellerId(seller.getId());
//        sellerProfile.setScore(this.score);
        this.sellerProfileDao.insertSelective(sellerProfile);
        
        updateSellerManage(seller, domainDto.getDomain());
		return new RequestResult(true, "创建成功！");
	}

	/**
     * 修改商家信息，后台管理用
     */
	@Transactional
	@Override
	public RequestResult update(SellerCurdDto sellerDto) {
        Seller seller = changeTo(sellerDto);
       
        Result<DomainDto> domain = domainService.findDomainById(sellerDto.getDomainId());
        DomainDto domainDto = domain.getResult();
        String domainStr = null;
        if(domainDto != null) {
        	domainDto.setDomain(sellerDto.getDomain());
        	domainDto.setDomainName(sellerDto.getName());
        	domainStr = sellerDto.getDomain();
        	domainService.updateDomin(domainDto);
        } else { 
        	DomainDto newDomain = wrapDomain(sellerDto);
        	domainStr = newDomain.getDomain();
        	seller.setDomainId(newDomain.getId());
    		domainService.saveDomain(newDomain);		
        }
        
        sellerDao.updateByPrimaryKeySelective(seller);   
        updateSellerManage(seller, domainStr);
		return new RequestResult(true, "修改成功！");
	}
	
	
	private DomainDto wrapDomain(SellerCurdDto sellerDto) {
		DomainDto domain = new DomainDto();
		domain.setId(UUIDGenerator.getUUID());
		domain.setDomainName(sellerDto.getName());
		domain.setDomain(sellerDto.getDomain());
		return domain;
	}


	private Seller changeTo(SellerCurdDto sellerDto) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Seller seller = new Seller();
		BeanUtils.copyProperties(sellerDto, seller, "createTime", "startTime", "endTime", "buildTime");
		try {
			seller.setBuildTime(DateRegExp.yyyy_MM_dd.parse(sellerDto.getBuildTime()));
			seller.setStartTime(format.parse(sellerDto.getStartTime()));
			seller.setEndTime(format.parse(sellerDto.getEndTime()));
		} catch (ParseException e) {
			throw new SystemException(e);
		}
		return seller;
	}

	    
	private void updateSellerManage(Seller seller, String domain) {
		SellerDto dto = new SellerDto();
		BeanUtils.copyProperties(seller, dto);
		
		dto.setDomain(domain);
		String fullAddress = populateFullAddress(dto);
		dto.setFullAddress(fullAddress);
		SellerSearch search = BeanUtils.createBeanByTarget(dto, SellerSearch.class);
		sellerSearchDao.save(search);
	}
	
	public String populateFullAddress(SellerDto record) {
		StringBuilder fullAddress = new StringBuilder();
		AreaDto province = areaQueryService.findById(record.getProvinceCode());
		if(province != null){
			fullAddress.append(province.getName()).append(" ");
			record.setProvinceName(province.getName());
		}
		AreaDto city = areaQueryService.findById(record.getCityCode());
		if(city != null){
			fullAddress.append(city.getName()).append(" ");
			record.setCityName(city.getName());
		}
		AreaDto region = areaQueryService.findById(record.getRegionCode());
		if(region != null){
			fullAddress.append(region.getName()).append(" ");
			record.setRegionName(region.getName());
		}
		if(StringUtils.isNotEmpty(record.getAddress())) {
			fullAddress.append(record.getAddress());
		}
		return fullAddress.toString();
	}

    @Override
    public SellerDto findParentById(String sellerId) {
        return sellerManageDao.findParentSellerById(sellerId);
    }


}
