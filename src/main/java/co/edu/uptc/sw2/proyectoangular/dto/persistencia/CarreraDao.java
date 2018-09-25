package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.CarreraDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarreraDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<CarreraDTO> getListaCarrera(){
        String query = "Select e from Carrera e";
        return em.createQuery(query).getResultList();
    }
}
