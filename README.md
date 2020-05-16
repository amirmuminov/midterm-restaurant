# midterm-restaurant

## Restaurant management system.

Project contains the following entitites:

* MealCategory
* Meal
* Order
* Role (User's role)
* User
* Stock
* StockCategory

### MealCategory
This class describes the meal category

### Meal
This class describes the meal

#### Functionality:
* Get all meals
* Get one meal by id
* Save meal

### Order
This class describes the order. Only users with "WAITER" role have access to all operations with Order entity. Users with "ADMINISTRATOR" role has read only access.

#### Functionality:
* Get all orders
* Save order
* Add meal to the open order
* Close order and get bill
  
  
