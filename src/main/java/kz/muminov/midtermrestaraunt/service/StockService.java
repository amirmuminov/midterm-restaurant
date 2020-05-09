package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.entity.Stock;
import kz.muminov.midtermrestaraunt.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks(){
        return stockRepository.findAll();
    }

}
