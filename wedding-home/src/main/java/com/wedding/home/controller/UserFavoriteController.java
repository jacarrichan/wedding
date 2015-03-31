package com.wedding.home.controller;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.RequestResult;
import com.wedding.user.dto.UserFavoriteDto;
import com.wedding.user.service.UserFavoriteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Peter on 14-10-9.
 */
@Controller
@RequestMapping(value = "/user/favorite")
public class UserFavoriteController {

    private UserFavoriteService userFavoriteService;

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public RequestResult save(UserFavoriteDto userFavoriteDto){
        RequestResult result = new RequestResult();
        try {
            this.userFavoriteService.save(userFavoriteDto);
            result.setSuccess(true);
            result.setMessage("店铺收藏成功");
        }catch (Exception e){
            throw new SystemException("系统异常");
        }
        return result;
    }

}
