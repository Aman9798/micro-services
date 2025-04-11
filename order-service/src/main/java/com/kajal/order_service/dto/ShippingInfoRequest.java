package com.kajal.order_service.dto;

public class ShippingInfoRequest {
    private String address;
    private String city;
    private String state;
    private String country;
    private int pinCode;
    private int phoneNumber;

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getCountry() { return country; }

    public int getPinCode() { return pinCode; }

    public int getPhoneNumber() { return phoneNumber; }
}
