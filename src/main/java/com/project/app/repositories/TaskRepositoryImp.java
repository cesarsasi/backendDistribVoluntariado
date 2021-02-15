package com.project.app.repositories;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//#################################
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
//#################################

import com.project.app.models.Task;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class TaskRepositoryImp implements TaskRepository{

    @Autowired
    MongoDatabase database;
    private Sql2o sql2o;

    @Override
    public long countTasks(){
        MongoCollection<Document> collection = database.getCollection("task");
        long count = collection.countDocuments();
        return count;
    }


    @Override
    public List<Task> getTasks(){
        MongoCollection<Task> collection = database.getCollection("task", Task.class);
        List<Task> tasks = collection.find().into(new ArrayList<>());
        return tasks;
    }

    @Override
    public Task createTask(Task t){
        MongoCollection<Task> collection = database.getCollection("task", Task.class);
        collection.insertOne(t);
        return t;
    }

    @Override
    public Task updateTask (ObjectId id, Task task){
        MongoCollection<Task> collection = database.getCollection("task", Task.class);
        Document update = new Document("$set", task);
        collection.updateOne(eq("_id", new ObjectId(id.toString())), update);
        Task taskUpdate = collection.find(eq("_id", new ObjectId(id.toString()))).first();
        return taskUpdate;
    }

    @Override
    public void deleteDataTask (ObjectId id){
        MongoCollection<Task> collection = database.getCollection("task", Task.class);
        if(collection.find(eq("_id", new ObjectId(id.toString()))).first() != null){
            collection.deleteOne(eq("_id", new ObjectId(id.toString())));
            System.out.println("La tarea se elimino correctamente.");
        }else{
            System.out.println("No se encontro la tarea ha eliminar.");
        }
    }

    @Override
    public List<Task> getAllTasksPostgres(){
        try(Connection conn = sql2o.open()){
            final String query = "SELECT id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, cant_vol_inscritos, cant_vol_requeridos, invisible, hora, st_x(st_astext(location)) AS longitude, st_y(st_astext(location)) AS latitude FROM tarea";
            return conn.createQuery(query).executeAndFetch(Task.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
