package com.example.ClassRoom.repositry;

import com.example.ClassRoom.dto.CustomerAmountDTO;
import com.example.ClassRoom.dto.CustomerOrderDTO;
import com.example.ClassRoom.entity.Customer;
import com.example.ClassRoom.entity.Orders;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("Select o from Orders o  where o.customer.customerId=:customerId")
    List<Orders> findOrdersByCustomerID(@Param("customer_id") Integer customer_id);

    @Query("Select o from Orders o inner join Customer c on o.customer.customerId=c.customerId")
    List<Orders> findOrders();

    @Query("select o.customer.customerId,sum(o.total_amount)as totalAmount,avg(o.total_amount)as avgAmount from Orders  o group by o.customer.customerId")
    List<CustomerAmountDTO> findTotalAmount();

    @NativeQuery("select o.customer_id,count(*) as total_orders from Orders o group by  o.customer_id")
    List<CustomerOrderDTO> findTotalOrders();

    @NativeQuery("select o.customer_id,sum(o.total_amount)as totalAmount,avg(o.total_amount)as avgAmount from Orders o where o.customer_id=:customer_id group by o.customer_id")
    List<CustomerAmountDTO> findTotalAvgSpent(@Param("customer_id") Integer customer_id);


}

