package com.kajal.order_service.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ShippingInfo")
@Data
public class ShippingInfo {
    @Id
    private String id;

    @NotNull(message = "User ID == null")
    @NotBlank
    private String userId;

    @NotNull(message = "Address == null")
    @NotBlank
    private String address;

    @NotNull(message = "City == null")
    @NotBlank
    private String city;

    @NotNull(message = "State == null")
    @NotBlank
    private String state;

    @NotNull(message = "Country == null")
    @NotBlank
    private String country;

    @NotNull(message = "Pin Code == null")
    @NotBlank
    private int pinCode;

    @NotNull(message = "Phone Number == null")
    @NotBlank
    private int phoneNumber;

    public ShippingInfo(String userId, String address, String city, String state, String country, int pinCode, int phoneNumber) {
        this.userId = userId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
    }

    public String getId() { return id; }

    public String getUserId() { return userId; }

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getCountry() { return country; }

    public int getPinCode() { return pinCode; }

    public int getPhoneNumber() { return phoneNumber; }

    public void setUserId(String userId) { this.userId = userId; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setCountry(String country) { this.country = country; }

    public void setPinCode(int pinCode) { this.pinCode = pinCode; }

    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }
}
