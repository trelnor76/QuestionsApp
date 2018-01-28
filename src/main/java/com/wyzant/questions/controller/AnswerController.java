package com.wyzant.questions.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyzant.questions.dto.in.AnswerDtoIn;
import com.wyzant.questions.dto.out.AnswerDtoOut;
import com.wyzant.questions.dto.out.QuestionDtoOut;
import com.wyzant.questions.service.AnswerService;

@RestController
@RequestMapping("answers")
@CrossOrigin
public class AnswerController {

	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@GetMapping("/{title}")
	public List<AnswerDtoOut> getAnswers(@PathVariable String title, HttpServletResponse response)
	{
		List<AnswerDtoOut> results = answerService.getAnswers(title);
		if(results == null || results.isEmpty())
			response.setStatus(404);
		return results;
	}
	
	@PostMapping("/{title}")
	public AnswerDtoOut postAnswer(@PathVariable String title, @RequestBody AnswerDtoIn answerDtoIn, HttpServletResponse response)
	{
		AnswerDtoOut result = answerService.postAnswer(title, answerDtoIn);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;
	}
	
	//should have a way to upvote
	@GetMapping("upvote/{title}/{id}")
	public AnswerDtoOut getUpvoteByTitleContent(@PathVariable String title,@PathVariable Long id, HttpServletResponse response)
	{
		AnswerDtoOut result = answerService.getUpvoteByTitleContent(title,id);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;		
	}
	
	//should have a way to mark as 'accepted answer'
	@GetMapping("accepted/{title}/{id}")
	public AnswerDtoOut getAcceptedByTitleContent(@PathVariable String title,@PathVariable Long id, HttpServletResponse response)
	{
		AnswerDtoOut result = answerService.getAcceptedByTitleContent(title,id);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;		
	}
}
