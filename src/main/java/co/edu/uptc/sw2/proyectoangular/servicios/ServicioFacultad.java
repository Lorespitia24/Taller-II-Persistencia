
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Facultad;
import co.edu.uptc.sw2.proyectoangular.logica.FacultadLogica;
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
@Path("ServicioFacultad")
@Stateless
public class ServicioFacultad {

    @EJB
    private FacultadLogica facultadLogica;

    @GET
    @Path("traerFacultad")
    public List<Facultad> consultarFacultad() {
        return facultadLogica.getListaFacultad();
    }

    @POST
    public Facultad guardarFacultad(Facultad facultad) {
        facultad.setId(facultadLogica.getListaFacultad().size() + 1);
        return facultadLogica.nuevaFacultad(facultad);
        
    }

    @PUT
    @Path("editarFacultad")
    public void editarFacultad(Facultad facultad) {
        facultadLogica.editarFacultad(facultad);
    }

    @DELETE
    @Path("eliminarFacultad")
    public void eliminarFacultad(Facultad facultad) {
        facultadLogica.eliminarFacultad(facultad);
    }

}
