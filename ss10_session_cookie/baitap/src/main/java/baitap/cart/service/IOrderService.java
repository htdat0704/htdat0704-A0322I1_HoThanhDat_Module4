package baitap.cart.service;

import baitap.cart.model.Order;

public interface IOrderService extends CRUDService<Order>{
    long saveAndFlush(Order order);
}
