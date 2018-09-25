package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.HorarioDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HorarioDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<HorarioDTO> getListaHorario(){
        String query = "Select e from Horario e";
        return em.createQuery(query).getResultList();
    }
}
