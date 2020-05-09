package kz.muminov.midtermrestaraunt.repository;

import kz.muminov.midtermrestaraunt.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
