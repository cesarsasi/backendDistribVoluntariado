package com.project.app.repositories;

import com.project.app.models.Eme_ability;
import com.project.app.models.Ability;
import com.project.app.models.Institution;
import com.project.app.models.State_task;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface State_taskRepository extends MongoRepository<State_task, String>{



}
