package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.EstudianteDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Estudiante;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class EstudianteLogica {
    @EJB
    public EstudianteDao estudianteDao;
    
    public List<Estudiante> getListaEstudiante(){
        return estudianteDao.getListaEstudiante();
    }
    //nuevo estudiante
    public Estudiante nuevoEstudiante(Estudiante estudiante){
  return estudianteDao.guardarEstudiante(estudiante);
    }
    
    //editar estudiante
    public void editarEstudiante(Estudiante estudianteAModif){
        for (Estudiante estudiante : estudianteDao.getListaEstudiante()) {
            if(estudiante.getId()==estudianteAModif.getId()){
            estudianteDao.getListaEstudiante().remove(estudiante);
            estudianteDao.getListaEstudiante().add(estudianteAModif);
            estudianteDao.editarEstudiante(estudiante);
            break;
            }
        }
    }
    //eliminar estudiante
    public void eliminarEstudiante(int id){
        for (Estudiante estudiante : estudianteDao.getListaEstudiante()) {
            if(estudiante.getId()==id){
           estudianteDao.getListaEstudiante().remove(id);
           estudianteDao.eliminarEstudiante(estudiante);
           break;
            }
            
        }
    }
}
