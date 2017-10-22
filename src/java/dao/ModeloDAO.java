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
import model.Model;
import model.Unidad;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class ModeloDAO {
      private Connection connection;

    public ModeloDAO() {
        connection = DbUtil.getConnection();
    }

    public void addModelo(String nombre) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into modelonavegacion(nombre) values (?)");
        preparedStatement.setString(1, nombre);
        preparedStatement.executeUpdate();
    }



    public ArrayList<Model> getAllModelos() throws SQLException {
        ArrayList<Model> modelos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from modelonavegacion");
        while (rs.next()) {
            Model esquema = new Model();
            esquema.setID(rs.getInt("ID"));
            esquema.setNombre(rs.getString("nombre"));
            modelos.add(esquema);
        }
        return modelos;
    }
}
