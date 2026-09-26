package com.example.ClassRoom.dto;

import com.example.ClassRoom.entity.Customer;
import com.example.ClassRoom.entity.Orders;
import com.example.ClassRoom.entity.order_status1;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class CustomerRequest {

        private  int customer_id;
        private String name;
        private String city;
        private com.example.ClassRoom.entity.Customer referred_by;

        private List<Orders> orders;
    private  int order_id;

    private  Customer customer;

    private LocalDate order_date;
    private  int total_amount;
    private order_status1 status;

    }


