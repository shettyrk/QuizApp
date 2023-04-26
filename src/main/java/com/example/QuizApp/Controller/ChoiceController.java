package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Choice;
import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChoiceController {
    @Autowired
    private final ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("api/v1/getChoice")
    public List<Choice> getChoice(){
        return choiceService.getChoice();

    }
    @PostMapping(path= "api/v1/addChoice")
    public void addNewChoice(@RequestBody Choice choice){
        choiceService.addNewChoice(choice);
    }
}
