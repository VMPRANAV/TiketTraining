package com.example.ClassRoom.controller;

import com.example.ClassRoom.dto.CustomerAmountDTO;
import com.example.ClassRoom.dto.CustomerOrderDTO;
import com.example.ClassRoom.dto.OrderResponse;
import com.example.ClassRoom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderDetails/{customerID}")
    public List<OrderResponse> getOrderDetails(@PathVariable int customerID) {
        return orderService.getOrderDetails(customerID);
    }

    @GetMapping("/getJoin")
    public List<OrderResponse> getJoinDetails() {
        return orderService.getOrderDetails();
    }

    @GetMapping("/getTotalAmountByCustomer")
    public List<CustomerAmountDTO> getCustomerAmountDetails() {
        return orderService.getTotalAmount();
    }

    @GetMapping("/getCountDetails")
    public List<CustomerOrderDTO> getCustomerOrderDetails() {
        return orderService.getTotalOrder();
    }
    @GetMapping("/getTotalAvg")
    public List<CustomerAmountDTO>getCustomerTotalAvgDetails(@RequestParam int customerId){
       return orderService.getTotalAmountAvg(customerId);
    }

}
