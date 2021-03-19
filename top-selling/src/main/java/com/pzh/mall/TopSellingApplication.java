package com.pzh.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/18 10:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class TopSellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopSellingApplication.class, args);
    }
}
