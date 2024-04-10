package com.Mini_Project1.Vaathiyaru.Repository;

import com.Mini_Project1.Vaathiyaru.Model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SearchRepo {
     List<Tutor> findByText(String text);
}
