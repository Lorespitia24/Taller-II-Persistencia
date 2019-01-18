package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Facultad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacultadDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Facultad> getListaFacultad(){
        String query = "Select e from Facultad e";
        return em.createQuery(query).getResultList();
    }
    public Facultad guardarFacultad(Facultad facultad){
        em.persist(facultad);
        return facultad;
    }
}
