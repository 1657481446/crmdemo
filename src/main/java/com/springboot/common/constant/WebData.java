package com.springboot.common.constant;

import java.util.List;

/**
 * @Title: WebData
 * @Description: 封装返回对象的格式
 * @Author: jiangwg
 * @CreateDate: 2020/7/10 11:23
 * @Version: 1.0
 */
public class WebData {
    // 状态
    public static final String NORMAL = "正常";
    public static final String ERROR = "错误";
    public static final String EXCEPTION = "异常";
    // 状态对应编码
    public static final String NORMAL_STATUS = "110";
    public static final String ERROR_STATUS = "120";
    public static final String EXCEPTION_STATUS = "119";
    /**
     * 状态编码
     */
    private String code;
    /**
     * 状态编码的简单描述
     */
    private String msg;
    /**
     * 操作结果描述
     */
    private String desc;
    /**
     * 返回结果集
     */
    private List<?> data;
    /**
     * 一页行数
     */
    private Integer rows;
    /**
     * 页数
     */
    private Integer page;
    /**
     * 总条数，用于前端分页
     */
    private Integer totalCount;

    public WebData() {
    }

    public static String getNORMAL() {
        return NORMAL;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static String getEXCEPTION() {
        return EXCEPTION;
    }

    public static String getNormalStatus() {
        return NORMAL_STATUS;
    }

    public static String getErrorStatus() {
        return ERROR_STATUS;
    }

    public static String getExceptionStatus() {
        return EXCEPTION_STATUS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public  List<?> getData() {
        return data;
    }

    public void setData( List<?> data) {
        this.data = data;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "WebData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                ", rows=" + rows +
                ", page=" + page +
                ", totalCount=" + totalCount +
                '}';
    }

    /**
     *  分页的数据返回格式
     * @param code 状态编码
     * @param msg   状态描述
     * @param desc  操作结果描述
     * @param data  结果集
     * @param rows  行数
     * @param page  页数
     * @param totalCount   总条数
     */
    public WebData(String code, String msg, String desc,  List<?> data, Integer rows, Integer page, Integer totalCount) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
        this.data = data;
        this.rows = rows;
        this.page = page;
        this.totalCount = totalCount;
    }

    /**
     * 无分页返回数据格式
     * @param code
     * @param msg
     * @param desc
     * @param data
     */
    public WebData(String code, String msg, String desc,  List<?> data) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
        this.data = data;
    }

    /**
     * 返回操作结果
     * @param code
     * @param msg
     * @param desc
     */
    public WebData(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }
}
