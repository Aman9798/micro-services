package com.kajal.order_service.dto;

public class ShippingInfoResponse {
    private String shippingInfoId;
    private String address;
    private String city;
    private String state;
    private String country;
    private int pinCode;
    private int phoneNumber;

    public ShippingInfoResponse(String shippingInfoId, String address, String city, String state, String country, int pinCode, int phoneNumber) {
        this.shippingInfoId = shippingInfoId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
    }
}
