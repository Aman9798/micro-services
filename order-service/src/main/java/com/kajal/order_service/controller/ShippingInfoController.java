package com.kajal.order_service.controller;

import com.kajal.order_service.dto.ShippingInfoRequest;
import com.kajal.order_service.dto.ShippingInfoResponse;
import com.kajal.order_service.service.AuthService;
import com.kajal.order_service.service.ShippingInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingInfoController {

    @Autowired
    private AuthService authService;
    @Autowired
    private ShippingInfoService shippingService;

    @GetMapping
    public ResponseEntity<?> getAllShippingInfos(){
        try{
            List<ShippingInfoResponse> shippingInfos = shippingService.getAllShippingInfos();
            return new ResponseEntity<>(shippingInfos, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{shippingInfoId}")
    public ResponseEntity<?> getShippingInfo(@PathVariable String shippingInfoId){
        try{
            ShippingInfoResponse shippingInfo = shippingService.getShippingInfo(shippingInfoId);
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addShippingAddress(
            @RequestBody ShippingInfoRequest shippingInfoRequest, HttpServletRequest request){
        try{
            String userId = authService.getUserIdWithValidation(request);
            ShippingInfoResponse shippingInfo = shippingService.addShippingAddress(shippingInfoRequest, userId);
            return new ResponseEntity<>(shippingInfo, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{shippingInfoId}")
    public ResponseEntity<?> updateShippingAddress(
            @PathVariable String shippingInfoId, @RequestBody ShippingInfoRequest shippingInfoRequest, HttpServletRequest request){
        try{
            String userId = authService.getUserIdWithValidation(request);
            return new ResponseEntity<>("done", HttpStatus.OK);

        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
