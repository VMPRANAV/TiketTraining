package com.example.ClassRoom.service;

import com.example.ClassRoom.dto.OrderResponse;
import com.example.ClassRoom.entity.Orders;
import com.example.ClassRoom.repositry.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderResponse> getOrderDetails(int customerId) {
        List<Orders> orders = orderRepository.findOrdersByCustomerID(customerId);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : orders) {
            orderResponseList.add(OrderResponse.builder().order_id(order.getOrder_id()).customerId(order.getCustomer().getCustomerId()).order_date(order.getOrder_date()).total_amount(order.getTotal_amount()).status(order.getStatus()).build());

        }
        return orderResponseList;
    }

    public List<OrderResponse> getOrderDetails() {
        List<Orders> orders = orderRepository.findOrders();
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : orders) {
            orderResponseList.add(OrderResponse.builder().order_id(order.getOrder_id()).customerId(order.getCustomer().getCustomerId()).order_date(order.getOrder_date()).total_amount(order.getTotal_amount()).status(order.getStatus()).build());

        }
        return orderResponseList;
    }


}
