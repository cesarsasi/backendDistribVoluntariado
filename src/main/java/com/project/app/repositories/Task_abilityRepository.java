package com.project.app.repositories;

import com.project.app.models.Task_ability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Task_abilityRepository extends MongoRepository<Task_ability, String> {



}
