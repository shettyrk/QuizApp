package com.example.QuizApp.Services;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;
    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getQuestions() {
        return questionRepo.findAll();
    }

    public void addNewQuestion(Question question) {
//        Optional<Question> QuestionOptional = questionRepo.findByQuestionText(question.getQuestion_text());
//        if(QuestionOptional.isPresent()){
//            throw new IllegalStateException("Question Present");
//        }
        questionRepo.save(question);
    }

    public void deleteQuestion(Long questionId) {
        boolean exists =  questionRepo.existsById(questionId);
        if(!exists){
            throw new IllegalStateException("No question_id Found");
        }
        questionRepo.deleteById(questionId);
    }
    @Transactional
    public void updateQuestion(Long questionId, String questionText) {
        Question question = questionRepo.findById(questionId)
                .orElseThrow(() -> new IllegalStateException(
                        "question with id " + questionId + " does not exists"));
        if (questionText != null &&
                questionText.length() > 0 &&
                !Objects.equals(question.getQuestion_text(), questionText)) {
            question.setQuestion_text(questionText);
        }
    }

    public Optional<Question> getQuestionFew(Long question_id) {
        return questionRepo.findById(question_id);
    }
}
