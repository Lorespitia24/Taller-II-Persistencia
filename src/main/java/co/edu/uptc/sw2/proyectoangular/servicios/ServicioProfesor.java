/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Profesor;
import co.edu.uptc.sw2.proyectoangular.logica.ProfesorLogica;
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
@Path("ServicioProfesor")
@Stateless
public class ServicioProfesor {

    @EJB
    private ProfesorLogica profesorLogica;

    @GET
    public List<Profesor> consultarProfesor() {
        return profesorLogica.getListaProfesor();
    }

    @POST
    public Profesor guardarProfesor(Profesor profesor) {

        profesor.setId(profesorLogica.getListaProfesor().size() + 1);
        return profesorLogica.nuevoProfesor(profesor);
    }

    //metodos
    @PUT
    @Path("editarProfesor")
    public void editarFacultad(Profesor profesor) {
        profesorLogica.editarProfesor(profesor);
    }

    @DELETE
    @Path("eliminarProfesor")
    public void eliminarProfesor(int id) {
        profesorLogica.eliminarProfesor(id);
    }

}
