package com.project.app.repoSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.sql.Time;
import java.util.List;

import com.project.app.models.TaskSql;

@Repository
public class taskRepoSqlImp implements taskRepoSql{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<TaskSql> getAllTaskSqls(){
        try(Connection conn = sql2o.open()){
            final String query = "SELECT id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, cant_vol_inscritos, cant_vol_requeridos FROM tarea0";
            return conn.createQuery(query).executeAndFetch(TaskSql.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public TaskSql getTasksByIds(Integer id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea0 WHERE id_estado = :id_est")
                    .executeAndFetchFirst(TaskSql.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskSql dataDistribution(TaskSql taskSql, String port, String numberTask){

        String DB_URL1 = "jdbc:postgresql://3.16.50.104:"+port+"/DB-Volunteering";
        String USER = "postgres";
        String PASS = "a1b2c3d4";
        Sql2o sql2o = new Sql2o(DB_URL1, USER, PASS);

        String sql ="INSERT INTO tarea"+numberTask+" (id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, " +
                "cant_vol_inscritos, cant_vol_requeridos, invisible) values(:id, :id_emergencia, :id_estado, " +
                ":nombre, :finicio, :ffin, :descrip, :cant_vol_inscritos, :cant_vol_requeridos, :invisible)";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", taskSql.getId())
                    .addParameter("id_emergencia", taskSql.getId_emergencia())
                    .addParameter("id_estado", taskSql.getId_estado())
                    .addParameter("nombre", taskSql.getNombre())
                    .addParameter("finicio", taskSql.getFinicio())
                    .addParameter("ffin", taskSql.getFfin())
                    .addParameter("descrip", taskSql.getDescrip())
                    .addParameter("cant_vol_inscritos", taskSql.getCant_vol_inscritos())
                    .addParameter("cant_vol_requeridos", taskSql.getCant_vol_requeridos())
                    .addParameter("invisible", taskSql.getInvisible())
                    .executeUpdate().getKey();
            return taskSql;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<TaskSql> getInactivesTasks(String port, String numberTask){

        String DB_URL1 = "jdbc:postgresql://3.16.50.104:"+port+"/DB-Volunteering";
        String USER = "postgres";
        String PASS = "a1b2c3d4";
        Sql2o sql2o1 = new Sql2o(DB_URL1, USER, PASS);
        String query = "SELECT * FROM tarea"+numberTask+" where invisible=1";
        try(Connection conn = sql2o1.open()){
            return conn.createQuery(query).executeAndFetch(TaskSql.class);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    @Override
    public TaskSql dataDistribution(TaskSql taskSql, String port, String numberTask){

        String DB_URL1 = "jdbc:postgresql://3.16.50.104:"+port+"/DB-Volunteering";
        String USER = "postgres";
        String PASS = "a1b2c3d4";
        Sql2o sql2o = new Sql2o(DB_URL1, USER, PASS);

        String sql ="INSERT INTO tarea"+numberTask+" (id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, " +
                "cant_vol_inscritos, cant_vol_requeridos, invisible) values(:id, :id_emergencia, :id_estado, " +
                ":nombre, :finicio, :ffin, :descrip, :cant_vol_inscritos, :cant_vol_requeridos, :invisible)";
        /*String sql2 ="INSERT INTO tarea1 (id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, " +
                "cant_vol_inscritos, cant_vol_requeridos, invisible) values(:id, :id_emergencia, :id_estado, " +
                ":nombre, :finicio, :ffin, :descrip, :cant_vol_inscritos, :cant_vol_requeridos, :invisible)";
        String sql3 ="INSERT INTO tarea2 (id, id_emergencia, id_estado, nombre, finicio, ffin, descrip, " +
                "cant_vol_inscritos, cant_vol_requeridos, invisible) values(:id, :id_emergencia, :id_estado, " +
                ":nombre, :finicio, :ffin, :descrip, :cant_vol_inscritos, :cant_vol_requeridos, :invisible)";

    Integer hashNumber = taskSql.getId()%3;

    */

}
