package Modelo.Datos;

import java.sql.PreparedStatement;

import Modelo.BD.ConexionBD;
import Modelo.Negocio.Entidad.clsHoja;


public class DAHoja {

    private PreparedStatement statement;

    public boolean InsertarHoja(clsHoja hoja){
        boolean bandera=false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("INSERT INTO hojas(numeroHoja,Titulo,Texto,imagenURL) VALUES (?,?,?,?)");
            statement.setInt(1, hoja.getNumeroHoja());
            statement.setString(2, hoja.getTitulo());
            statement.setString(3, hoja.getTexto());
            statement.setString(4, hoja.getImagenURL());

            int rs = statement.executeUpdate();

            if(rs!=0){
                bandera=true;
            }
            statement.close();
            ConexionBD.getInstancia().Desconectar();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return bandera;
    }

}
