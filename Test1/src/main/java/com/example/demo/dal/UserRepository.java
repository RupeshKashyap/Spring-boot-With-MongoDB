package com.example.demo.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
