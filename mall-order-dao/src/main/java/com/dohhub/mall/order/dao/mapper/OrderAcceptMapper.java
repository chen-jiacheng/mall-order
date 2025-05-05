package com.dohhub.mall.order.dao.mapper;

import com.dohhub.mall.order.dao.model.OrderAcceptDO;

/**
 * Created by chenjiacheng on 2025/5/5 01:23
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public interface OrderAcceptMapper {

    OrderAcceptDO selectById(Long id);


    int insert(OrderAcceptDO orderAcceptDO);
}
