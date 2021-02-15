package com.project.app.services;


import com.project.app.models.Eme_ability;
import com.project.app.models.Task;
import com.project.app.models.Task_ability;
import com.project.app.repositories.Task_abilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "task_abs")
public class Task_AbService {
    private final Task_abilityRepository task_abilityRepository;
    Task_AbService(Task_abilityRepository task_abilityRepository){
        this.task_abilityRepository = task_abilityRepository;
    }

}
