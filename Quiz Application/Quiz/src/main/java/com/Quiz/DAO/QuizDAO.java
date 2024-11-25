package com.Quiz.DAO;

import com.Quiz.Model.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<QuizModel, Integer> {

}
