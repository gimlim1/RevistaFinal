package Modelo.Negocio.Entidad;

public class clsEmpresa {

    private int idEmpresa;
    private String Nombre, direccion, telefono, correo;

    public clsEmpresa() {
    }

    public clsEmpresa(String nombre, String direccion, String telefono, String correo) {
        Nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
