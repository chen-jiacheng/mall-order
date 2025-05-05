package com.dohhub.mall.order.start.controller;

import com.dohhub.mall.order.common.enums.BusinessCodeEnum;
import com.dohhub.mall.order.common.model.Result;
import com.dohhub.mall.order.service.model.OrderAcceptBO;
import com.dohhub.mall.order.service.service.OrderAcceptService;
import com.dohhub.mall.order.start.model.OrderAcceptDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenjiacheng on 2025/5/4 23:14
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("/mall/order")
@Controller
@ResponseBody
public class MallOrderController {

    @Autowired
    private OrderAcceptService orderAcceptService;

    @RequestMapping(method = RequestMethod.POST, path = "/accept")
    public Result<String> accept(@RequestBody OrderAcceptDTO orderAcceptDTO) {
        try {
            log.info("accept order");
            OrderAcceptBO orderAcceptBO = new OrderAcceptBO();
            BeanUtils.copyProperties(orderAcceptDTO, orderAcceptBO);
            orderAcceptService.acceptOrder(orderAcceptBO);
            return Result.success("success");
        } catch (Exception e) {
            log.error("accept order error: ", e);
            return Result.error(BusinessCodeEnum.ORDER_ACCEPT_ERROR.getCode(), BusinessCodeEnum.ORDER_ACCEPT_ERROR.getMsg());
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getOrderAccept")
    public Result<OrderAcceptDTO> getOrderAccept(@RequestParam("id") Long id) {
        try {
            log.info("getOrderAccept id: {}", id);
            OrderAcceptBO orderAcceptBO = orderAcceptService.getOrderAcceptById(id);
            if (orderAcceptBO == null) {
                return Result.error(BusinessCodeEnum.ORDER_NOT_EXIST.getCode(), BusinessCodeEnum.ORDER_NOT_EXIST.getMsg());
            }
            OrderAcceptDTO orderAcceptDTO = new OrderAcceptDTO();
            BeanUtils.copyProperties(orderAcceptBO, orderAcceptDTO);
            log.info("getOrderAccept orderAcceptDTO: {}", orderAcceptDTO);
            return Result.success(orderAcceptDTO);
        } catch (Exception e) {
            log.error("getOrderAccept error: ", e);
            return Result.error(BusinessCodeEnum.SYSTEM_EXCEPTION.getCode(), BusinessCodeEnum.SYSTEM_EXCEPTION.getMsg());
        }
    }

}
