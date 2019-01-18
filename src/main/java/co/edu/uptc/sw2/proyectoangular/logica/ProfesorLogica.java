
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ProfesorDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Profesor;
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
    
    public List<Profesor> getListaProfesor(){
        return profesorDao.getListaProfesor();
    }
    //metodos    
    //nuevo profesor
    
    public Profesor nuevoProfesor(Profesor profesor){
return profesorDao.guardarProfesor(profesor);
    }
    //editar Profesor
     public void editarProfesor(Profesor profesorAModif){
        for (Profesor profesor : profesorDao.getListaProfesor()) {
            if(profesor.getId()==profesorAModif.getId()){
            profesorDao.getListaProfesor().remove(profesor);
            profesorDao.getListaProfesor().add(profesorAModif);
            break;
            }
            
        }
        
    }
    //eliminar Profesor
         public void eliminarProfesor(int id){
        for (Profesor profesor : profesorDao.getListaProfesor()) {
            if(profesor.getId()==id){
           profesorDao.getListaProfesor().remove(id);
           break;
            }
            
        }
    }
}
