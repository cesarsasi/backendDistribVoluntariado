package com.project.app.models;

public class Vol_ability {
    private int id;
    private Integer id_habilidad;
    private Integer id_voluntario;
    private Integer invisible;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getInvisible() { return invisible; }

    public void setInvisible(Integer invisible) { this.invisible = invisible; }
}
