package com.project.app.repositories;

import com.project.app.models.Emergency;
import com.project.app.models.State_task;
import com.project.app.models.Institution;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface EmergencyRepository extends MongoRepository<Emergency, String>{



}
