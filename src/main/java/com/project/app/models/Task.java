package com.project.app.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;

public class Task {

    @BsonId
    private ObjectId _id;
    private Integer id_emergencia;
    private Integer id_estado;
    private String nombre;
    private Date finicio;
    private Date ffin;
    private String descrip;
    private Integer cant_vol_inscritos;
    private Integer cant_vol_requeridos;
    private Integer invisible;

    public Integer getInvisible() {
        return invisible;
    }

    public void setInvisible(Integer invisible) {
        this.invisible = invisible;
    }

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public String getDescripcion() {
        return descrip;
    }

    public void setDescripcion(String descripcion) {
        this.descrip = descripcion;
    }

    public Integer getCant_vol_inscritos() {
        return cant_vol_inscritos;
    }

    public void setCant_vol_inscritos(Integer cant_vol_inscritos) {
        this.cant_vol_inscritos = cant_vol_inscritos;
    }

    public Integer getCant_vol_requeridos() {
        return cant_vol_requeridos;
    }

    public void setCant_vol_requeridos(Integer cant_vol_requeridos) {
        this.cant_vol_requeridos = cant_vol_requeridos;
    }

}