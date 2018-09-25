package co.edu.uptc.sw2.proyectoangular.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.MunicipioDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MunicipioLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("ServicioMunicipio")
@Stateless
public class ServicioMunicipio {

    @EJB
    private MunicipioLogica municipioLogica;

    @GET
    public List<MunicipioDTO> consultarMunicipio() {
        return municipioLogica.getListaMunicipio();
    }

    @POST
    public MunicipioDTO guardarMunicipio(MunicipioDTO municipio) {

        municipio.setId(municipioLogica.getListaMunicipio().size() + 1);
        municipioLogica.getListaMunicipio().add(municipio);
        return municipio;
    }

    //metodos
    @POST
    @Path("editarMunicipio")
    public void editarMunicipio(MunicipioDTO municipio) {
        municipioLogica.editarMunicipio(municipio);
    }

    @POST
    @Path("eliminarMunicipio")
    public void eliminarMunicipio(int id) {
        municipioLogica.eliminarMunicipio(id);
    }

}
