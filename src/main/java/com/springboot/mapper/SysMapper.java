package com.springboot.mapper;

import com.springboot.entity.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Title: SysMapper
 * @Description:
 * @Author: jiangwg
 * @CreateDate: 2020/9/27 11:28
 * @Version: 1.0
 */
@Mapper
@Component
public interface SysMapper {

    /**
     * @Author jiangwg
     * @Description 插入用户登录日志
     * @Date 15:58 2020/10/12
     * @Param
     * @param sysLoginLog
     * @return void
     **/
    void insertSysLog(SysLoginLog sysLoginLog);
    /**
     * @Author jiangwg
     * @Description 查询所有的用户登录日志 并按时间排序
     * @Date 14:02 2020/9/25
     * @Param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     **/
    List<Map<String, Object>> selectLoginLog();
}
