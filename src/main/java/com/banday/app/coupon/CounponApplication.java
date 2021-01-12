package com.banday.app.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.banday.app.coupon.mapper")
public class CounponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CounponApplication.class);
    }
}
