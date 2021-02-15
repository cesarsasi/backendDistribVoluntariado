package com.project.app.services;

import com.project.app.models.Eme_ability;
import com.project.app.models.Emergency;
import com.project.app.models.Institution;
import com.project.app.repositories.Eme_abilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "eme_abs")
public class Eme_abilityService {

    private final Eme_abilityRepository eme_habilidadRepository;
    Eme_abilityService(Eme_abilityRepository eme_habilidadRepository){
        this.eme_habilidadRepository = eme_habilidadRepository;
    }


}
