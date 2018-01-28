package com.wyzant.questions.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wyzant.questions.dto.in.AnswerDtoIn;
import com.wyzant.questions.dto.out.AnswerDtoOut;
import com.wyzant.questions.entity.Answer;
import com.wyzant.questions.entity.Question;
import com.wyzant.questions.mapper.AnswerDtoOutToAnswerMapper;
import com.wyzant.questions.mapper.AnswerDtoInToAnswerMapper;
import com.wyzant.questions.repository.AnswerJPARepository;
import com.wyzant.questions.repository.QuestionJPARepository;

@Service
public class AnswerService {

	private AnswerJPARepository answerJPARepository;
	private AnswerDtoOutToAnswerMapper answerDtoOutToAnswerMapper;
	private AnswerDtoInToAnswerMapper answerDtoInToAnswerMapper;
	private QuestionJPARepository questionJPARepository;
	
	



	public AnswerService(AnswerJPARepository answerJPARepository,QuestionJPARepository questionJPARepository,
			AnswerDtoOutToAnswerMapper answerDtoOutToAnswerMapper,AnswerDtoInToAnswerMapper answerDtoInToAnswerMapper) {
		this.answerJPARepository = answerJPARepository;
		this.questionJPARepository = questionJPARepository;
		this.answerDtoOutToAnswerMapper = answerDtoOutToAnswerMapper;
		this.answerDtoInToAnswerMapper = answerDtoInToAnswerMapper;
	}





	public List<AnswerDtoOut> getAnswers(String title) {
		return answerDtoOutToAnswerMapper.toAnswerDtoOuts(answerJPARepository.findByQuestionTitleOrderByUpvotes(title));//maybe order by upvotes?
	}





	public AnswerDtoOut postAnswer(String title, AnswerDtoIn answerDtoIn) {
		// TODO Auto-generated method stub
//		return null;
		
		Question question = questionJPARepository.findByTitle(title);
		if (question == null) {
			return null;
		}
		Answer answer = answerDtoInToAnswerMapper.toAnswer(answerDtoIn);
		answer.setQuestion(question);
		answer=answerJPARepository.saveAndFlush(answer);
		question.getAnswers().add(answer);
		questionJPARepository.saveAndFlush(question);
		return answerDtoOutToAnswerMapper.toAnswerDtoOut(answer);
	}





	public AnswerDtoOut getUpvoteByTitleContent(String title, Long id) {
		List<Answer> answers = questionJPARepository.findByTitle(title).getAnswers();
		if (answers == null) {
			return null;
		}
		for (Answer answer : answers) {
			if(answer.getId()==id) {
				answer.setUpvotes(answer.getUpvotes()+1);
				answer = answerJPARepository.save(answer);
				return answerDtoOutToAnswerMapper.toAnswerDtoOut(answer);
			}
		}
		return null;
	}





	public AnswerDtoOut getAcceptedByTitleContent(String title, Long id) {
		// TODO Auto-generated method stub
		Question question = questionJPARepository.findByTitle(title);
		List<Answer> answers = question.getAnswers();
		if (answers == null) {
			return null;
		}
		for (Answer answer : answers) {
			if(answer.getId()==id) {
				answer.setAccepted(true);
				answer = answerJPARepository.save(answer);
				question.setAnswered(true);
				question = questionJPARepository.save(question);
				return answerDtoOutToAnswerMapper.toAnswerDtoOut(answer);
			}
		}
		return null;
	}
}
