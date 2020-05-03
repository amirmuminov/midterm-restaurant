package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.muminov.midtermrestaraunt.entity.Order;
import kz.muminov.midtermrestaraunt.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order management system")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all orders", response = List.class)
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping("")
    @ApiOperation(value = "Save a new order", response = Order.class)
    public Order createOrder(@ApiParam(value = "Object to be saved into the database") @RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("/{orderId}/{mealId}")
    @ApiOperation(value = "Add a new meal to the existing order", response = Order.class)
    public Order addMealToOrder(
            @ApiParam(value = "ID to find the order") @PathVariable Long orderId,
            @ApiParam(value = "ID to find the meal") @PathVariable Long mealId
    ){
        return orderService.addMealToOrder(orderId, mealId);
    }

    @GetMapping("/{orderId}/bill")
    @ApiOperation(value = "Calculate bill of the order", response = double.class)
    public double calculateBill(@ApiParam(value = "Order ID to calculate the bill of this order") @PathVariable Long orderId){
        return orderService.calculateBill(orderId);
    }

}
