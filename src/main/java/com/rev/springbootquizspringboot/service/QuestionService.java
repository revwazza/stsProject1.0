package com.rev.springbootquizspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rev.springbootquizspringboot.controller.QuestionController;
import com.rev.springbootquizspringboot.dao.QuestionDao;
import com.rev.springbootquizspringboot.exceptions.MyException;
import com.rev.springbootquizspringboot.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		//Custom Exception
		try {
			List<Question> questions = questionDao.findAll();
			if(questions.isEmpty()) {
				throw new MyException("601","Questions List is Empty! Please add questions!");
			}
			return questionDao.findAll(); 
		}catch(Exception e ) {
			throw new MyException("602","Something went wrong in the service layer while trying to fetch questions!");
		}
		 
	}

	public ResponseEntity<Question> getQuestionByCategory(String category) {
		//Exception for HTTP STATUS CODE - CHECK IN POSTMAN
		try {
			return new ResponseEntity(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST); 
	}

	public String addQuestion(Question question) {
			//Custom exception
		try {
			if(question.getQuestionTitle().isEmpty() || question.getQuestionTitle().isBlank() || question.getCorrectAnswer().isEmpty())
			{
				throw new MyException("603","Please Check Question title and Correct Answer"); 
			}
			questionDao.save(question);
			return "Success";
		}catch(IllegalArgumentException e){
			throw new MyException("604","Question title or answer is empty! " +e.getMessage());
		}catch(Exception e) {
			throw new MyException("605","Something went wrong in the service layer when trying to add question!");
		}	
	}

	public String deleteQuestion(Integer id) {
		questionDao.deleteById(id);
		return "Successfully Deleted";
	}

	public String updateQuestion(Question question,Integer id) {
		//Custom exception
		try {				
			if(question.getQuestionTitle().isEmpty() || question.getQuestionTitle().isBlank() || question.getCorrectAnswer().isEmpty())
			{
				throw new MyException("603","Please Check Question title and Correct Answer"); 				
				}
			questionDao.save(question);
			return "Successfully Updated!";				}
		catch(IllegalArgumentException e){
			throw new MyException("604","Question title or answer is empty! " +e.getMessage());
		}catch(Exception e) {
			throw new MyException("605","Something went wrong in the service layer when trying to update question!");
		}
	}


}
