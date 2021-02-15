package com.project.app.models;

import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Date;
import org.bson.types.ObjectId;

public class Volunteer {
    @BsonId
    private ObjectId _id;
    @BsonId
    private ObjectId _idTask;

    private String name;
    private Date fbirth;


    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFbirth() {
        return fbirth;
    }

    public void setFbirth(Date fbirth) {
        this.fbirth = fbirth;
    }

    public ObjectId get_idTask() {
        return _idTask;
    }

    public void set_idTask(ObjectId _idTask) {
        this._idTask = _idTask;
    }
}
