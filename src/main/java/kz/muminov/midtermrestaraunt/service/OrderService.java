package kz.muminov.midtermrestaraunt.service;

import javassist.NotFoundException;
import kz.muminov.midtermrestaraunt.entity.Meal;
import kz.muminov.midtermrestaraunt.entity.Order;
import kz.muminov.midtermrestaraunt.entity.User;
import kz.muminov.midtermrestaraunt.enums.OrderStatus;
import kz.muminov.midtermrestaraunt.exception.types.MealNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.OrderNotFoundException;
import kz.muminov.midtermrestaraunt.exception.types.UserNotFoundException;
import kz.muminov.midtermrestaraunt.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final MealService mealService;

    public OrderService(OrderRepository orderRepository, UserService userService, MealService mealService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.mealService = mealService;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order createOrder(Order order){
        User user = userService.getUser(order.getPickerId());
        List<Meal> meals = new ArrayList<>();
        if (user != null){
            order.setOrderPicker(user);
            for (Meal meal: order.getMeals()) {
                Meal newMeal = mealService.getMealById(meal.getId());
                if(newMeal != null){
                    meals.add(newMeal);
                }else{
                    throw new MealNotFoundException(meal.getId());
                }
            }
            order.setMeals(meals);
            return orderRepository.save(order);
        }
        else{
            throw new UserNotFoundException();
        }
    }


    public Order addMealToOrder(Long orderId, Long mealId) {
        Order order = orderRepository.findByIdAndStatus(orderId, OrderStatus.NOT_PAYED).orElse(null);
        if (order != null){
            Meal meal = mealService.getMealById(mealId);
            if (meal != null){
                order.getMeals().add(meal);
                return orderRepository.save(order);
            }else {
                throw new MealNotFoundException();
            }
        }else{
            throw new OrderNotFoundException();
        }
    }

    public double calculateBill(Long orderId){
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order != null){
            order.setStatus(OrderStatus.PAYED);
            orderRepository.save(order);
            return orderRepository.calculateBill(orderId);
        }else{
            throw new OrderNotFoundException();
        }
    }

}
