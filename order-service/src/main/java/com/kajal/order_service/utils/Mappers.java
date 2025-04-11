package com.kajal.order_service.utils;

import com.kajal.order_service.dto.OrderItemResponse;
import com.kajal.order_service.dto.OrderResponse;
import com.kajal.order_service.dto.ShippingInfoResponse;
import com.kajal.order_service.entity.Order;
import com.kajal.order_service.entity.OrderItem;
import com.kajal.order_service.entity.ShippingInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mappers {

    public ShippingInfoResponse mapToShippingInfo(ShippingInfo shippingInfo){
        return new ShippingInfoResponse(
                shippingInfo.getId(),
                shippingInfo.getAddress(),
                shippingInfo.getCity(),
                shippingInfo.getState(),
                shippingInfo.getCountry(),
                shippingInfo.getPinCode(),
                shippingInfo.getPhoneNumber()
        );
    }

    public OrderItemResponse mapToOrderItemResponse(OrderItem orderItem) {
        return new OrderItemResponse(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getPrice(),
                orderItem.getQuantity()
        );
    }

    public OrderResponse mapToOrderResponse(Order order){
        List<OrderItemResponse> orderItemResponses = order.getOrderItems().stream().map(this::mapToOrderItemResponse).toList();
        ShippingInfoResponse shippingInfoResponse = mapToShippingInfo(order.getShippingInfo());

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                orderItemResponses,
                shippingInfoResponse,
                order.getItemsPrice(),
                order.getTotalTax(),
                order.getShippingPrice(),
                order.getTotalDiscount(),
                order.getFinalPrice(),
                order.getPlacedOn()
        );
    }
}
