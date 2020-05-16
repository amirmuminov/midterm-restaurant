# midterm-restaurant

Project contains the following entities:

* MealCategory
* Meal
* Order
* Role (User's role)
* User
* Stock
* StockCategory

### MealCategory
This class describes the meal category.

### Meal
This class describes the meal - price, name, category etc.

#### Functionality:
* Get all meals
* Get one meal by id
* Save meal

### Order
This class describes the order - meals, order date, who has accepted order. Only users with "WAITER" role have access to all operations with Order entity. Users with "ADMINISTRATOR" role has read only access.

#### Functionality:
* Get all orders
* Save order
* Add meal to the open order
* Close order and get bill

### Role
This class describes user's role.

#### Functionality:
* Get all roles

### User
This class describes the user - username, password, roles etc.

Administrator can fire another staff members, look through the staff members. Another roles doesn't have access to the User class.

#### Functionality
* Get all users
* Get one user by id
* Sign up
* Delete user
* Sign in

### Stock
This class describes stock - beginning and ending dates, description, meals participate in the stock.

### StockCategory 
This class describes the stock category.
>>>>>>> 513bcfdf8755e70db57ec344314725ef04b5691c
  
  
