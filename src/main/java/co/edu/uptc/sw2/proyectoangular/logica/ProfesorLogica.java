
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.ProfesorDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ProfesorDao;
import static co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Materia_.profesor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * 
 * @author Viviana Lizarazo
 */
@Stateless
public class ProfesorLogica {
      @EJB
    public ProfesorDao profesorDao;
    
    public List<ProfesorDTO> getListaProfesor(){
        return profesorDao.getListaProfesor();
    }
    //metodos    
    //nuevo profesor
    
    public ProfesorDTO nuevaFacultad(int id, String nombre, String apellido, int documento){
    return new ProfesorDTO(id, nombre, apellido, documento);
    }
    //editar Profesor
     public void editarProfesor(ProfesorDTO profesorAModif){
        for (ProfesorDTO profesor : profesorDao.getListaProfesor()) {
            if(profesor.getId()==profesorAModif.getId()){
            profesorDao.getListaProfesor().remove(profesor);
            profesorDao.getListaProfesor().add(profesorAModif);
            break;
            }
            
        }
        
    }
    //eliminar Profesor
         public void eliminarProfesor(int id){
        for (ProfesorDTO profesor : profesorDao.getListaProfesor()) {
            if(profesor.getId()==id){
           profesorDao.getListaProfesor().remove(id);
           break;
            }
            
        }
    }
}
