
package modelo.dto;

/**
 *
 * @author luis
 */
public class Autor {
    
    //Atributos
    private int idAutor;
    private String nombre;
    private String apellidoPaterno;

    public Autor() {
    }

    public Autor(int idAutor, String nombre, String apellidoPaterno) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + '}';
    }
    
    

    
    
    
    
    
}
