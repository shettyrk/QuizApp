package com.example.QuizApp.Repo;

import com.example.QuizApp.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.user_email = ?1")
    Optional<Users> findUserByEmail(String user_email);
}
