package com.kajal.order_service.dto;

import java.util.Date;
import java.util.List;

public class OrderResponse {
    private String orderId;
    private String userId;
    private List<OrderItemResponse> orderItems;
    private ShippingInfoResponse shippingInfo;
    private double itemsPrice;
    private double totalTax;
    private double shippingPrice;
    private double totalDiscount;
    private double finalPrice;
    private Date placedOn;

    public OrderResponse(String orderId, String userId, List<OrderItemResponse> orderItems, ShippingInfoResponse shippingInfo, double itemsPrice, double totalTax, double shippingPrice, double totalDiscount, double finalPrice, Date placedOn) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.shippingInfo = shippingInfo;
        this.itemsPrice = itemsPrice;
        this.totalTax = totalTax;
        this.shippingPrice = shippingPrice;
        this.totalDiscount = totalDiscount;
        this.finalPrice = finalPrice;
        this.placedOn = placedOn;
    }
}
