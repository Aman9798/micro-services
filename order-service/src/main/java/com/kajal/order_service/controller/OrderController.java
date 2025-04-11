package com.kajal.order_service.controller;

import com.kajal.order_service.dto.OrderStatusUpdateRequest;
import com.kajal.order_service.dto.ShippingInfoRequest;
import com.kajal.order_service.service.AuthService;
import com.kajal.order_service.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AuthService authService;
    @Autowired
    private OrderService orderService;

    @GetMapping
    private ResponseEntity<?> getOrders(){
        try{
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{orderId}")
    private ResponseEntity<?> getOrder(@PathVariable String orderId){
        try{
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> placeOrder(HttpServletRequest request){
        try{
            String userId = authService.getUserIdWithValidation(request);
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/cancel")
    public ResponseEntity<?> cancelOrder(HttpServletRequest request){
        try {
            String userId = authService.getUserIdWithValidation(request);
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updateStatus")
    public ResponseEntity<?> updateStatus(
            @RequestBody OrderStatusUpdateRequest updateRequest, HttpServletRequest request){
        try {
            String userId = authService.getUserIdWithValidation(request);
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
