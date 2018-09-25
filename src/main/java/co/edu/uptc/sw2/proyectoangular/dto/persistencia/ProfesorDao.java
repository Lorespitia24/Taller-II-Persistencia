package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.ProfesorDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProfesorDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<ProfesorDTO> getListaProfesor(){
        String query = "Select e from Profesor e";
        return em.createQuery(query).getResultList();
    }

    public Object getListaFacultad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
