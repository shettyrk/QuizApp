package com.example.QuizApp.Services;

import com.example.QuizApp.Model.Users;
import com.example.QuizApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepo userRepo;
    @Autowired
    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    public void addNewUser(Users user) {
        Optional<Users> userOptional = userRepo.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        userRepo.save(user);
    }
    public void deleteUser(Long userId) {
        boolean exists =  userRepo.existsById(userId);
        if(!exists){
            throw new IllegalStateException("No id Found");
        }
        userRepo.deleteById(userId);
    }
    @Transactional
    public void updateUser(Long userId, String userName, String userEmail) {

        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exists"));

        if (userName != null &&
                userName.length() > 0 &&
                !Objects.equals(user.getName(), userName)) {
            user.setName(userName);
        }
        if (userEmail != null &&
                userEmail.length() > 0 &&
                !Objects.equals(user.getEmail(), userEmail)) {
            Optional<Users> userOptional = userRepo
                    .findUserByEmail(userEmail);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(userEmail);
        }
    }


}

