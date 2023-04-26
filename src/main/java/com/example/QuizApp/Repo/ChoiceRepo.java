package com.example.QuizApp.Repo;

import com.example.QuizApp.Model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepo extends JpaRepository<Choice,Long> {
}
