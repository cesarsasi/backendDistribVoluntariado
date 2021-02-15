package com.project.app.services;

import com.project.app.models.Ranking;
import com.project.app.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "ranking")
public class RankingService {
    public final RankingRepository rankingRepository;
    RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }


}
