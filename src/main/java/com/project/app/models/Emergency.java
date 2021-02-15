package com.project.app.models;
import java.sql.Date;

public class Emergency {
    private Integer id;
    private Integer id_institucion;
    private String nombre;
    private Date finicio;
    private Date ffin;
    private String descrip;
    private Integer invisible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getInvisible() {
        return invisible;
    }

    public void setInvisible(Integer invisible) {
        this.invisible = invisible;
    }


    
}
