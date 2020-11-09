package com.springboot.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Title: AllProperties
 * @Description: 配置参数类
 * @Author: jiangwg
 * @CreateDate: 2020/7/28 14:27
 * @Version: 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix ="parameter-configuration")
public class ParameterConfiguration {
    /*
     *图片上传地址
     */
    public String uploadPicturePath;
    /*
     * 用户默认头像地址
     */
    public String headPortrait;
}
