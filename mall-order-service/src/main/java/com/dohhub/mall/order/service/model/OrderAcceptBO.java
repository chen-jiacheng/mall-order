package com.dohhub.mall.order.service.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OrderAcceptBO implements Serializable {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String requestNo;
    private String requestSystem;
    private Date requestDate;
    private String orderNo;
    private Double orderAmt;
    private Double orderNum;
    private String orderStatus;
    private Boolean deleted;

}