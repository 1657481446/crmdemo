package com.springboot.utils;

import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Title: UtilValidator
 * @Description: 校验工具类
 * @Author: jiangwg
 * @CreateDate: 2020/7/6 16:58
 * @Version: 1.0
 */
public class UtilValidator {

/*    *//**
        * @Description: 判断对象是否为空
        * @Author: jiangwg
        * @Date: 2020/7/6 
        * @Param [obj]
        * @return boolean
        *//*
    public static boolean  isEmpty(Object obj){
        return (obj == null || obj.toString().trim().length() == 0) ? true : false;
    }*/
    /**
        * @Description: 判断字符串是否为空
        * @Author: jiangwg
        * @Date: 2020/7/6
        * @Param [str]
        * @return boolean
        */
    public static boolean isEmpty(String str){
        return (str == null || str.trim().length() == 0) ? true :false;
    }
    /**
        * @Description: 判断List集合是否为空
        * @Author: jiangwg
        * @Date: 2020/7/6 
        * @Param [list]
        * @return boolean
        */
    public static boolean isEmpty(List<?> list){
        return (list == null || list.size() == 0) ? true :false;
    }
    /**
        * @Description: 判断数组是否为空
        * @Author: jiangwg
        * @Date: 2020/7/6 
        * @Param [array]
        * @return boolean
        */
    public static boolean isEmpty(Object[] array){
        return (array == null || array.length == 0) ? true : false;
    }
    /**
        * @Description: 判断Map集合是否为空
        * @Author: jiangwg
        * @Date: 2020/7/6
        * @Param [map]
        * @return boolean
        */
    public static boolean isEmpty(Map<Object,Object> map){
        return (map == null || map.isEmpty()) ? true : false;
    }
    /**
     * @Description: 判断时间是否为空
     * @Author: jiangwg
     * @Date: 2020/7/6
     * @Param [map]
     * @return boolean
     */
    public static boolean isEmpty(Date date){ return (date == null) ? true : false; }
}
