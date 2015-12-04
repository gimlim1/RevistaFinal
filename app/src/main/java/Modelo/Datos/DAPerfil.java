package Modelo.Datos;

import java.sql.PreparedStatement;

import Modelo.BD.ConexionBD;
import Modelo.Negocio.Entidad.clsPerfil;


public class DAPerfil {

    private PreparedStatement statement;

    public boolean InsertarPerfil(clsPerfil perfil){
        boolean bandera=false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("INSERT INTO perfiles(descripcion) VALUES (?,?)");
            statement.setString(1,perfil.getDescripcion());
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
