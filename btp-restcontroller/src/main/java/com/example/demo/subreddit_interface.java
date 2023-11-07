package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.models.subreddit;
import com.example.demo.models.user;



public interface subreddit_interface extends MongoRepository<subreddit,Integer>,QueryByExampleExecutor<subreddit> {



}
