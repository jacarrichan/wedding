package com.wedding.seller.service.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.ListResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.domain.dto.DomainDto;
import com.wedding.domain.service.DomainService;
import com.wedding.seller.constants.SellerInternalStatusEnum;
import com.wedding.seller.constants.SellerTypeEnum;
import com.wedding.seller.dao.SellerDao;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.pojo.Seller;
import com.wedding.seller.pojo.search.SellerSearch;
import com.wedding.seller.repository.SellerRepository;
import com.wedding.seller.test.BaseTestCase;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tool.service.IAreaQueryService;

public class PrepareSellerDataTest extends BaseTestCase{

	@Autowired
	private SellerDao sellerDao;
	
	@Autowired
	private IAreaQueryService areaService;
	
	@Autowired
	private SellerRepository repository;
	
    @Autowired
    private DomainService domainService;
	
	String[] name = {"婚庆公司排", "维多利亚婚", "为您量身定制婚", "个性打造", "量身定", "亚婚礼", "公司", "名维多利亚婚礼会","婚礼会", "名维多利亚", "又省心婚"};

	@Test
	public void prepareData() throws UnsupportedEncodingException{
		
		for(int i = 0; i <= 10000; i++) {
			Seller seller = new Seller();
			String domainUid = UUIDGenerator.getUUID();
			
			int provinceCode = getRedomProvinceCode();
			seller.setProvinceCode(provinceCode);
			int city = getRedomCode(provinceCode);
			seller.setCityCode(city);
			int regionCode = getRedomCode(city);
			seller.setName(getRedomName());
			seller.setRegionCode(regionCode);
			seller.setAddress("断钢丝爆胎路");
			seller.setBuildTime(new Date());
			seller.setType(getRedomType());
			seller.setWithdraw((byte) 1);
			seller.setStartTime(new Date());
			seller.setEndTime(new Date());
			seller.setIdCardA("idCardA");
			seller.setIdCardB("idCardB");
			seller.setLinsence("linsence");
			seller.setDomainId(domainUid);
			seller.setInternalStatus(getSellerInternalStatusEnumType());
			seller.setStat(1);
			
			sellerDao.insertSelective(seller);
			
			DomainDto domainDto = new DomainDto();
			domainDto.setDomain("www.test.com.cn");
			domainDto.setDomainName(seller.getName());
			domainDto.setId(domainUid);
			domainService.saveDomain(domainDto);
			
			SellerSearch sellerManageDto = changeTo(seller, domainDto);
			repository.save(sellerManageDto);
			System.out.println("index - " + i + " insert " + sellerManageDto);
		}
	}

	private SellerSearch changeTo(Seller seller, DomainDto domainDto) {
		SellerSearch dto = new SellerSearch();
		BeanUtils.copyProperties(seller, dto);
		
		dto.setDomain(domainDto.getDomain());
		return dto;
	}

	private String getRedomName() {
		int index  = (int)(Math.random() * name.length);
		int num = (int)(Math.random() * 1000);
		return name[index] + num + "有限公司";
	}
	
	private Byte getRedomType() {
		int size = SellerTypeEnum.values().length;
		int index  = (int)(Math.random() * size);
		return (byte) (SellerTypeEnum.values()[index].getIndex());
	}
	
	private Integer getSellerInternalStatusEnumType() {
		int size = SellerInternalStatusEnum.values().length;
		int index  = (int)(Math.random() * size);
		return SellerInternalStatusEnum.values()[index].getIndex();
	}

	private int getRedomCode(int city) {
		ListResult<AreaDto> areas = areaService.findByParentId(city);
		if(CollectionUtils.isEmpty(areas.getResults())){
			return city;
		}
		int index  = (int)(Math.random() * areas.getResults().size()) ;		
		return areas.getResults().get(index).getId();
	}

	private int getRedomProvinceCode() {
		ListResult<AreaDto> areas = areaService.findByParentId(1);
		int index  = (int)(Math.random() * areas.getResults().size());		
		return areas.getResults().get(index).getId();
	}
}
