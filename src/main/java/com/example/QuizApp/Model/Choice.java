package com.example.QuizApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Choice")
public class Choice {
    @Id
    private Long cid;
    private String cName;
    private Boolean is_crt;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
