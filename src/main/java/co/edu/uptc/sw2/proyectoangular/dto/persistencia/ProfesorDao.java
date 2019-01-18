
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Profesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProfesorDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Profesor> getListaProfesor(){
        String query = "Select e from Profesor e";
        return em.createQuery(query).getResultList();
    }
    public Profesor guardarProfesor(Profesor profesor){
        em.persist(profesor);
        return profesor;
    }
}
