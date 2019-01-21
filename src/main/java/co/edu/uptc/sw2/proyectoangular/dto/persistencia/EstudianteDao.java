package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstudianteDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Estudiante> getListaEstudiante(){
        String query = "Select e from Estudiante e";
        return em.createQuery(query).getResultList();
    }
    public Estudiante guardarEstudiante(Estudiante estudiante){
        em.persist(estudiante);
        return estudiante;
    }
    public Estudiante editarEstudiante(Estudiante estudiante) {
        em.merge(estudiante);
        return estudiante;
    }

    public Estudiante eliminarEstudiante(Estudiante estudiante) {
        em.remove(estudiante);
        return estudiante;
    }
}
