package Modelo.Negocio.Entidad;


public class clsPerfil {

    private int idPerfil;
    private String descripcion;

    public clsPerfil() {
    }

    public clsPerfil(int idPerfil, String descripcion) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
    }

    public int getIdPerfil() {
        return idPerfil;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
