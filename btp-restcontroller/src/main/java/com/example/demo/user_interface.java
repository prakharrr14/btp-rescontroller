package com.example.demo;

import org.springframework.data.mongodb.repository.*;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.models.user;


public interface user_interface  extends MongoRepository<user,String>,QueryByExampleExecutor<user> {



}
