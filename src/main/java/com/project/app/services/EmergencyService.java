package com.project.app.services;

import com.project.app.models.Emergency;
import com.project.app.models.State_task;
import com.project.app.models.Institution;
import com.project.app.repositories.EmergencyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "emergencies")
public class EmergencyService {

    private final EmergencyRepository emergenciaRepository;
    EmergencyService(EmergencyRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }


}
