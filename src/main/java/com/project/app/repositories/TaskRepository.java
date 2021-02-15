package com.project.app.repositories;

import com.project.app.models.Task;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository{
    public long countTasks();
    public List<Task> getTasks();
    public Task createTask(Task t);
    public Task updateTask (ObjectId id, Task task);
    public void deleteDataTask (ObjectId id);
    public List<Task> getAllTasksPostgres();
}
