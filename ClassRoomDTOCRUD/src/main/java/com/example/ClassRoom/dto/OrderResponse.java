package com.example.ClassRoom.dto;

import com.example.ClassRoom.entity.Customer;
import com.example.ClassRoom.entity.order_status1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderResponse {
    @Id
    private int order_id;


    private int customerId;

    private LocalDate order_date;
    private int total_amount;
    private order_status1 status;
}
