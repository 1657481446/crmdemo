package com.springboot.service.impl;

import com.springboot.common.constant.Constant;
import com.springboot.entity.SysLoginLog;
import com.springboot.entity.SysUser;
import com.springboot.mapper.SysMapper;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.utils.IpUtil;
import com.springboot.utils.TimeUtil;
import com.springboot.utils.UtilValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Title: userServiceImpl
 * @Description: 用户操作逻辑实现类
 * @Author: jiangwg
 * @CreateDate: 2020/7/6 16:01
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SysMapper sysMapper;
    /**
        * @Description: 登录
        * @Author: jiangwg
        * @Date: 16:32 2020/7/6
        * @Param [userName, passWord]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    @Override
    public List<Map<String,Object>> login(String userName, String passWord, HttpServletRequest request) {
        if(UtilValidator.isEmpty(userName) || UtilValidator.isEmpty(passWord)){
            return null;
        }
        List<Map<String, Object>> userInfor = userMapper.selectUserByName(userName);
        // 用户登录成功  添加系统登录日志
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setId(UUID.randomUUID().toString().replace("-",""));
        sysLoginLog.setLoginName(userName);
        sysLoginLog.setCreateTime(TimeUtil.getCurrentTime());
        sysLoginLog.setClientIp(IpUtil.clientIp(request));
        sysLoginLog.setIsDeleted("0");
        if(UtilValidator.isEmpty(userInfor)){
            sysLoginLog.setLoginResult("登陆失败");
            sysLoginLog.setLoginId("该登录用户账号不存在，请联系管理员处理!");
            userInfor.clear();
        }else if (!passWord.equals(userInfor.get(0).get("passWord"))){
            sysLoginLog.setLoginResult("登陆失败");
            sysLoginLog.setLoginId((String)userInfor.get(0).get("id"));
            userInfor.clear();
        }else{
            sysLoginLog.setLoginResult("登陆成功");
            sysLoginLog.setLoginId((String)userInfor.get(0).get("id"));
            // 登陆成功将用户信息存入session中
            //request.getSession().setAttribute(userName,userInfor);
            request.getSession().setAttribute("userName",userName);
            request.getSession().setAttribute("passWord",passWord);
            request.getSession().setAttribute("id",userInfor.get(0).get("id"));
            request.getSession().setAttribute("age",userInfor.get(0).get("age"));
            request.getSession().setAttribute("createTime",userInfor.get(0).get("createTime"));
            request.getSession().setAttribute("headPortrait",userInfor.get(0).get("headPortrait"));
            request.getSession().setAttribute("email",userInfor.get(0).get("email"));
            request.getSession().setMaxInactiveInterval(60 * 30); // 设置session的存活时间  单位秒  30分钟后sesseion失效
        }
        // 保存系统登录日志
        sysMapper.insertSysLog(sysLoginLog);
        return userInfor;
    }
    /**
     * @Author jiangwg
     * @Description //TODO
     * @Date 20:22 2020/9/9
     * @Param 新用户注册e
     * @param sysUser
     * @return java.lang.String
     **/
    @Override
    public String register(SysUser sysUser) {
        List<Map<String, Object>> userList = userMapper.selectUserByName(sysUser.getUserName());
        if(UtilValidator.isEmpty(userList)){
            try {
                userMapper.insert(sysUser);
                return Constant.SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Constant.FAILURE;
        }else{
            return "用户名已被占用!";
        }
    }
}
