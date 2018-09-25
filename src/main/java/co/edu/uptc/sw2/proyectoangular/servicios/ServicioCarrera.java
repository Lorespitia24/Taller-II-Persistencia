/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.CarreraDTO;
import co.edu.uptc.sw2.proyectoangular.logica.CarreraLogica;
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
@Stateless
@Path("ServicioCarrera")
public class ServicioCarrera {

    @EJB
    private CarreraLogica carreraLogica;

    @GET
    public List<CarreraDTO> consultarCarrera() {
        return carreraLogica.getListaCarrera();
    }

    @POST
    public CarreraDTO guardarCarrera(CarreraDTO carrera) {
        carrera.setId(carreraLogica.getListaCarrera().size() + 1);
        carreraLogica.getListaCarrera().add(carrera);
        return carrera;
    }

    @POST
    @Path("editarCarrera")
    public void editarCarrera(CarreraDTO carrera) {
        carreraLogica.editarCarrera(carrera);
    }

    @POST
    @Path("eliminarCarrera")
    public void eliminarCarrera(int id) {
        carreraLogica.eliminarCarrera(id);
    }

}
