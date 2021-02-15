package com.project.app.repositories;

import com.project.app.models.Task;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.project.app.models.Volunteer;

import static com.mongodb.client.model.Filters.eq;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


@Repository
public class VolunteerRepositorylmp implements VolunteerRepository{


    @Autowired
    MongoDatabase database;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long countVolunteers(){
        MongoCollection<Document> collection = database.getCollection("volunteer");
        long count = collection.countDocuments();
        return count;
    }


    @Override
    public List<Volunteer> getVolunteers(){
        MongoCollection<Volunteer> collection = database.getCollection("volunteer", Volunteer.class);
        List<Volunteer> volunteers = collection.find().into(new ArrayList<>());
        return volunteers;
    }

    @Override
    public List<Volunteer> getVolunteersRegisteredOnTask(Task t) {

        System.out.println(new ObjectId(t.getId().toString()));
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("task")
                .localField("_id")
                .foreignField("_idTask")
                .as("result");
        AggregationOperation match = Aggregation.match(Criteria.where("_idTask").is(t.getId()));
        Aggregation aggregation = Aggregation.newAggregation(
                lookupOperation,
                match);
        List<Volunteer> results = mongoTemplate.aggregate(aggregation, "volunteer", Volunteer.class).getMappedResults();
        return results;

    }

    @Override
    public Volunteer createVolunteer(Volunteer v){
        mongoTemplate.insert(v, "volunteer");
        return v;
    }

    @Override
    public Volunteer updateVolunteer (ObjectId id, Volunteer volunteer){
        MongoCollection<Volunteer> collection = database.getCollection("volunteer", Volunteer.class);
        Document update = new Document("$set", volunteer);
        collection.updateOne(eq("_id", new ObjectId(id.toString())), update);
        Volunteer volunteerUpdate = collection.find(eq("_id", new ObjectId(id.toString()))).first();
        return volunteerUpdate;
    }

    @Override
    public void deleteDataVolunteer(ObjectId id){
        MongoCollection<Volunteer> collection = database.getCollection("volunteer", Volunteer.class);
        if(collection.find(eq("_id", new ObjectId(id.toString()))).first() != null){
            collection.deleteOne(eq("_id", new ObjectId(id.toString())));
            System.out.println("El voluntario se elimino correctamente.");
        }else{
            System.out.println("No se encontro el voluntario ha eliminar.");
        }
    }
}
