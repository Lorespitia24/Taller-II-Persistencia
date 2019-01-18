package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Lorespitia_24
 */
@Entity
public class Facultad {

    @Id
    private int id;
    private String nombre;

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

}
