package Revista.BL;

import java.util.Date;

/**
 * Created by Ricardo on 16-Oct-15.
 */
public class clsUsuario {

    private int Idusuario;
    private String Usuario;
    private String Password;
    private String Correo;
    private String Nombre;
    private String Apellido;
    private String SApellido;
    private Date FechaRegistro;
    private int idperfil;
    private int idempresa;

    public clsUsuario(String usuario,String password,String correo,String nombre,String apellido,String sapellido,Date fecha,int perfil,int empresa){

        this.Usuario=usuario;
        this.Password=password;
        this.Correo=correo;
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.SApellido=sapellido;
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

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getSApellido() {
        return SApellido;
    }

    public void setSApellido(String SApellido) {
        this.SApellido = SApellido;
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
}
