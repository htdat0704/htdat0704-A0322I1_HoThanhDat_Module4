package baitap.book.repository;

import baitap.book.model.CTOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICTOrderRepository extends JpaRepository<CTOrder, Long> {
}
