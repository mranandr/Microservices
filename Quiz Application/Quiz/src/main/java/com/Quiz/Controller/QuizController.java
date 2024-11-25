package com.Quiz.Controller;

import com.Quiz.Model.QuestionWrapper;
import com.Quiz.Model.QuizDTO;
import com.Quiz.Model.ResponseModel;
import com.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO ){
        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNumQ(),quizDTO.getTitle());
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable Integer id){
        return  quizService.getQuizById(id);
            }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(
            @PathVariable Integer id,
            @RequestBody List<ResponseModel> responses) {
        return quizService.calculateResult(id, responses);
    }
}
