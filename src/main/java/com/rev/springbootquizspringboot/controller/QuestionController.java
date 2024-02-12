package com.rev.springbootquizspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.springbootquizspringboot.model.Question;
import com.rev.springbootquizspringboot.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<Question> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);	
	}
	
	
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@RequestBody Question question,@PathVariable Integer id) {
		return questionService.updateQuestion(question,id);
	}
	
}
