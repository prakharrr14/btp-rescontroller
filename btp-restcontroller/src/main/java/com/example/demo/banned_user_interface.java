package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.models.bannesUsers;
import com.example.demo.models.user;

public interface banned_user_interface extends MongoRepository<bannesUsers,String>{

}
