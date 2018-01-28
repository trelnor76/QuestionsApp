package com.wyzant.questions.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wyzant.questions.dto.out.AnswerDtoOut;
import com.wyzant.questions.entity.Answer;

@Mapper(componentModel="spring")
public interface AnswerDtoOutToAnswerMapper {

	AnswerDtoOut toAnswerDtoOut(Answer answer);
	List<AnswerDtoOut> toAnswerDtoOuts(List<Answer> answers);
	
}
