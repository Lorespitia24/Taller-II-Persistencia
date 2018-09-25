package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.MatriculaDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MatriculaLogica;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Matricula;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public List<MatriculaDTO> consultarMatricula() {
        return matriculaLogica.getListaMatricula();
    }

    @POST
    public MatriculaDTO guardarMatricula(MatriculaDTO matricula) {

        matricula.setId(matriculaLogica.getListaMatricula().size() + 1);
        matriculaLogica.getListaMatricula().add(matricula);
        return matricula;
    }

    @POST
    @Path("editarMatricula")
    public void editarMatricula(MatriculaDTO matricula) {
        matriculaLogica.editarMatricula(matricula);
    }

    @POST
    @Path("eliminarMatricula")
    public void eliminarMatricula(int id) {
        matriculaLogica.eliminarMatricula(id);
    }

}
