package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.FacultadDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacultadDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lorespitia_24
 */
@Stateless
public class FacultadLogica {
      @EJB
    public FacultadDao facultadDao;
    
    public List<FacultadDTO> getListaFacultad(){
        return facultadDao.getListaFacultad();
    }
    
    public FacultadDTO nuevaFacultad(int id, String nombre){
    return new FacultadDTO(id, nombre);
    }
    public void editarFacultad(FacultadDTO facultadAModif){
        for (FacultadDTO facultad : facultadDao.getListaFacultad()) {
            if(facultad.getId()==facultadAModif.getId()){
            facultadDao.getListaFacultad().remove(facultad);
            facultadDao.getListaFacultad().add(facultadAModif);
            break;
            }
            
        }
        
    }
    public void eliminarFacultad(int id){
        for (FacultadDTO facultad : facultadDao.getListaFacultad()) {
            if(facultad.getId()==id){
           facultadDao.getListaFacultad().remove(id);
           break;
            }
            
        }
    }
    
}
