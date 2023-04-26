package com.example.QuizApp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Question")
public class Question {
    @Id
    private Long question_id;
    @Column(name = "question_text")
    private String question_text;



    public Question(String question_text) {
        this.question_text = question_text;
    }
}
