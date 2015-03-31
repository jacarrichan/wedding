package com.wedding.items.searcher.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.items.dao.ItemsDao;
import com.wedding.items.dao.ItemsDescDao;
import com.wedding.items.dto.ItemsDescDto;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.pojo.Items;
import com.wedding.items.pojo.ItemsDesc;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.items.repository.ItemsRepository;
import com.wedding.seller.dao.ShopDao;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.pojo.Shop;
import com.wedding.seller.service.ISellerManageService;
import com.wedding.seller.test.BaseTestCase;

public class ItemsDataPrepareService extends BaseTestCase {
	
	@Autowired
	private ShopDao shopDao;

	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private ItemsDescDao itemsDescDao;

	@Autowired
	private ISellerManageService sellerService;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Test
	public void prepareData(){
		SellerManageQuery query = new SellerManageQuery();
		PageQuery page = new PageQuery();
		page.setPageSize(200);
		page.setCurrPage(1);
		PageResult<SellerDto> result = sellerService.findByPageInDb(query, page);
		while(!CollectionUtils.isEmpty(result.getResults())) {
			for(SellerDto dto : result.getResults()){	
				System.out.println(dto);
				List<ItemsDto> itemsList = getItems(dto);
				for(ItemsDto item : itemsList){
					ItemsSearch search = BeanUtils.createBeanByTarget(item, ItemsSearch.class);
					//itemsRepository.save(search);
				}
			}
			
			page.setTotal(result.getTotal());
			page.nextPage();
			result = sellerService.findByPageInDb(query, page);
		}
	}

	private List<ItemsDto> getItems(SellerDto dto) {
		List<ItemsDto> items = new ArrayList<>();
	
		Shop shop = populateShop(dto);
		shopDao.insert(shop);
		
		for(int i = 0; i < 10; i++){			
			//--------------------------
			Items item = createWeddingItems(dto);
			item.setSellerId(dto.getId());
			item.setShopId(shop.getId());
			itemsDao.insert(item);
			
			//----------------------------------
			List<ItemsDesc> itemsDescs = createItemsDescs(item, dto.getType());
			for(ItemsDesc desc : itemsDescs){
				itemsDescDao.insert(desc);
			}
			
			ItemsDto itemDto = changeToItemsDto(item, itemsDescs, dto, shop);
			items.add(itemDto);
		}
		return items;
	}


	private ItemsDto changeToItemsDto(Items item, List<ItemsDesc> itemsDescs, SellerDto dto, Shop shop) {
		ItemsDto itemDto = BeanUtils.createBeanByTarget(item, ItemsDto.class);
		itemDto.setSellerName(dto.getName());
		itemDto.setShopName(shop.getName());
		itemDto.setSellerType(dto.getType());	
		List<ItemsDescDto> descDtoList = BeanUtils.createBeanListByTarget(itemsDescs, ItemsDescDto.class);
		itemDto.setItemsDesc(descDtoList);
		return itemDto;
	}
	

	private Shop populateShop(SellerDto dto) {
		String shopId = UUIDGenerator.getUUID();	
		Shop shop = new Shop();
		shop.setId(shopId);
		shop.setLogo("logo");
		shop.setName(dto.getName() + "的店铺");
		shop.setSellerId(dto.getId());
		shop.setStat(1);
		return shop;
	}


	//---------------

