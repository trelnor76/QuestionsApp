package com.wyzant.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wyzant.questions.entity.Answer;

public interface AnswerJPARepository extends JpaRepository<Answer, Long> {

	List<Answer> findByQuestionTitleOrderByUpvotes(String title);
	
}
