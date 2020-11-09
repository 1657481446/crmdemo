package com.springboot.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title: user
 * @Description: java类作用描述
 * @Author: jiangwg
 * @CreateDate: 2020/7/6 16:01
 * @Version: 1.0
 */
@Data
public class SysUser {
    /**
     * ID
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 年龄
     */
    private int age ;
    /**
     * 头像
     */
    private String headPortrait;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 逻辑删除 0用户正常使用 1用户删除
     */
    private String isDeleted;
}
