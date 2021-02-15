package com.project.app.services;

import com.project.app.models.Institution;
import com.project.app.models.Vol_ability;
import com.project.app.models.Volunteer;
import com.project.app.models.Ability;
import com.project.app.repositories.Vol_abilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "vol_abs")
public class Vol_abilityService {

    private final Vol_abilityRepository vhRepo;
    Vol_abilityService(Vol_abilityRepository vhRepo){
        this.vhRepo = vhRepo;
    }


}
