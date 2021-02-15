package com.project.app.models;

public class Institution {
    private Integer id;
    private String nombre;
    private String descrip;
    private Integer invisible;

    public String getDescrip() {
        return descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getInvisible() {
        return invisible;
    }

    public void setInvisible(Integer invisible) {
        this.invisible = invisible;
    }
    
}
