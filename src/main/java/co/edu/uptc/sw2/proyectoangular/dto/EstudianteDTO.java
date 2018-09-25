
package co.edu.uptc.sw2.proyectoangular.dto;

/**
 *
 * @author RA302
 */
public class EstudianteDTO {

    private int id;
    private String nombre;
    private String correo;
    private String curso;
    private MatriculaDTO matricula;

    public EstudianteDTO() {
    }

    public EstudianteDTO(int id, String nombre, String correo, 
            String curso, MatriculaDTO matricula) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.matricula = matricula;
    }

    public MatriculaDTO getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaDTO matricula) {
        this.matricula = matricula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
