package com.project.app.repoSql;

import java.util.List;

import com.project.app.models.TaskSql;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepoSql{

    public List<TaskSql> getAllTaskSqls();
    public TaskSql getTasksByIds(Integer id);
    public TaskSql dataDistribution(TaskSql taskSql, String port, String numberTask);
    public List<TaskSql> getInactivesTasks(String port, String numberTask);
}