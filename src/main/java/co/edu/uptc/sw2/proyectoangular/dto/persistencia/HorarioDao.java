package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Horario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HorarioDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Horario> getListaHorario(){
        String query = "Select e from Horario e";
        return em.createQuery(query).getResultList();
    }
    public Horario guardarHorario(Horario horario){
        em.persist(horario);
        return horario;
    }
}
