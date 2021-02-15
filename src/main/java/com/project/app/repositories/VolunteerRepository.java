package com.project.app.repositories;

import com.project.app.models.Task;
import com.project.app.models.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository{
    public long countVolunteers();
    public List<Volunteer> getVolunteers();
    public List<Volunteer> getVolunteersRegisteredOnTask(Task t);
    public Volunteer createVolunteer(Volunteer v);
    public Volunteer updateVolunteer(ObjectId id, Volunteer volunteer);
    public void deleteDataVolunteer(ObjectId id);

}
