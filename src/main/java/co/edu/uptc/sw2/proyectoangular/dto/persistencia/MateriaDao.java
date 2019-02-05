package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MateriaDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Materia> getListaMateria(){
        String query = "Select e from Materia e";
        return em.createQuery(query).getResultList();
    }
    public Materia guardarMateria(Materia materia){
        em.persist(materia);
        return materia;
    }
     public Materia editarMateria(Materia materia) {
        em.merge(materia);
        return materia;
    }

    public Materia eliminarMateria(Materia materia) {
        em.remove(materia);
        return materia;
    }
}
