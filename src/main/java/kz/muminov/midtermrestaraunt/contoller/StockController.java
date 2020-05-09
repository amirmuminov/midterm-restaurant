package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.muminov.midtermrestaraunt.entity.Stock;
import kz.muminov.midtermrestaraunt.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(value = "Stock Management System")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all stocks")
    public List<Stock> getStocks(){
        return stockService.getStocks();
    }

}
