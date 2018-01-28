package com.wyzant.questions.mapper;

import org.mapstruct.Mapper;

import com.wyzant.questions.dto.in.QuestionDtoIn;
import com.wyzant.questions.entity.Question;

@Mapper(componentModel="spring")
public interface QuestionDtoInToQuestionMapper {

	Question toQuestion(QuestionDtoIn questionDtoIn);
	
	
}
