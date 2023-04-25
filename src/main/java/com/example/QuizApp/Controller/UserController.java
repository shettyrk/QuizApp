package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Users;
import com.example.QuizApp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServices userServices;
    private String userEmail;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @GetMapping(path= "api/v1/users")
    public List<Users> getUsers(){
        return userServices.getUsers();
    }
    @PostMapping(path= "api/v1/users")
    public void registerNewUser(@RequestBody Users user){
        userServices.addNewUser(user);
    }
    @PutMapping(path = "api/v1/users/{user_id}")
    public void updateUser(
            @PathVariable(value = "user_id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        userServices.updateUser(id,name,email);
    }
    @DeleteMapping(path = "api/v1/users/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id){
        userServices.deleteUser(user_id);
    }
}