	private List<ItemsDesc> createItemsDescs(Items item, Byte type) {
		List<ItemsDesc> itemsDescs = new ArrayList<ItemsDesc>();
		for(int i = 0; i < 3; i++) {
			ItemsDesc desc = new ItemsDesc();
			desc.setId(UUIDGenerator.getUUID());
			desc.setItemId(item.getId());
			
			switch (type) {
				case 1:	//婚庆服务
					desc.setItemDescKey("婚庆服务套餐");
					desc.setItemDescTextValue("据新华社电中共中央总书记、国家主席、中央军委主席习近平日前就深入推进平安中国建设作出重要指示强调，法治是平安建设的重要保障。政法综治战线要认真学习贯彻党的十八届四中全会精神，把政法综治工作放在全面推进依法治国大局中来谋划，深入推进平安中国建设，发挥法治的引领和保障作用，坚持运用法治思维和法治方式解决矛盾和问题，加强基础建设，加快创新立体化社会治安防控体系，提高平安建设现代化水平，努力为建设中国特色社会主义法治体系、社会主义法治国家作出更大贡献。  ");
					break;
				case 2:	//酒店
					desc.setItemDescKey("酒店套餐");
					desc.setItemDescTextValue("习近平指出，近年来，政法综治战线紧紧围绕影响群众安全感的突出问题，加强社会治安综合治理，深入推进平安建设，为保障人民安居乐业、维护社会大局稳定、服务经济社会发展作出了重要贡献。深化平安中国建设会议昨天在湖北武汉召开。会议强调，全国政法综治部门要深入学习贯彻党的十八大和十八届二中、三中、四中全会精神，深入学习贯彻习近平总书记系列重要讲话精神，紧紧围绕推进国家治理体系和治理能力现代化的总目标，牢牢把握全面推进依法治国的总要求，充分发挥社会主义制度优势，发挥法治的引领和保障作用，坚持系统治理、依法治理、综合治理、源头治理，坚持问题导向、法治思维、改革创新，进一步加强基础建设，完善立体化社会治安防控体系，提升平安中国建设能力和水平，努力使影响社会安定的问题得到有效防范、化解、管控，群众安全感和满意度进一步提升，确保人民安居乐业、社会安定有序、国家长治久安。");		
					break;
				case 3:	//婚纱摄影
					desc.setItemDescKey("婚纱摄影套餐");
					desc.setItemDescTextValue("深化平安中国建设会议昨天在湖北武汉召开。会议强调，全国政法综治部门要深入学习贯彻党的十八大和十八届二中、三中、四中全会精神，深入学习贯彻习近平总书记系列重要讲话精神，紧紧围绕推进国家治理体系和治理能力现代化的总目标，牢牢把握全面推进依法治国的总要求，充分发挥社会主义制度优势，发挥法治的引领和保障作用，坚持系统治理、依法治理、综合治理、源头治理，坚持问题导向、法治思维、改革创新，进一步加强基础建设，完善立体化社会治安防控体系，提升平安中国建设能力和水平，努力使影响社会安定的问题得到有效防范、化解、管控，群众安全感和满意度进一步提升，确保人民安居乐业、社会安定有序、国家长治久安。");
					break;
				case 4:	//珠宝首饰
					desc.setItemDescKey("珠宝首饰套餐");
					desc.setItemDescTextValue("中共中央政治局委员、中央政法委书记、中央综治委主任孟建柱出席会议并讲话。中央书记处书记、国务委员杨晶主持会议。全国人大常委会副委员长兼秘书长王晨，国务委员、公安部部长郭声琨，最高人民法院院长周强，最高人民检察院检察长曹建明，中国法学会负责同志等出席会议。");
					break;
				case 5:	//婚纱礼服
					desc.setItemDescKey("婚纱礼服套餐");
					desc.setItemDescTextValue("“问计”对象有北京大学国家发展研究院教授周其仁、中国人民大学金融与证券研究所所长吴晓求、瑞穗证券亚洲首席经济学家沈建光、上海新金融研究院学术委员李迅雷等4名专家学者，也有中联重科股份有限公司董事长詹纯新、亿赞普集团董事长罗峰、招商银行股份有限公司董事长李建红、京东集团首席执行官刘强东等4名企业负责人。");
					break;
				default:
					break;
			}
			
			itemsDescs.add(desc);
		}
		return itemsDescs;
	}
	
	//--------------

	private Items createWeddingItems(SellerDto dto) {
		Items item = new Items();
		
		switch (dto.getType()) {
			case 1:
				item.setItemName("婚庆优惠特价服务" + (int)(Math.random() * 1000));
				break;
			case 2:
				item.setItemName("酒店优惠特价" + (int)(Math.random() * 1000));
				break;
			case 3:
				item.setItemName("婚纱特价摄影" + (int)(Math.random() * 1000));
				break;
			case 4:
				item.setItemName("珠宝首饰特价" + (int)(Math.random() * 1000));
				break;
			case 5:
				item.setItemName("婚纱礼服特价" + (int)(Math.random() * 1000));
				break;
			default:
				break;
		
		}
		item.setId(UUIDGenerator.getUUID());
		item.setItemType((int)(Math.random() * 3) + 1);
		item.setItemActiveTitle(dto.getName() + (int)(Math.random() * 1000) + "active_titel");
		item.setItemFactPrice((int)(Math.random() * 999999));
		item.setItemMarketPrice((int)(Math.random() * item.getItemFactPrice()));
		item.setItemFinalPrice((int)(Math.random() * item.getItemMarketPrice()));
		item.setSellerId(dto.getId());
		item.setStat(1);
		return item;
	}

	
}
