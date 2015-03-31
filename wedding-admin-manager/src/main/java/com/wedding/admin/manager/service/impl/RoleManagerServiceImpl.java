package com.wedding.admin.manager.service.impl;

import com.wedding.admin.manager.cache.RoleActionCache;
import com.wedding.admin.manager.dao.RoleDao;
import com.wedding.admin.manager.dao.RoleMenuDao;
import com.wedding.admin.manager.handler.AdminUserAccountRedisHandler;
import com.wedding.admin.manager.pojo.Role;
import com.wedding.admin.manager.pojo.RoleMenu;
import com.wedding.admin.manager.service.IRoleActionService;
import com.wedding.admin.manager.service.IRoleManagerService;
import com.wedding.admin.manger.dto.RoleActionDto;
import com.wedding.admin.manger.dto.RoleDto;
import com.wedding.admin.manger.dto.RoleMenuMappingDto;
import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkzhang on 14-9-25.
 */
@Service
public class RoleManagerServiceImpl implements IRoleManagerService {

    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private RoleMenuDao roleMenuDao;
    
    @Autowired
    private IRoleActionService roleActionSerivce;
    
    @Autowired
	private AdminUserAccountRedisHandler redisHandler;
    
    @Autowired
    private RoleActionCache roleActionCache;

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleDao.findAll();
        return BeanUtils.createBeanListByTarget(roles, RoleDto.class);
    }
    
    public ListResult<RoleMenuMappingDto> getRoleMenuByRoleId(String roleId){
		return new ListResult<RoleMenuMappingDto>(roleMenuDao.getRoleMenuByRoleId(roleId));
	}

	@Transactional
	public RequestResult updateRoleMenu(String roleId, List<String> menuIdList) {
		roleMenuDao.logicDeleteRoleMenuByRoleId(roleId);
		for(String menuId : menuIdList){
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuId);
			roleMenuDao.insert(roleMenu);
		}
		redisHandler.reflushAll();
		return new RequestResult(true, "更新菜单权限成功！");
	} 
	
	@Override
	public ListResult<Pair<String, String>> getRoles() {
		List<Pair<String, String>> reuslts = new ArrayList<Pair<String, String>>();
		List<Role> roles = roleDao.findAll();
		for(Role role : roles){
			reuslts.add(new Pair<String, String>(role.getId(), role.getRoleName()));
    	}
		return new ListResult<Pair<String, String>>(reuslts);
	}

	@Override
	public ListResult<RoleActionDto> getRoleActionByRoleId(String roleId) {
		return roleActionSerivce.getRoleActionByRoleId(roleId);
	}

	@Transactional
	public RequestResult updateRoleAction(String roleId, List<String> actionIdList) {
		roleActionSerivce.updateRoleAction(roleId, actionIdList);
		roleActionCache.refresh(roleId);
		return new RequestResult(true, "更新功能权限成功！");
	}
}
