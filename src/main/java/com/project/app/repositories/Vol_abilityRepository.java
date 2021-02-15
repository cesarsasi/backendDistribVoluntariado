package com.project.app.repositories;

import com.project.app.models.Vol_ability;
import com.project.app.models.Volunteer;
import com.project.app.models.Ability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Vol_abilityRepository extends MongoRepository<Vol_ability, String> {


}
