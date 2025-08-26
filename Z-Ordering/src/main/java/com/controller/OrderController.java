package com.controller;

import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{productId}/{quantity}")
    public ResponseEntity<String> placeOrder(@PathVariable("productId") Long productId,  @PathVariable("quantity") int quantity) {
        try {
            String result = orderService.placeOrder(productId, quantity);
            return ResponseEntity.ok(result);
            
        } catch (RuntimeException e) {
           
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
}
}