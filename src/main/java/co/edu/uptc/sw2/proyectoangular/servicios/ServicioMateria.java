
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Materia;
import co.edu.uptc.sw2.proyectoangular.logica.MateriaLogica;
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
@Path("ServicioMateria")
@Stateless
public class ServicioMateria {

    @EJB
    private MateriaLogica materiaLogica;

    @GET
    public List<Materia> consultarMateria() {
        return materiaLogica.getListaMateria();
    }

    @POST
    public Materia guardarMateria(Materia materia) {

        materia.setId(materiaLogica.getListaMateria().size() + 1);
            return materiaLogica.nuevoMateria(materia);
    }

    //metodos
    @PUT
    @Path("editarMateria")
    public void editarEstudiante(Materia materia) {
        materiaLogica.editarMateria(materia);
    }

    @DELETE
    @Path("eliminarMateria")
    public void eliminarMateria(int id) {
        materiaLogica.eliminarMateria(id);
    }

}
