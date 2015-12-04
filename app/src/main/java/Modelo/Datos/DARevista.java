package Modelo.Datos;

import java.sql.PreparedStatement;

import Modelo.BD.ConexionBD;
import Modelo.Negocio.Entidad.clsRevista;


public class DARevista {

    private PreparedStatement statement;

    public boolean InsertarRevista(clsRevista revista){
        boolean bandera=false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("INSERT INTO revistas(idRevista,Autor,Tema,Titulo,idEmpresa) VALUES (?,?,?,?,?)");
            statement.setString(1,revista.getAutor());
            statement.setString(2, revista.getTema());
            statement.setString(3, revista.getTitulo());
            statement.setInt(4,revista.getIdempresa());

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
