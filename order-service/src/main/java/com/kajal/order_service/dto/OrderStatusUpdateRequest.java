package com.kajal.order_service.dto;

import com.kajal.order_service.enums.OrderStatus;

public class OrderStatusUpdateRequest {
    private String orderId;
    private OrderStatus orderStatus;
}
