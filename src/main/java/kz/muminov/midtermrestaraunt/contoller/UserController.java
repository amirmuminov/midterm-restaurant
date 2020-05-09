package kz.muminov.midtermrestaraunt.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.muminov.midtermrestaraunt.entity.User;
import kz.muminov.midtermrestaraunt.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "User Management System")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get all users", response = List.class)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find user by ID", response = User.class)
    public User getUser(@ApiParam(value = "ID to find the user") @PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping
    @ApiOperation(value = "Save user", response = User.class)
    public User saveUser(@ApiParam(value = "User object to save") @RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user by ID", response = String.class)
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
