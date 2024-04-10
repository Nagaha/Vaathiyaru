package com.Mini_Project1.Vaathiyaru.Repository;

import com.Mini_Project1.Vaathiyaru.Model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutorRepo  extends MongoRepository<Tutor,Integer> {



    List<Tutor> findByExp(int i);

    List<Tutor> findByLocation(String offline);

    List<Tutor> findByHeading(String role);


}
