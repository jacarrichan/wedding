package com.wedding.admin.manager.mapper;

import java.util.List;
import com.wedding.admin.manager.pojo.Action;

public interface ActionExMapper {

	List<Action> getActionByRoleId(String roleId);
}
