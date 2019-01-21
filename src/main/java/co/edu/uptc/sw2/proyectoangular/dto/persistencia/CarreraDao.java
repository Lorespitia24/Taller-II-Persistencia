package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Carrera;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarreraDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Carrera> getListaCarrera(){
        String query = "Select e from Carrera e";
        return em.createQuery(query).getResultList();
    }
    public Carrera guardarCarrera(Carrera carrera){
        em.persist(carrera);
        return carrera;
    }
    public Carrera editarCarrera(Carrera carrera) {
        em.merge(carrera);
        return carrera;
    }

    public Carrera eliminarCarrera(Carrera carrera) {
        em.remove(carrera);
        return carrera;
    }
}
