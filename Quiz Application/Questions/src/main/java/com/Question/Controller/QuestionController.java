package com.Question.Controller;

import com.Question.Model.QuestionModel;
import com.Question.Model.QuestionWrapper;
import com.Question.Model.ResponseModel;
import com.Question.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;


import java.util.List;

@RestController
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("/GetAll")
    public ResponseEntity<List<QuestionModel>> getAllQuestion(){
        try {
            return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.FOUND);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getCategory/{category}")
    public List<QuestionModel> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/save")
    public String create(@RequestBody QuestionModel Question){
        return questionService.createQuestion(Question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseModel> responses)
    {
        return questionService.getScore(responses);
    }
    
}
