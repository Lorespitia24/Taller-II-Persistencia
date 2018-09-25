package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.MatriculaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MatriculaDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<MatriculaDTO> getListaMatricula(){
        String query = "Select e from Matricula e";
        return em.createQuery(query).getResultList();
    }
}
