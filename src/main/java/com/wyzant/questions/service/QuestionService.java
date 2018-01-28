package com.wyzant.questions.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wyzant.questions.dto.in.QuestionDtoIn;
import com.wyzant.questions.dto.out.QuestionDtoOut;
import com.wyzant.questions.entity.Question;
import com.wyzant.questions.mapper.QuestionDtoInToQuestionMapper;
import com.wyzant.questions.mapper.QuestionDtoOutToQuestionMapper;
import com.wyzant.questions.repository.QuestionJPARepository;

@Service
public class QuestionService {

	private QuestionJPARepository questionJPARepository;
	private QuestionDtoInToQuestionMapper questionDtoInToQuestionMapper;
	private QuestionDtoOutToQuestionMapper questionDtoOutToQuestionMapper;

	
	

	public QuestionService(QuestionJPARepository questionJPARepository,
			QuestionDtoInToQuestionMapper questionDtoInToQuestionMapper,
			QuestionDtoOutToQuestionMapper questionDtoOutToQuestionMapper) {
		this.questionJPARepository = questionJPARepository;
		this.questionDtoInToQuestionMapper = questionDtoInToQuestionMapper;
		this.questionDtoOutToQuestionMapper = questionDtoOutToQuestionMapper;
	}

	public List<QuestionDtoOut> getQuestions() {
		// TODO Auto-generated method stub
		System.out.println("Mapper stuff");
		System.out.println(Arrays.toString(questionDtoOutToQuestionMapper.getClass().getMethods()));
		return questionDtoOutToQuestionMapper.toQuestionDtoOuts(questionJPARepository.findAll());//ByOrderByUpvotes());
	}

	public QuestionDtoOut postQuestion(QuestionDtoIn questionDtoIn) {
		
//		make sure the title is unique
		if(questionJPARepository.findByTitle(questionDtoIn.getTitle()) != null)
		{
			System.out.println("Am I null?" + "  NO!");
			return null;
		}
		return questionDtoOutToQuestionMapper.toQuestionDtoOut(questionJPARepository.save(questionDtoInToQuestionMapper.toQuestion(questionDtoIn)));
	}

	public QuestionDtoOut getQuestionByTitle(String title) {
		// TODO Auto-generated method stub
		return questionDtoOutToQuestionMapper.toQuestionDtoOut(questionJPARepository.findByTitle(title));
	}

	public List<QuestionDtoOut> getUnansweredQuestions() {
		// TODO Auto-generated method stub
		return questionDtoOutToQuestionMapper.toQuestionDtoOuts(questionJPARepository.findByAnswered(false));
	}

	public List<QuestionDtoOut> getAnsweredQuestions() {
		// TODO Auto-generated method stub
		return questionDtoOutToQuestionMapper.toQuestionDtoOuts(questionJPARepository.findByAnswered(true));
	}

	public QuestionDtoOut getUpvoteByTitle(String title) {
		// TODO Auto-generated method stub
		Question question = questionJPARepository.findByTitle(title);
		if (question == null) {
			return null;
		}
		question.setUpvotes(question.getUpvotes()+1);
		question = questionJPARepository.save(question);
		return questionDtoOutToQuestionMapper.toQuestionDtoOut(question);
	}

	public QuestionDtoOut getAnsweredByTitle(String title) {
		// TODO Auto-generated method stub
		Question question = questionJPARepository.findByTitle(title);
		if (question == null) {
			return null;
		}
		question.setAnswered(true);
		question = questionJPARepository.save(question);
		return questionDtoOutToQuestionMapper.toQuestionDtoOut(question);
	}

	public List<QuestionDtoOut> getTagsByTitle(String tags) {
		// TODO Auto-generated method stub
		List<Question> questions = questionJPARepository.findAll();
		List<Question> filterQuestion = questions.stream()
		.filter(question -> {return Arrays.asList(question.getTags()).contains(tags);})
		.collect(Collectors.toList());
		return questionDtoOutToQuestionMapper.toQuestionDtoOuts(filterQuestion);
	}


	public List<QuestionDtoOut> getContentByTitle(String content) {
		// TODO Auto-generated method stub
		return questionDtoOutToQuestionMapper.toQuestionDtoOuts(questionJPARepository.findByContentIgnoreCaseContaining(content));
	}
	
}
