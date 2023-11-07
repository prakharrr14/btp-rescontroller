package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.models.questions;
import com.example.demo.models.user;



public interface question_interface extends MongoRepository<questions,Integer>,QueryByExampleExecutor<questions> {

 

}
