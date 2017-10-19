/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Esquema;
import model.contextoNavegacion;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class ContextoDAO {
    private Connection connection;

    public ContextoDAO() {
        connection = DbUtil.getConnection();
    }

    public void addContexto(String link,int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contextonavegacion(link,ID_Modelo) values (?,?)");
        preparedStatement.setString(1, link);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }




    public ArrayList<contextoNavegacion> getAllContextos() throws SQLException {
        ArrayList<contextoNavegacion> contextos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from contextonavegacion");
        while (rs.next()) {
            contextoNavegacion esquema = new contextoNavegacion();
            esquema.setID(rs.getInt("ID"));
            esquema.setLink((rs.getString("link")));
            esquema.setID_Modelo(rs.getInt("ID_Modelo"));
            contextos.add(esquema);
        }
        return contextos;
    }

//    public Esquema getEsquemaById(int idC) throws SQLException {
//        contextoNavegacion contexto = new contextoNavegacion();
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from contextonavegacion where ID=?");
//        preparedStatement.setInt(1, idC);
//        ResultSet rs = preparedStatement.executeQuery();
//        if (rs.next()) {
//            esquema.setId_esquema(rs.getInt("id_esquema"));
//            esquema.setNombre_esquema(rs.getString("nombre_esquema"));
//        }
//        return esquema;
//    }   
}
