package com.project.app.repositories;

import com.project.app.models.Ranking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends MongoRepository<Ranking, String> {




}
