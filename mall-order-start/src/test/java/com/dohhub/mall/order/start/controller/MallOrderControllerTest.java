package com.dohhub.mall.order.start.controller;

import com.alibaba.fastjson.JSON;
import com.dohhub.mall.order.common.enums.BusinessCodeEnum;
import com.dohhub.mall.order.common.model.Result;
import com.dohhub.mall.order.start.model.OrderAcceptDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by chenjiacheng on 2025/5/5 18:47
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
class MallOrderControllerTest {

    @Autowired
    private MallOrderController mallOrderController;

    @Test
    public void acceptTest() {
        OrderAcceptDTO orderAcceptDTO = new OrderAcceptDTO();
        // orderAcceptDTO.setId(-1L);
        Date currentDate = new Date();
        String orderNo = UUID.randomUUID().toString().replace("-", "");
        String requestNo = UUID.randomUUID().toString().replace("-", "");

        orderAcceptDTO.setCreatedAt(currentDate);
        orderAcceptDTO.setUpdatedAt(currentDate);
        orderAcceptDTO.setCreatedBy("test");
        orderAcceptDTO.setUpdatedBy("test");
        orderAcceptDTO.setRequestNo(requestNo);
        orderAcceptDTO.setRequestSystem("test");
        orderAcceptDTO.setRequestDate(currentDate);
        orderAcceptDTO.setOrderNo(orderNo);
        orderAcceptDTO.setOrderAmt(100.0D);
        orderAcceptDTO.setOrderNum(100.0D);
        orderAcceptDTO.setOrderStatus("INIT");
        // orderAcceptDTO.setDeleted(false);
        String jsonString = JSON.toJSONString(orderAcceptDTO);
        log.info("accept order json: {}", jsonString);


        Result<String> result = mallOrderController.accept(orderAcceptDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(BusinessCodeEnum.BUSINESS_SUCCESS.getCode(), result.getCode());
    }
    private static AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void batchAcceptTest() {
        int threads = Runtime.getRuntime().availableProcessors() * 2;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < threads; i++) {
            executor.execute(()->{
                while (true) {
                    OrderAcceptDTO orderAcceptDTO = new OrderAcceptDTO();
                    Date currentDate = new Date();
                    String orderNo = UUID.randomUUID().toString().replace("-", "");
                    String requestNo = UUID.randomUUID().toString().replace("-", "");

                    orderAcceptDTO.setCreatedAt(currentDate);
                    orderAcceptDTO.setUpdatedAt(currentDate);
                    orderAcceptDTO.setCreatedBy("test");
                    orderAcceptDTO.setUpdatedBy("test");
                    orderAcceptDTO.setRequestNo(requestNo);
                    orderAcceptDTO.setRequestSystem("test");
                    orderAcceptDTO.setRequestDate(currentDate);
                    orderAcceptDTO.setOrderNo(orderNo);
                    orderAcceptDTO.setOrderAmt(100.0D);
                    orderAcceptDTO.setOrderNum(100.0D);
                    orderAcceptDTO.setOrderStatus("INIT");

                    try {
                        Result<String> result = mallOrderController.accept(orderAcceptDTO);
                        log.info("result: {}", JSON.toJSONString(result));

                    }catch (Exception e){
                        log.error("accept order error: ", e);
                        continue;
                    }
                    int count = counter.incrementAndGet();
                    log.info("accept order success, count: {}", count);
                    if(count >= 2000000){
                        semaphore.release();
                        break;
                    }

                    // try {
                    //     TimeUnit.SECONDS.sleep(1);
                    // } catch (InterruptedException e) {
                    //     throw new RuntimeException(e);
                    // }

                }
            });

        }

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("accept order success, count: {}", counter.get());


    }


    @Test
    public void getOrderAcceptTest() {
        Result<OrderAcceptDTO> result = mallOrderController.getOrderAccept(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(BusinessCodeEnum.BUSINESS_SUCCESS.getCode(), result.getCode());
        Assertions.assertNotNull(result.getData());
    }
}