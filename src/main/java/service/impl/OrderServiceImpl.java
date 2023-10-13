package service.impl;

import base.service.BaseServiceImpl;
import entity.Order;
import repository.OrderRepository;
import service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Order,Long, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
