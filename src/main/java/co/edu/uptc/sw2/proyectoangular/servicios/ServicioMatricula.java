package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Matricula;
import co.edu.uptc.sw2.proyectoangular.logica.MatriculaLogica;
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
 * @author RA302
 */
@Path("ServicioMatricula")
@Stateless
public class ServicioMatricula {

    @EJB
    private MatriculaLogica matriculaLogica;

    @GET
    public List<Matricula> consultarMatricula() {
        return matriculaLogica.getListaMatricula();
    }

    @POST
    public Matricula guardarMatricula(Matricula matricula) {
        matricula.setId(matriculaLogica.getListaMatricula().size() + 1);
        return matriculaLogica.nuevoMatricula(matricula);
    }

    @PUT
    @Path("editarMatricula")
    public void editarMatricula(Matricula matricula) {
        matriculaLogica.editarMatricula(matricula);
    }

    @DELETE
    @Path("eliminarMatricula")
    public void eliminarMatricula(int id) {
        matriculaLogica.eliminarMatricula(id);
    }

}
