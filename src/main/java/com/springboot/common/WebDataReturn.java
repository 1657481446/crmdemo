package com.springboot.common;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.common.constant.WebData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: WebDataReturn
 * @Description: 数据统一返回格式
 * @Author: jiangwg
 * @CreateDate: 2020/7/10 11:19
 * @Version: 1.0
 */
public class WebDataReturn {

    /**
     * @Author jiangwg
     * @Description 返回成功 带list
     * @Date 14:46 2020/10/12
     * @Param
     * @param desc
     * @param list
     * @return com.springboot.common.constant.WebData
     **/
    public static WebData descNormal(String desc, List<?> list){
        return new WebData(WebData.NORMAL_STATUS,WebData.NORMAL,desc,list);
    }
    /**
     * @Author jiangwg
     * @Description 返回失败 带list
     * @Date 14:47 2020/10/12
     * @Param
     * @param desc
     * @param list
     * @return com.springboot.common.constant.WebData
     **/
    public static WebData descError(String desc, List<Object> list){
        return new WebData(WebData.ERROR_STATUS,WebData.ERROR,desc,list);
    }

    /**
     * @Author jiangwg
     * @Description 返回失败
     * @Date 14:47 2020/10/12
     * @Param
     * @param desc
     * @return com.springboot.common.constant.WebData
     **/
    public static WebData descError(String desc) {
        return new WebData(WebData.ERROR_STATUS, WebData.ERROR, desc);
    }
    /**
     * @Author jiangwg
     * @Description 返回成功
     * @Date 14:48 2020/10/12
     * @Param
     * @param desc
     * @return com.springboot.common.constant.WebData
     **/
    public static WebData descNormal(String desc) {
        return new WebData(WebData.NORMAL_STATUS, WebData.NORMAL, desc);
    }
}
