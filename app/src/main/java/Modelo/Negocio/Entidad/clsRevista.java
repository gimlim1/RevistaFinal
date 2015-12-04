package Modelo.Negocio.Entidad;


public class clsRevista {

    private int idRevista, idempresa;
    private String Autor,Tema,titulo;

    public clsRevista() {
    }

    public clsRevista(int idRevista, int idempresa, String autor, String tema, String titulo) {

        this.idempresa = idempresa;
        Autor = autor;
        Tema = tema;
        this.titulo = titulo;
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
}
