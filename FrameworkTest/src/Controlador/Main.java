package Controlador;

import Modelo.ConnIfx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;
import util.File_Propiedades;
import util.TipoFile;

/**
 *
 * @author dlsclient
 */
public class Main {
    
   
    
    public static void main(String[] args) throws SQLException {
        String query;
        Properties PROPIEDADES = new File_Propiedades().getProperties(TipoFile.query);
        ConnIfx conexion = ConnIfx.getInstancia();
        Statement sentencia = null;
        PreparedStatement prpSentencia = null;
        ResultSet rs = null;
        query = ("select first 20 b.encacodigobarra\n"
                + "from mv_encargo b\n");
        sentencia = conexion.getConexion().createStatement();
        rs = sentencia.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("encacodigobarra"));
        }
        System.out.println(rs);
        rs.close();
        sentencia.close();
    }
    
}
