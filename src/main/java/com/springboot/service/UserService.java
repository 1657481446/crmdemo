package com.springboot.service;

import com.springboot.entity.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String,Object>> login(String userName, String passWord, HttpServletRequest request);

    String register(SysUser sysUser);

}
