package com.project.app.services;

import com.project.app.models.Task;
import com.project.app.models.TaskSql;
import com.project.app.repoSql.taskRepoSql;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "taskSql")
public class TaskServiceSql {

    private final com.project.app.repoSql.taskRepoSql taskRepoSql;
    TaskServiceSql(taskRepoSql taskRepoSql) {this.taskRepoSql = taskRepoSql;}

    @GetMapping("/getAllSql")
    public List<TaskSql> getTasksSql(){
        return taskRepoSql.getAllTaskSqls();
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskSql getTaskById(@PathVariable(value = "id") Integer id){
        return this.taskRepoSql.getTasksByIds(id);
    }

    @PutMapping("/dataDistribution")
    @ResponseBody
    public TaskSql dataDistribution(TaskSql task){
        // funcion hash para seleccionar uno de los tres servidores
        int hashNumber = task.getId()%3;
        int port = 54032+hashNumber;
        TaskSql result = taskRepoSql.dataDistribution(task, String.valueOf(port), String.valueOf(hashNumber));
        return result;
    }

    @GetMapping("/getInactivesTasks")
    public List<TaskSql> getInactivesTasks(){
        int j;
        List<TaskSql> listTask;
        List<TaskSql> listAux = new ArrayList<>();
        for(j=0;j<=2;j++){
            listTask = taskRepoSql.getInactivesTasks(String.valueOf(j+54032), String.valueOf(j));
            listAux.addAll(listTask);
        }
        return listAux;
    }

}
