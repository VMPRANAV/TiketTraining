package com.example.ClassRoom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface CustomerAmountDTO {
    Integer getCustomer_ID();
    Long getTotalAmount();
    Double getAvgAmount();

}
