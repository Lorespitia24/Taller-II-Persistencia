package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.FacultadDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacultadDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<FacultadDTO> getListaFacultad(){
        String query = "Select e from Facultad e";
        return em.createQuery(query).getResultList();
    }
}
