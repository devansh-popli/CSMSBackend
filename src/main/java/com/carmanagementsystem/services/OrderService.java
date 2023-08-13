package com.carmanagementsystem.services;

import com.carmanagementsystem.services.impl.TransactionDetails;
import com.carmanagementsystem.dtos.OrderDto;
import com.carmanagementsystem.dtos.PageableResponse;
import com.razorpay.RazorpayException;

import java.util.List;

public interface OrderService {

    //create order
    OrderDto createOrder(OrderDto orderDto, String userId, String cartId);


    //remove order
    void removeOrder(String orderId);
    //get orders of users

    List<OrderDto> getOrdersOfUsers(String userId);

    //get orders
    PageableResponse<OrderDto> getOrders(int pageNumber, int pageSize, String sortBy, String sortDir);
    public TransactionDetails createTransaction(Long amount) throws RazorpayException ;
    OrderDto updateOrder(OrderDto orderDto, String orderId);
}
