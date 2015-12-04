package Modelo.Datos;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;

import Modelo.BD.ConexionBD;
import Modelo.Negocio.Entidad.clsUsuario;

/**
 * Created by Ricardo on 22-Nov-15.
 */
public class DAUsuario {
    private PreparedStatement statement;

    public boolean InsertarUsuario(clsUsuario usuario){
        boolean bandera=false;
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("INSERT INTO usuarios(Usuario,Password,Correo,Nombre,FechaRegistro,idPerfil,idEmpresa) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1,usuario.getUsuario());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4,usuario.getNombre());
            statement.setDate(5, (Date)usuario.getFechaRegistro());
            statement.setInt(6, usuario.getIdperfil());
            statement.setInt(7,usuario.getIdempresa());
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

    public boolean ConsultarCorreoExiste(String Correo){
        boolean bandera=false;
        try{
            statement=ConexionBD.getInstancia().getConexion().prepareStatement("SELECT Correo FROM usuarios where Correo= ?");
            statement.setString(1, Correo);
            ResultSet rs = statement.executeQuery();
            if(rs.next()!=false){
                bandera=true;
            }
            rs.close();
            statement.close();
            ConexionBD.getInstancia().Desconectar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return bandera;
    }

    public boolean ConsultarUsuarioExiste(String Usuario){
        boolean bandera=false;
        try{
            statement=ConexionBD.getInstancia().getConexion().prepareStatement("SELECT Usuario FROM usuarios where Usuario= ?");
            statement.setString(1, Usuario);
            ResultSet rs = statement.executeQuery();
            if(rs.next()!=false){
                bandera=true;
            }
            rs.close();
            statement.close();
            ConexionBD.getInstancia().Desconectar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return bandera;
    }

    public clsUsuario Loggear(String Usuario,String Password){
        clsUsuario usu = new clsUsuario();
        try{
            statement = ConexionBD.getInstancia().getConexion().prepareStatement("SELECT idUsuario,Usuario,Password,Correo,Nombre,FechaRegistro,idPerfil FROM usuarios where Usuario = ? and Password = ?");
            statement.setString(1, Usuario);
            statement.setString(2, Password);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                usu.setIdusuario(rs.getInt("idUsuario"));
                usu.setUsuario(rs.getString("Usuario"));
                usu.setPassword(rs.getString("Password"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setNombre(rs.getString("Nombre"));
                usu.setFechaRegistro(rs.getDate("FechaRegistro"));
                usu.setIdperfil(rs.getInt("idPerfil"));
            }

            rs.close();
            statement.close();
            ConexionBD.getInstancia().Desconectar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return usu;
    }
}
