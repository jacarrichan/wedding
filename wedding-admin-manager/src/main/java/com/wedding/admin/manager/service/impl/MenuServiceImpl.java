package com.wedding.admin.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedding.admin.manager.dao.AccountMenuDao;
import com.wedding.admin.manager.dao.MenuFunctionDao;
import com.wedding.admin.manager.dao.MenuGroupDao;
import com.wedding.admin.manager.dao.RoleMenuDao;
import com.wedding.admin.manager.handler.AdminUserAccountRedisHandler;
import com.wedding.admin.manager.pojo.Menu;
import com.wedding.admin.manager.pojo.MenuGroup;
import com.wedding.admin.manager.service.IMenuService;
import com.wedding.admin.manger.dto.AdminMenuFunctionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.StringUtils;

/**
 * 
 * @author rkzhang
 *
 */
@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private MenuFunctionDao menuDao;
	
	@Autowired
	private MenuGroupDao menuGroupDao;
	
	@Autowired
	private AccountMenuDao accountMenuDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Autowired
	private AdminUserAccountRedisHandler redisHandler;

	@Override
	public ListResult<AdminMenuFunctionDto> findAll() {
		List<Menu> menus = menuDao.findAll();
		List<AdminMenuFunctionDto> results = BeanUtils.createBeanListByTarget(menus, AdminMenuFunctionDto.class);
		Map<String, String> map = menuGroupDao.findAsMap();
		for(AdminMenuFunctionDto menu : results){
			menu.setMenuGroupName(map.get(menu.getMenuGroupId()));
		}
		return new ListResult<AdminMenuFunctionDto>(results);
	}

	@Transactional
	public RequestResult saveOrUpdate(AdminMenuFunctionDto menuDto) {
		MenuGroup group = menuGroupDao.findByName(menuDto.getMenuGroupName());
		Menu menu = BeanUtils.createBeanByTarget(menuDto, Menu.class);
		menu.setMenuGroupId(group.getId());
		if(StringUtils.isNotEmpty(menu.getId())){
			menuDao.updateByPrimaryKeySelective(menu);
		}else{
			menuDao.insert(menu);
		}
		redisHandler.reflushAll();
		return new RequestResult(true, "保存成功！");
	}

	@Transactional
	public RequestResult deleteMenu(String menuId) {
		if(StringUtils.isEmpty(menuId)){
			return new RequestResult(false, "无删除记录！"); 
		}
		accountMenuDao.deleteByMenuId(menuId);
		roleMenuDao.logicDeleteByMenuId(menuId);
		menuDao.deleteByPrimaryKey(menuId);
		redisHandler.reflushAll();
		return new RequestResult(true, "删除成功！");
	}

}
