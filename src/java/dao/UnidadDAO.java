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
import model.Unidad;
import model.contextoNavegacion;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class UnidadDAO {
     private Connection connection;

    public UnidadDAO() {
        connection = DbUtil.getConnection();
    }

    public void addUnidad(int idC,int idT) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into unidadabstractainformacion(ID_Contexto,ID_Tabla) values (?,?)");
        preparedStatement.setInt(1, idC);
        preparedStatement.setInt(2, idT);
        preparedStatement.executeUpdate();
    }




    public ArrayList<Unidad> getAllUnidades() throws SQLException {
        ArrayList<Unidad> unidades = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from unidadabstractainformacion");
        while (rs.next()) {
            Unidad esquema = new Unidad();
            esquema.setID(rs.getInt("ID"));
            esquema.setID_C(rs.getInt("ID_Contexto"));
            esquema.setID_t(rs.getInt("ID_Tabla"));
            unidades.add(esquema);
        }
        return unidades;
    }
}
