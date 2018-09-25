package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.MunicipioDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MunicipioDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<MunicipioDTO> getListaMunicipio(){
        String query = "Select e from Municipio e";
        return em.createQuery(query).getResultList();
    }
}
