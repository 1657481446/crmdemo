package com.springboot.service.impl;

import com.springboot.mapper.SysMapper;
import com.springboot.mapper.UserMapper;
import com.springboot.service.SysService;
import com.springboot.utils.TimeUtil;
import com.springboot.utils.UtilValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Title: SysServiceimpl
 * @Description:
 * @Author: jiangwg
 * @CreateDate: 2020/10/12 16:01
 * @Version: 1.0
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SysMapper sysMapper;
    /**
     * @Author jiangwg
     * @Description 获取系统登陆日志
     * @Date 13:55 2020/9/27
     * @Param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     **/
    @Override
    public List<Map<String, Object>> loginLog() {
        // 获取所有注册用户个数
        long userSize = userMapper.selectUserCount();
        // 获取安全运行天数
        List<Map<String,Object>> loginLogList = sysMapper.selectLoginLog();
        List<Map<String,Object>> returnList = new ArrayList<>();
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("userNum",userSize);
        if(UtilValidator.isEmpty(loginLogList)){
            returnMap.put("safetyDayNum",0);
            returnMap.put("viewCount",0);
        }else{
            // 获取最早的登陆时间
            String earlyTimeString = (String)loginLogList.get(0).get("createTime");
            Date earlyTime = TimeUtil.formatDate(earlyTimeString,1);
            Long daynum = 0L;
            if(!UtilValidator.isEmpty(earlyTime)){
                // 用登陆时间计算安全运行天数
                daynum = TimeUtil.calculateTime(earlyTime,new Date(),5);
            }
            returnMap.put("safetyDayNum",daynum);
            // 获取浏览网站的次数
            returnMap.put("viewCount",loginLogList.size());
        }
        returnList.add(returnMap);
        return returnList;
    }
}
