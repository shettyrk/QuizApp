package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Users;
import com.example.QuizApp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServices userServices;
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
            @PathVariable(value = "user_id") Long user_id,
            @RequestParam(required = false) String user_name,
            @RequestParam(required = false) String user_email,
            @RequestParam(required = false) String password
    ){
        userServices.updateUser(user_id,user_name,user_email,password);
    }
    @DeleteMapping(path = "api/v1/users/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id){
        userServices.deleteUser(user_id);
    }
}
