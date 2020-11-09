package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component
public interface UserMapper extends BaseMapper<SysUser>{
    /**
        * @Description: 验证用户名密码是否正确
        * @Author: jiangwg
        * @Date: 2020/7/6 
        * @Param [userName, passWord]
        * @return java.util.Map<java.lang.String,java.lang.Object>
        */
    List<Map<String, Object>> selectUserByName(@Param("userName")String userName);
    /**
     * @Author jiangwg
     * @Description  查询用户数量
     * @Date 14:03 2020/9/25
     * @Param 
     * @return long
     **/
    long selectUserCount();
}
