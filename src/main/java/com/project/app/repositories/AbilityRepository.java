package com.project.app.repositories;

import com.project.app.models.Ability;
import com.project.app.models.Institution;
import com.project.app.models.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AbilityRepository extends MongoRepository<Ability, String> {




}
