package Modelo.Negocio.Entidad;


public class clsHoja {

    private int idRevista, numeroHoja;
    private String titulo, texto, imagenURL;

    public clsHoja() {
    }

    public clsHoja(int idRevista, int numeroHoja, String titulo, String texto, String imagenURL) {
        this.idRevista = idRevista;
        this.numeroHoja = numeroHoja;
        this.titulo = titulo;
        this.texto = texto;
        this.imagenURL = imagenURL;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroHoja() {
        return numeroHoja;
    }

    public void setNumeroHoja(int numeroHoja) {
        this.numeroHoja = numeroHoja;
    }
}
