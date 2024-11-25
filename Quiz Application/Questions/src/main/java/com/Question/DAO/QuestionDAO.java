package com.Question.DAO;

import com.Question.Model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<QuestionModel, Integer> {
    List<QuestionModel> findByCategory(String category);

    @Query(value ="Select * from questions q where q.category =:category order by Random() Limit :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}

