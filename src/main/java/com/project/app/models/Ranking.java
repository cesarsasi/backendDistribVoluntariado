package com.project.app.models;

public class Ranking {
    private Integer id;
    private Integer id_tarea;
    private Integer id_voluntario;
    private Integer puntaje;
    private Integer flg_invitado;
    private Integer flg_participa;
    private Integer invisible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getFlg_invitado() {
        return flg_invitado;
    }

    public void setFlg_invitado(Integer flg_invitado) {
        this.flg_invitado = flg_invitado;
    }

    public Integer getFlg_participa() {
        return flg_participa;
    }

    public void setFlg_participa(Integer flg_participa) {
        this.flg_participa = flg_participa;
    }

    public Integer getInvisible() {
        return invisible;
    }

    public void setInvisible(Integer invisible) {
        this.invisible = invisible;
    }


    
}
