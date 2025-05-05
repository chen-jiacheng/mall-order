package com.dohhub.mall.order.service.service.impl;

import com.dohhub.mall.order.dao.mapper.OrderAcceptMapper;
import com.dohhub.mall.order.dao.model.OrderAcceptDO;
import com.dohhub.mall.order.service.model.OrderAcceptBO;
import com.dohhub.mall.order.service.service.OrderAcceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjiacheng on 2025/5/5 01:27
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@Service
public class OrderAcceptServiceImpl implements OrderAcceptService {

    @Autowired
    private OrderAcceptMapper orderAcceptMapper;

    @Override
    public OrderAcceptBO getOrderAcceptById(Long id) {
        OrderAcceptDO orderAcceptDO = orderAcceptMapper.selectById(id);
        if (orderAcceptDO != null) {
            OrderAcceptBO orderAcceptBO = new OrderAcceptBO();
            BeanUtils.copyProperties(orderAcceptDO, orderAcceptBO);
            return orderAcceptBO;
        }
        return null;
    }

    @Override
    public void acceptOrder(OrderAcceptBO orderAcceptBO) {
        OrderAcceptDO orderAcceptDO = new OrderAcceptDO();
        BeanUtils.copyProperties(orderAcceptBO, orderAcceptDO);
        orderAcceptMapper.insert(orderAcceptDO);
        log.info("insert order accept success, id: {}", orderAcceptDO.getId());
    }
}
