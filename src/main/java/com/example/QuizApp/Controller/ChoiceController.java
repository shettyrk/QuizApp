package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Choice;
import com.example.QuizApp.Repo.ChoiceRepo;
import com.example.QuizApp.Services.ChoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChoiceController {
    private ChoiceService choiceService;

    @GetMapping(path = "api/v1/getChoice")
    public List<Choice>getChoice(){
        return choiceService.getChoice();
    }
}
