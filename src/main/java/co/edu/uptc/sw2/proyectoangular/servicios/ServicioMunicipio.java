package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Municipio;
import co.edu.uptc.sw2.proyectoangular.logica.MunicipioLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("ServicioMunicipio")
@Stateless
public class ServicioMunicipio {

    @EJB
    private MunicipioLogica municipioLogica;

    @GET
    public List<Municipio> consultarMunicipio() {
        return municipioLogica.getListaMunicipio();
    }

    @POST
    public Municipio guardarMunicipio(Municipio municipio) {

        municipio.setId(municipioLogica.getListaMunicipio().size() + 1);
return municipioLogica.nuevoMunicipio(municipio);
    }

    //metodos
    @PUT
    @Path("editarMunicipio")
    public void editarMunicipio(Municipio municipio) {
        municipioLogica.editarMunicipio(municipio);
    }

    @DELETE
    @Path("eliminarMunicipio")
    public void eliminarMunicipio(int id) {
        municipioLogica.eliminarMunicipio(id);
    }

}
