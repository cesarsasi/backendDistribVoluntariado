package com.project.app.services;

import com.project.app.models.Task;
import com.project.app.repositories.TaskRepository;
import com.project.app.repoSql.taskRepoSql;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "task")
public class TaskService {

    private final TaskRepository taskRepository;
    TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/count")
    public String countTasks(){
        long total = taskRepository.countTasks();
        return String.format("Tienes %s tareas", total);
    }

    @GetMapping("/getAll")
    public List<Task> getTasks(){
        return taskRepository.getTasks();
    }

    @PostMapping("/createTask")
    @ResponseBody
    public Task createTask(@RequestBody Task t){
        Task result = taskRepository.createTask(t);
        return result;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Task updateTask(@PathVariable(value = "id") ObjectId id, Task task){
        Task result = taskRepository.updateTask(id, task);
        return result;
    }

    @DeleteMapping("/deleteData/{id}")
    @ResponseBody
    public void deleteDataTask(@PathVariable(value = "id") ObjectId id){
        taskRepository.deleteDataTask(id);
    }


    @RequestMapping(value = "/getAllPostgres", method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getAllTask(){
        return this.taskRepository.getAllTasksPostgres();
    }

}

