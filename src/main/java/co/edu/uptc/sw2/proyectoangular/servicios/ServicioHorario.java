/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Horario;
import co.edu.uptc.sw2.proyectoangular.logica.HorarioLogica;
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
@Path("ServicioHorario")
@Stateless
public class ServicioHorario {

    @EJB
    private HorarioLogica horarioLogica;

    @GET
    public List<Horario> consultarHorario() {
        return horarioLogica.getListaHorario();
    }

    @POST
    public Horario guardarHorario(Horario horario) {

        horario.setId(horarioLogica.getListaHorario().size() + 1);
return horarioLogica.nuevoHorario(horario);
    }
    //metodos

    @PUT
    @Path("editarHorario")
    public void editarHorario(Horario horario) {
        horarioLogica.editarHorario(horario);
    }

    @DELETE
    @Path("eliminarHorario")
    public void eliminarHorario(int id) {
        horarioLogica.eliminarHorario(id);
    }

}
