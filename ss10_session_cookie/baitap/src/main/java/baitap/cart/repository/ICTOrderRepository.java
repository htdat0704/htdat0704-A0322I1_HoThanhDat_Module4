package baitap.cart.repository;

import baitap.cart.model.CTOrder;
import baitap.cart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ICTOrderRepository extends JpaRepository<CTOrder, Long> {
    @Transactional
    @Modifying
    @Query(value = "select ct.* from CTOrder ct where order_id = :idOrder", nativeQuery=true)
    List<CTOrder> listDetail(@Param("idOrder") long idOrder);
}
