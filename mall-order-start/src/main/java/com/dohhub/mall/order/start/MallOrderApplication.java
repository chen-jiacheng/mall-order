package com.dohhub.mall.order.start;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chenjiacheng on 2025/5/4 23:01
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@MapperScan(basePackages = "com.dohhub.mall.order.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.dohhub.mall.order")
public class MallOrderApplication {
    public static void main(String[] args) {
        log.info("MallOrderApplication is starting...");
        SpringApplication.run(MallOrderApplication.class, args);
        log.info("MallOrderApplication has been started.");
    }
}