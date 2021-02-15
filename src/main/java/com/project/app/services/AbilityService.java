package com.project.app.services;

import com.project.app.models.Ability;
import com.project.app.models.Institution;
import com.project.app.models.Volunteer;
import com.project.app.repositories.AbilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "abilities")
public class AbilityService {

    private final AbilityRepository habilidadRepository;
    AbilityService(AbilityRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }


}
