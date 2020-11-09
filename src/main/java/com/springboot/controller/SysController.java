package com.springboot.controller;

import com.springboot.common.WebDataReturn;
import com.springboot.common.constant.WebData;
import com.springboot.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Title: SysController
 * @Description: 系统操作类
 * @Author: jiangwg
 * @CreateDate: 2020/10/12 15:59
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/sysController")
public class SysController {
    @Autowired
    private SysService sysService;
    /**
     * @Author jiangwg
     * @Description 网站流量统计
     * @Date 10:55 2020/9/25
     * @Param
     * @return com.springboot.common.constant.WebData
     **/
    @RequestMapping(value = "/loginLog")
    @ResponseBody
    public WebData loginLog(){

        List<Map<String,Object>> returnList = sysService.loginLog();
        return WebDataReturn.descNormal("查询成功!",returnList);
    }
}
