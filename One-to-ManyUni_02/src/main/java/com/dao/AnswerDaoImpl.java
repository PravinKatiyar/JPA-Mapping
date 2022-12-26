package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Answer;

@Repository
public interface AnswerDaoImpl extends JpaRepository<Answer, Integer> {

}
