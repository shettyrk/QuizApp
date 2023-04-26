package com.example.QuizApp.Services;

import com.example.QuizApp.Model.Choices;
import com.example.QuizApp.Repo.ChoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {
    @Autowired
    private ChoiceRepo choiceRepo;

    public void addChoice(Choices choices) {
        choiceRepo.save(choices);
    }

}
