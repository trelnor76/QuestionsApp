package com.wyzant.questions.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wyzant.questions.dto.out.QuestionDtoOut;
import com.wyzant.questions.entity.Question;

@Mapper(componentModel="spring")
public interface QuestionDtoOutToQuestionMapper {

	QuestionDtoOut toQuestionDtoOut(Question question);
	
	List<QuestionDtoOut> toQuestionDtoOuts(List<Question> questions);
	
}
