package com.Question.Service;

import com.Question.DAO.QuestionDAO;
import com.Question.Model.QuestionModel;
import com.Question.Model.QuestionWrapper;
import com.Question.Model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<QuestionModel> getAllQuestion() {
        return questionDAO.findAll();
    }

    public String createQuestion(QuestionModel question) {
        return questionDAO.save(question).toString();
    }

    public List<QuestionModel> getQuestionByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDAO.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<QuestionModel> questions = new ArrayList<>();

        for(Integer id : questionIds){
            questions.add(questionDAO.findById(id).get());
        }

        for(QuestionModel question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestion(question.getQuestion());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<ResponseModel> responses) {

        int right = 0;

        for(ResponseModel response : responses){
            QuestionModel question = questionDAO.findById(response.getId()).get();
            if(response.getResponse().equals(question.getAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
    }
