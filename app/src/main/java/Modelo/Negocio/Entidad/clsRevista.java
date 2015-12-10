package Modelo.Negocio.Entidad;


public class clsRevista {

    private int idRevista, idempresa;
    private String Autor,Tema,titulo,Portada;

    public clsRevista() {
    }

    public clsRevista(String autor, String tema, String titulo, int idempresa ,String portada) {
        this.idempresa = idempresa;
        Autor = autor;
        Tema = tema;
        this.titulo = titulo;
        this.Portada = portada;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return Portada;
    }

    public void setPortada(String portada) {
        Portada = portada;
    }
}
