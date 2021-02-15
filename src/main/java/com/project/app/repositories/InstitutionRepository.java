package com.project.app.repositories;

import com.project.app.models.Institution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends MongoRepository<Institution, String> {



}
