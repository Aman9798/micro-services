package com.kajal.order_service.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "OrderItem")
@Data
public class OrderItem {
    @Id
    private String id;

    @DBRef
    private Order order;

    @NotNull(message = "Product ID == null")
    @NotBlank
    private String productId;

    @NotNull(message = "Invalid Quantity")
    @Min(value = 1, message = "Quantity < 1")
    private int quantity;

    @NotNull(message = "Invalid Price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price > 0")
    private double price;

    public OrderItem(Order order, String productId, int quantity, double price) {
        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() { return id; }

    public Order getOrder() { return order; }

    public String getProductId() { return productId; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }

    public void setOrder(Order order) { this.order = order; }

    public void setProductId(String productId) { this.productId = productId; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(double price) { this.price = price; }
}
