package Modelo.Datos;

import java.sql.PreparedStatement;

import Modelo.BD.ConexionBD;

/**
 * Created by Ricardo Pineda G on 03-Dec-15.
 */
public class Modificar {

    private PreparedStatement statement;


    public boolean ModificarCorreo(String Correo, int id){
        boolean res = false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("UPDATE usuarios SET Correo=? WHERE IdUsuario=?");
            statement.setString(1, Correo);
            statement.setInt(2, id);
            int rs = statement.executeUpdate();
            if(rs!=0){
                res=true;
            }
            statement.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }


    public boolean ModificarPassword(String Password, int id){
        boolean res = false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("UPDATE usuarios SET Password=? WHERE IdUsuario=?");
            statement.setString(1,Password);
            statement.setInt(2,id);
            int rs = statement.executeUpdate();
            if(rs!=0){
                res=true;
            }
            statement.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
