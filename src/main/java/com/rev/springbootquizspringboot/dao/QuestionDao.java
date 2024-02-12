package com.rev.springbootquizspringboot.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.springbootquizspringboot.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	List<Question> findByCategory(String category);

}
