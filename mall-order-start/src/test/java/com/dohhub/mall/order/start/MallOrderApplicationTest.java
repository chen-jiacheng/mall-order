package com.dohhub.mall.order.start;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chenjiacheng on 2025/5/4 23:57
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
public class MallOrderApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoader() {
        log.info("Testing context loading...");
        log.info("Application context: {}", applicationContext);
        log.info("Application context class: {}", applicationContext.getClass());
        assertNotNull(applicationContext, "Application context should not be null");
        assertTrue(applicationContext.containsBean("mallOrderApplication"), "Application context should contain the bean");
        log.info("Context loading test passed.");
        log.info("Testing context loading completed.");
    }
}