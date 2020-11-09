package com.springboot.controller;

import com.springboot.common.ParameterConfiguration;
import com.springboot.common.WebDataReturn;
import com.springboot.common.constant.Constant;
import com.springboot.common.constant.WebData;
import com.springboot.entity.SysUser;
import com.springboot.service.UserService;
import com.springboot.utils.UtilValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Title: userController
 * @Description: 用户操作类
 * @Author: jiangwg
 * @CreateDate: 2020/7/6 16:01
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ParameterConfiguration parameterConfiguration;
    /**
     * @Author jiangwg
     * @Description 用户登录
     * @Date 11:42 2020/7/28
     * @Param
     * @param userName
     * @param passWord
     * @param request
     * @return com.springboot.common.constant.WebData
     **/
    @PostMapping(value ="/login")
    @ResponseBody
    public WebData login(String userName, String passWord, HttpServletRequest request){
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(passWord)){
            return WebDataReturn.descError("用户名或密码未传,登陆失败!");
        }
        List<Map<String,Object>> loginInformation =  userService.login(userName,passWord,request);
        if(UtilValidator.isEmpty(loginInformation)){
            return WebDataReturn.descError("用户名密码错误,登陆失败!");
        }
        return WebDataReturn.descNormal("登录成功",loginInformation);
    }

    /**
     * @Author jiangwg
     * @Description 用户注册
     * @Date 13:54 2020/7/28
     * @Param
     * @return com.springboot.common.constant.WebData
     **/
    @PostMapping(value = "/register")
    @ResponseBody
    public WebData register(SysUser sysUser){
        if(StringUtils.isEmpty(sysUser)){
            return WebDataReturn.descError("注册用户为空,注册失败!");
        }
        sysUser.setId(UUID.randomUUID().toString().replace("-",""));
        sysUser.setIsDeleted("0");
        sysUser.setCreateTime(Calendar.getInstance().getTime());
        sysUser.setHeadPortrait(parameterConfiguration.getHeadPortrait());
        String result =  userService.register(sysUser);
        if(Constant.SUCCESS.equals(result)){
            return WebDataReturn.descNormal("注册成功!");
        }else if(Constant.FAILURE.equals(result)){
            return WebDataReturn.descError("注册失败，请联系管理员解决！");
        }else{
            return WebDataReturn.descError(result);
        }
    }
    /**
     * @Author jiangwg
     * @Description 用户退出
     * @Date 19:56 2020/9/8
     * @Param
     * @param userName
     * @param request
     * @return com.springboot.common.constant.WebData
     **/
    @PostMapping(value = "/loginOut")
    @ResponseBody
    public WebData loginOut(String userName,HttpServletRequest request){
        if(UtilValidator.isEmpty(userName)){
            return WebDataReturn.descError("用户名未传,退出失败!");
        }
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        try {
            while(attributeNames.hasMoreElements()){
                session.removeAttribute(attributeNames.nextElement());
            }
            return WebDataReturn.descNormal("退出成功!");
        }catch (Exception e){
            e.printStackTrace();
            return WebDataReturn.descError("退出失败!");
        }
    }
    @PostMapping(value = "/ceShi")
    public String ceShi(HttpServletRequest request, HttpServletResponse response) {
            return "index";
    }
}
