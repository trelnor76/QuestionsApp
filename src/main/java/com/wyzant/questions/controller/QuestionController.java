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

import com.wyzant.questions.dto.in.QuestionDtoIn;
import com.wyzant.questions.dto.out.QuestionDtoOut;
import com.wyzant.questions.service.QuestionService;

@RestController
@RequestMapping("questions")
@CrossOrigin(origins = "http://localhost:8080")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping
	public List<QuestionDtoOut> getQuestions(HttpServletResponse response)
	{
		//return a list of questions
		List<QuestionDtoOut> results = questionService.getQuestions();
		if(results == null || results.isEmpty())
			response.setStatus(404);
		return results;
	}
	
	@PostMapping
	public QuestionDtoOut postQuestion(@RequestBody QuestionDtoIn question, HttpServletResponse response) 
	{
		QuestionDtoOut result = questionService.postQuestion(question);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;
	}
	
	@GetMapping("title/{title}")
	public QuestionDtoOut getQuestionByTitle(@PathVariable String title, HttpServletResponse response)
	{
		QuestionDtoOut result = questionService.getQuestionByTitle(title);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;
	}
	
	@GetMapping("/answered")
	public List<QuestionDtoOut> getAnsweredQuestions(HttpServletResponse response)
	{
		List<QuestionDtoOut> results = questionService.getAnsweredQuestions();
		if(results == null || results.isEmpty())
			response.setStatus(404);
		return results;
	}
	
	@GetMapping("/unanswered")
	public List<QuestionDtoOut> getUnansweredQuestions(HttpServletResponse response)
	{
		List<QuestionDtoOut> results = questionService.getUnansweredQuestions();
		if(results == null || results.isEmpty())
			response.setStatus(404);
		return results;
	}
	
	//should probably do taggedby
	@GetMapping("tags/{tags}")
	public List<QuestionDtoOut> getTagsByTitle(@PathVariable String tags, HttpServletResponse response)
	{
		List<QuestionDtoOut> results = (List<QuestionDtoOut>) questionService.getTagsByTitle(tags);
		if(results == null || results.isEmpty())
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return results;
	}	
	
	//should probably do a search
	@GetMapping("content/{content}")
	public List<QuestionDtoOut> getContentByTitle(@PathVariable String content, HttpServletResponse response)
	{
		List<QuestionDtoOut> results = (List<QuestionDtoOut>) questionService.getContentByTitle(content);
		if(results == null || results.isEmpty())
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return results;
	}	

	//should have a way to mark as answered
	@GetMapping("answered/{title}")
	public QuestionDtoOut getAnsweredByTitle(@PathVariable String title, HttpServletResponse response)
	{
		QuestionDtoOut result = questionService.getAnsweredByTitle(title);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;		
	}
	
	//should have a way to upvote
	@GetMapping("upvote/{title}")
	public QuestionDtoOut getUpvoteByTitle(@PathVariable String title, HttpServletResponse response)
	{
		QuestionDtoOut result = questionService.getUpvoteByTitle(title);
		if(result == null)
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return result;		
	}
}
