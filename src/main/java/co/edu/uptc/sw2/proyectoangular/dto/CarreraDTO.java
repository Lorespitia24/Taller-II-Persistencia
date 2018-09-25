
package co.edu.uptc.sw2.proyectoangular.dto;


public class CarreraDTO {
    
    private int id;
    private String nombre;
    private FacultadDTO facultad;

    public CarreraDTO(int id, String nombre, FacultadDTO facultad) {
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FacultadDTO getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadDTO facultad) {
        this.facultad = facultad;
    }


}