package com.wedding.home.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.wedding.common.model.RequestResult;
import com.wedding.common.util.DateUtils;
import com.wedding.common.util.IpUtils;
import com.wedding.common.util.JsonUtil;
import com.wedding.user.dto.UserSiteTotalDto;
import com.wedding.user.dto.UsersSiteDto;
import com.wedding.user.service.IUsersSiteService;
import com.wedding.user.service.UserSiteTotalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chuweifeng on 14-9-19.
 */

@Controller
@RequestMapping(value = "/usite")
public class UsersSiteController {

	@Autowired
	private IUsersSiteService iUsersSiteService;

	@Autowired
	private UserSiteTotalService userSiteTotalService;

	@RequestMapping(value = "/operator.do")
	@ResponseBody
	/**
	 * @param type 1浏览 2点击
	 * @param siteId 网站siteId
	 * **/
	public String operator(@RequestParam("type") String type,
			@RequestParam("siteId") String siteId,HttpServletRequest request) {
		UsersSiteDto usersSiteDto = null;
		usersSiteDto = iUsersSiteService.selectUsersSiteById(siteId);
		if (usersSiteDto != null) {
			/**
			 * 每日访问统计遵循年月日 最小粒度进行统计分析
			 * **/
			manageUserSiteTotal(siteId,request);

			usersSiteDto.setViewCount(usersSiteDto.getViewCount() + 1);
			if (iUsersSiteService.updateUsersSite(usersSiteDto) > 0) {
				return JsonUtil.getJsonStr(new RequestResult(false, "浏览统计成功"));
			} else {
				return JsonUtil.getJsonStr(new RequestResult(false, "浏览统计失败"));
			}
		}

		return JsonUtil.getJsonStr(new RequestResult(false, "浏览统计失败"));
	}

	/**
	 * 每日访问统计遵循年月日 最小粒度进行统计分析
	 * **/
	public void manageUserSiteTotal(String siteId,HttpServletRequest request) {
		Date date = new Date();
		UserSiteTotalDto userSiteTotalDto = new UserSiteTotalDto();
		userSiteTotalDto.setSiteId(siteId);
		userSiteTotalDto.setViewYear(DateUtils.format(date, DateUtils.Y));
		userSiteTotalDto.setViewMonth(DateUtils.format(date, DateUtils.M));
		userSiteTotalDto.setViewDay(DateUtils.format(date, DateUtils.D));
		userSiteTotalDto.setViewDate(DateUtils.format(date, DateUtils.YMD));
		userSiteTotalDto.setIp(IpUtils.getIRealIPAddr(request));
		userSiteTotalService.insertSiteTotal(userSiteTotalDto);
	}

}
