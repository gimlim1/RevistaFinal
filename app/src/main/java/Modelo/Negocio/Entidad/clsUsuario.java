package Modelo.Negocio.Entidad;

import java.io.Serializable;
import java.util.Date;

import Modelo.Cifrar.Decifrar;

/**
 * Created by Ricardo on 16-Oct-15.
 */
public class clsUsuario implements Serializable {

    private int Idusuario;
    private String Password;
    private String Correo;
    private Date FechaRegistro;
    private int idperfil;
    private int idempresa;

    public clsUsuario(){}

    public clsUsuario(String password,String correo,Date fecha,int perfil,int empresa){
        this.Password=password;
        this.Correo=correo;
        this.FechaRegistro=fecha;
        this.idperfil=perfil;
        this.idempresa=empresa;
    }


    public int getIdusuario() {
        return Idusuario;
    }

    public void setIdusuario(int idusuario) {
        Idusuario = idusuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    @Override
    public String toString(){
        String Texto="";
        try{
        Decifrar decifrar= new Decifrar();
        String password=decifrar.Desencriptar(getPassword());
        Texto= "Bienvenido A La Revista Digital!: " + "\n\n" + "Se Ha Registrado Con Exito!!" +
                "\n" + "Su Usuario: "+getCorreo() + "\n" + "Su Password: " + password;
        }catch(Exception ex){

        }
        return Texto;
    }
}
