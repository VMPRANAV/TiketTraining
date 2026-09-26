package com.example.ClassRoom.repositry;

import com.example.ClassRoom.entity.Orders;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("Select o from Orders o  where o.customer.customerId=:customerId" )
    List<Orders> findOrdersByCustomerID(@Param("customer_id") Integer customer_id);

    @Query("Select o from Orders o inner join Customer c on o.customer.customerId=c.customerId")
    List<Orders> findOrders();

}

