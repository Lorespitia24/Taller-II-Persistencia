/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.ProfesorDTO;
import co.edu.uptc.sw2.proyectoangular.logica.ProfesorLogica;
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
@Path("ServicioProfesor")
@Stateless
public class ServicioProfesor {

    @EJB
    private ProfesorLogica profesorLogica;

    @GET
    public List<ProfesorDTO> consultarProfesor() {
        return profesorLogica.getListaProfesor();
    }

    @POST
    public ProfesorDTO guardarProfesor(ProfesorDTO profesor) {

        profesor.setId(profesorLogica.getListaProfesor().size() + 1);
        profesorLogica.getListaProfesor().add(profesor);
        return profesor;
    }

    //metodos
    @POST
    @Path("editarProfesor")
    public void editarFacultad(ProfesorDTO profesor) {
        profesorLogica.editarProfesor(profesor);
    }

    @POST
    @Path("eliminarProfesor")
    public void eliminarProfesor(int id) {
        profesorLogica.eliminarProfesor(id);
    }

}
