package com.Quiz.Service;

import com.Quiz.DAO.QuizDAO;
import com.Quiz.Model.QuestionWrapper;
import com.Quiz.Model.QuizModel;
import com.Quiz.Model.ResponseModel;
import com.Quiz.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Integer> question = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        QuizModel quiz = new QuizModel();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizDAO.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(Integer id) {
        QuizModel quiz = quizDAO.findById(id).get();
          List<Integer> questionId = quiz.getQuestions();
          ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionId);
          return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<ResponseModel> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
