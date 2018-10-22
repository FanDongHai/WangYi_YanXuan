package com.wangyi.wangyi_yanxuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
@MapperScan("com.wangyi.wangyi_yanxuan.mapper")
public class WangyiYanxuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangyiYanxuanApplication.class, args);
    }

}
