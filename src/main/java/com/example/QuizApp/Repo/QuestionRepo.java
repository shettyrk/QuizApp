package com.example.QuizApp.Repo;

import com.example.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
//    Optional<Question> findByQuestionText(String question_text);
}
