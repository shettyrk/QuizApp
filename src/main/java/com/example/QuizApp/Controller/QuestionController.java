package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path= "api/v1/getAllQuestion")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }
    @PostMapping(path= "api/v1/addQuestion")
    public void addQuestions(@RequestBody Question question){
      questionService.addNewQuestion(question);
    }
    @PutMapping(path = "api/v1/updateQuestion/{question_id}")
    public void updateQuestion(
            @PathVariable("question_id") Long question_id,
            @RequestParam(required = false) String question_text
    ){
        questionService.updateQuestion(question_id,question_text);
    }

    @DeleteMapping(path = "api/v1/deleteQuestion/{question_id}")
    public void deleteQuestion(@PathVariable("question_id") Long question_id){
        questionService.deleteQuestion(question_id);
    }

}
