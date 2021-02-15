package com.project.app.services;

import com.project.app.models.State_task;
import com.project.app.models.Ability;
import com.project.app.models.Institution;
import com.project.app.repositories.State_taskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "state_task")
public class State_taskService {
    private final State_taskRepository estado_tareaRepository;
    State_taskService(State_taskRepository estado_tareaRepository){
        this.estado_tareaRepository = estado_tareaRepository;
    }


}
