package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.MateriaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MateriaDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<MateriaDTO> getListaMateria(){
        String query = "Select e from Materia e";
        return em.createQuery(query).getResultList();
    }
}
