package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.EstudianteDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstudianteDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<EstudianteDTO> getListaEstudiante(){
        String query = "Select e from Estudiante e";
        return em.createQuery(query).getResultList();
    }
}
