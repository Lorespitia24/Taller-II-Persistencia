/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Carrera;
import co.edu.uptc.sw2.proyectoangular.logica.CarreraLogica;
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

@Path("ServicioCarrera")
@Stateless
public class ServicioCarrera {

    @EJB
    private CarreraLogica carreraLogica;

    @GET
    public List<Carrera> consultarCarrera() {
        return carreraLogica.getListaCarrera();
    }

    @POST
    public Carrera guardarCarrera(Carrera carrera) {
       carrera.setId(carreraLogica.getListaCarrera().size() + 1);
       return carreraLogica.nuevaCarrera(carrera);
    }

    @PUT
    @Path("editarCarrera")
    public void editarCarrera(Carrera carrera) {
        carreraLogica.editarCarrera(carrera);
    }

    @DELETE
    @Path("eliminarCarrera")
    public void eliminarCarrera(int id) {
        carreraLogica.eliminarCarrera(id);
    }

}
