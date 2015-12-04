package Modelo.Datos;

import java.sql.PreparedStatement;

import Modelo.BD.ConexionBD;
import Modelo.Negocio.Entidad.clsEmpresa;


public class DAEmpresa {

    private PreparedStatement statement;

    public boolean InsertarEmpresa(clsEmpresa empresa){
        boolean bandera=false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("INSERT INTO empresa(Nombre,Direccion,Telefono,Correo) VALUES (?,?,?,?)");
            statement.setString(1, empresa.getNombre());
            statement.setString(2, empresa.getDireccion());
            statement.setString(3, empresa.getTelefono());
            statement.setString(4, empresa.getCorreo());

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
