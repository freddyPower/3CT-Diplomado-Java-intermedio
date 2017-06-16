package modelo.dto;

public class Titulo 
{
    //Atributos
    private String isbn;
    private String titulo;
    private String copyright;
    private int numeroEdicion;
    
    //Construcotres
     public Titulo(String isbn, String titulo, String copyright, int numeroEdicion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.copyright = copyright;
        this.numeroEdicion = numeroEdicion;
    }
     
    public Titulo(){}
    
    //Metodos 

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String toString() {
        return "Titulo{" + "isbn=" + isbn + ", titulo=" + titulo + ", copyright=" + copyright + ", numeroEdicion=" + numeroEdicion + '}';
    }
    
      
   
}
