package com.wedding.home.controller;

import com.wedding.user.service.IUserAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Peter on 14-9-13.
 */
@Controller
@RequestMapping("/unit/test")
public class UnitTestCaseController {

    @RequestMapping(value = "/webTest.do")
    public void say(){
        System.out.print("Hello");
    }

}
