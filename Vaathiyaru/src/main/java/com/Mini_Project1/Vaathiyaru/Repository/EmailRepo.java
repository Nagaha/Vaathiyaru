package com.Mini_Project1.Vaathiyaru.Repository;

import com.Mini_Project1.Vaathiyaru.Model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepo extends MongoRepository<Email,Integer> {
}
