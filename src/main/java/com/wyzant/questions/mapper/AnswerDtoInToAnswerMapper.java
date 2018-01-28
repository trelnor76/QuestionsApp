package com.wyzant.questions.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wyzant.questions.dto.in.AnswerDtoIn;
import com.wyzant.questions.entity.Answer;

@Mapper(componentModel="spring")
public interface AnswerDtoInToAnswerMapper {

	Answer toAnswer(AnswerDtoIn answerDtoIn);
	List<Answer> toAnswers(List<AnswerDtoIn> toAnswer);
	
}
