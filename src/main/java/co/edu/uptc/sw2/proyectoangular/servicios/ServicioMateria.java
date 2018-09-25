
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.MateriaDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MateriaLogica;
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
@Path("ServicioMateria")
@Stateless
public class ServicioMateria {

    @EJB
    private MateriaLogica materiaLogica;

    @GET
    public List<MateriaDTO> consultarMateria() {
        return materiaLogica.getListaMateria();
    }

    @POST
    public MateriaDTO guardarMateria(MateriaDTO materia) {

        materia.setId(materiaLogica.getListaMateria().size() + 1);
        materiaLogica.getListaMateria().add(materia);
        return materia;
    }

    //metodos
    @POST
    @Path("editarMateria")
    public void editarEstudiante(MateriaDTO materia) {
        materiaLogica.editarMateria(materia);
    }

    @POST
    @Path("eliminarMateria")
    public void eliminarMateria(int id) {
        materiaLogica.eliminarMateria(id);
    }

}
