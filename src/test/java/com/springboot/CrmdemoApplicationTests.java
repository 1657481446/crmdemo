package com.springboot;

import com.springboot.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrmdemoApplicationTests {
    @Value("${uploadPicturePath}")
    String aa;
    @Test
    public void contextLoads() {
        System.out.println(aa);
    }

}
