package com.project.app.services;

import com.project.app.models.Institution;
import com.project.app.repositories.InstitutionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "institution")
public class InstitutionService {
    private final InstitutionRepository institucionRepository;

    InstitutionService(InstitutionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }


}
