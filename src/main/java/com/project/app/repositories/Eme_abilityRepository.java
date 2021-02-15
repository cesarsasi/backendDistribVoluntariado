package com.project.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.app.models.Eme_ability;
import com.project.app.models.Emergency;
import com.project.app.models.Institution;

import java.util.List;

@Repository
public interface Eme_abilityRepository extends MongoRepository<Eme_ability, String>{

    Eme_ability findEme_abilitiesById(String id);

}
