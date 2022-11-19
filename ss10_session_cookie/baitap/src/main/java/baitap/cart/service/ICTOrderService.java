package baitap.cart.service;

import baitap.cart.model.CTOrder;
import baitap.cart.model.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICTOrderService extends CRUDService<CTOrder>{
    List<CTOrder> listDetail(@Param("idOrder") long idOrder);
}
