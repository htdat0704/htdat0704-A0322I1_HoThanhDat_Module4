package baitap.book.repository;

import baitap.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query(value="update book b set quantity = :quantity where b.id= :id", nativeQuery=true)
    void rentalBook(@Param("quantity") int quantity,@Param("id") long id);
}
