package com.project.app.services;

import com.project.app.models.Task;
import com.project.app.models.Volunteer;
import com.project.app.repositories.VolunteerRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "volunteer")
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;
    VolunteerService(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    @GetMapping("/count")
    public String countVolunteers(){
        long total = volunteerRepository.countVolunteers();
        return String.format("Tienes %s voluntarios", total);
    }

    @GetMapping("/getAll")
    public List<Volunteer> getVolunteers(){
        return volunteerRepository.getVolunteers();
    }

    @GetMapping("/registered")
    public List<Volunteer> volunteerRegistered(@RequestBody Task t){
        return volunteerRepository.getVolunteersRegisteredOnTask(t);
    }

    @PostMapping("/createVolunteer")
    @ResponseBody
    public Volunteer createVolunteer(@RequestBody Volunteer t){
        Volunteer result = volunteerRepository.createVolunteer(t);
        return result;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Volunteer updateVolunteer(@PathVariable(value = "id") ObjectId id, Volunteer volunteer){
        Volunteer result = volunteerRepository.updateVolunteer(id, volunteer);
        return result;
    }

    @DeleteMapping("/deleteData/{id}")
    @ResponseBody
    public void deleteDataVolunteer(@PathVariable(value = "id") ObjectId id){
        volunteerRepository.deleteDataVolunteer(id);
    }
}
