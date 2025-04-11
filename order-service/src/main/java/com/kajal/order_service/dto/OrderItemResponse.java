package com.kajal.order_service.dto;

public class OrderItemResponse {
    private String orderItemId;
    private String productId;
    private int quantity;
    private double price;

    public OrderItemResponse(String orderItemId, String productId, double price, int quantity) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
