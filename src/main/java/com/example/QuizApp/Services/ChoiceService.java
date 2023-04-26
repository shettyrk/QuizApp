package com.example.QuizApp.Services;

import com.example.QuizApp.Model.Choice;
import com.example.QuizApp.Repo.ChoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {
    @Autowired
    private final ChoiceRepo choiceRepo;

    public ChoiceService(ChoiceRepo choiceRepo) {
        this.choiceRepo = choiceRepo;
    }

    public List<Choice> getChoice() {
        return choiceRepo.findAll();
    }

    public void addNewChoice(Choice choice) {
        choiceRepo.save(choice);
    }
}
