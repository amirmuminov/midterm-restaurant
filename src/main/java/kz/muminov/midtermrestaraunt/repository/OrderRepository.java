package kz.muminov.midtermrestaraunt.repository;

import kz.muminov.midtermrestaraunt.entity.Order;
import kz.muminov.midtermrestaraunt.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdAndStatus(Long id, OrderStatus orderStatus);

    @Query("SELECT SUM(m.price) FROM Meal m JOIN m.orders o WHERE o.id = :orderId")
    double calculateBill(@Param("orderId") Long orderId);

}
