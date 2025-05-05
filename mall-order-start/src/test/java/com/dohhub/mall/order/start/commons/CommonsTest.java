package com.dohhub.mall.order.start.commons;

import org.junit.jupiter.api.Test;

/**
 * Created by chenjiacheng on 2025/5/5 19:46
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class CommonsTest {

    @Test
    public void test() {
        int threads = Runtime.getRuntime().availableProcessors() * 2;
        System.out.println("threads = " + threads);
    }

}
