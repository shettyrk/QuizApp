package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Choices;
import com.example.QuizApp.Services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;
    @PostMapping("/user/addChoice")
    public void addChoice(@RequestBody Choices choices){
        choiceService.addChoice(choices);
    }
//    @GetMapping("/user/getChoice")
//    public Choices getChoice(Choices choices){
//        return choiceService.getChoice(choices);
//    }
}
