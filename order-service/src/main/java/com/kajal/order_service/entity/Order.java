package com.kajal.order_service.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Order")
@Data
public class Order {
    @Id
    private String id;

    @NotNull(message = "User ID == null")
    @NotBlank
    private String userId;

    @DBRef
    private List<OrderItem> orderItems;

    @DBRef
    private ShippingInfo shippingInfo;

    @NotNull(message = "Invalid Items Price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Items Price > 0")
    private double itemsPrice;

    @NotNull(message = "Invalid Total Tax")
    @DecimalMin(value = "0.0", inclusive = false, message = "Tax > 0")
    private double totalTax;

    @NotNull(message = "Invalid Shipping Price")
    @DecimalMin(value = "0.0", message = "Shipping Price >= 0")
    private double shippingPrice;

    @NotNull(message = "Invalid Total Discount")
    @DecimalMin(value = "0.0", message = "Total Discount >= 0")
    private double totalDiscount;

    @NotNull(message = "Invalid Final Price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Final Price > 0")
    private double finalPrice;

    public String getId() { return id; }

    public String getUserId() { return userId; }

    public List<OrderItem> getOrderItems() { return orderItems; }

    public ShippingInfo getShippingInfo() { return shippingInfo; }

    public double getItemsPrice() { return itemsPrice; }

    public double getTotalTax() { return totalTax; }

    public double getShippingPrice() { return shippingPrice; }

    public double getTotalDiscount() { return totalDiscount; }

    public double getFinalPrice() { return finalPrice; }

    public void setUserId(String userId) { this.userId = userId; }

    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public void setShippingInfo(ShippingInfo shippingInfo) { this.shippingInfo = shippingInfo; }

    public void setItemsPrice(double itemsPrice) { this.itemsPrice = itemsPrice; }

    public void setTotalTax(double totalTax) { this.totalTax = totalTax; }

    public void setShippingPrice(double shippingPrice) { this.shippingPrice = shippingPrice; }

    public void setTotalDiscount(double totalDiscount) { this.totalDiscount = totalDiscount; }

    public void setFinalPrice(double finalPrice) { this.finalPrice = finalPrice; }
}
