package com.wyzant.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wyzant.questions.entity.Question;


public interface QuestionJPARepository  extends JpaRepository<Question, Long>{
	
	List<Question> findByTagsIn(String tags);
	Question findByTitle(String title);
	List<Question> findByAnswered(boolean answered);
	List<Question> findAllByOrderByUpvotes();
	List<Question> findByContentIgnoreCaseContaining(String content);
	
}

