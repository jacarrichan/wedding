package com.wedding.home.controller;

import com.wedding.tool.service.AddressesViewService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Peter on 14-10-23.
 * update by AlfredYe on 15-1-16
 */
@Controller
@RequestMapping(value = "/file/api")
@Log
public class FileUploadController {

    @Autowired
    private AddressesViewService addressesViewService;

    /**
     * 图片上传接口(需要做图片类型验证，调试时候添加)
     * @param files
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/upload.do")
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile[] files,HttpServletRequest request) throws IOException{
        String result = "";
        for(MultipartFile file : files){
            if(file.isEmpty()){
                log.info("the file is empty!");
            }else{
                log.info("the file size is :" + file.getSize());
                log.info("the file type is :" + file.getContentType());
                log.info("the file name is :" + file.getName());
                log.info("the file org name is : " + file.getOriginalFilename());
                String fileAddress =addressesViewService.uploadAddress();
                FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(fileAddress,file.getOriginalFilename())));
                result = fileAddress+file.getOriginalFilename();
            }
        }
        return result;
    }

}
