package com.springboot.entity;

import java.util.Date;

/**
 * @Title: SysLoginLog
 * @Description: 用户登录日志表
 * @Author: jiangwg
 * @CreateDate: 2020/9/25 9:57
 * @Version: 1.0
 */
public class SysLoginLog {
    /**
     *主键
     */
    private String id;
    /**
     *登录用户名称
     */
    private String loginName;
    /**
     *登录用户的ID
     */
    private String loginId;
    /**
     *用户登录客户端IP
     */
    private String clientIp;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *逻辑删除 0用户正常使用 1用户删除
     */
    private String isDeleted;
    /**
     *登陆结果
     */
    private String loginResult;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    @Override
    public String toString() {
        return "SysLoginLog{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginId='" + loginId + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", createTime=" + createTime +
                ", isDeleted='" + isDeleted + '\'' +
                ", loginResult='" + loginResult + '\'' +
                '}';
    }

    public SysLoginLog(String id, String loginName, String loginId, String clientIp, Date createTime, String isDeleted, String loginResult) {
        this.id = id;
        this.loginName = loginName;
        this.loginId = loginId;
        this.clientIp = clientIp;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.loginResult = loginResult;
    }

    public SysLoginLog() {
    }
}
