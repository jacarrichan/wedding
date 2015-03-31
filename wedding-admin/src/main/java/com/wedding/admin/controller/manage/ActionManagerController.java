package com.wedding.admin.controller.manage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedding.admin.manager.service.IActionService;
import com.wedding.admin.manger.dto.ActionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/action")
public class ActionManagerController {

    protected static final Log logger = LogFactory.getLog(ActionManagerController.class);
    
    @Autowired
    private IActionService actionService;

    @RequestMapping(value="/index.do")
    public String index(){
        logger.debug("visit role manager page");
        return "/admin/manager/action";
    }
    
    @ResponseBody
	@RequestMapping(value="/findAll.do")
    public ListResult<ActionDto> findAll(){
    	return actionService.findAll();
    }
    
	@ResponseBody
	@RequestMapping(value="/saveOrUpdate.do")
    public RequestResult saveOrUpdate(ActionDto action){
		logger.debug(action);
		return actionService.saveOrUpdate(action);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteAction.do")
	public RequestResult deleteMenu(@RequestParam("actionId")String actionId){
		return actionService.deleteAction(actionId);
	}
}
