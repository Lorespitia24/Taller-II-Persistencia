package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Estudiante;
import co.edu.uptc.sw2.proyectoangular.logica.EstudianteLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Viviana Lizarazo
 */
@Path("ServicioEstudiante")
@Stateless
public class ServicioEstudiante {

    @EJB
    private EstudianteLogica estudianteLogica;

    @GET
    public List<Estudiante> consultarEstudiantes() {
        return estudianteLogica.getListaEstudiante();
    }

    @POST
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        estudiante.setId(estudianteLogica.getListaEstudiante().size() + 1);
        return estudianteLogica.nuevoEstudiante(estudiante);
    }

    //metodos
    @PUT
    @Path("editarEstudiante")
    public void editarEstudiante(Estudiante estudiante) {
        estudianteLogica.editarEstudiante(estudiante);
    }

    @DELETE
    @Path("eliminarEstudiante")
    public void eliminarEstudiante(int id) {
        estudianteLogica.eliminarEstudiante(id);
    }

}
