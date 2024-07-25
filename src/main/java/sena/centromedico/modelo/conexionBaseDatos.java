package sena.centromedico.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
public interface conexionBaseDatos {
    default Connection connectiontoDB(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/consultoriomedico","root","admin");
        }catch (Exception e){
        }finally{
            return connection;
        }
    }
}
