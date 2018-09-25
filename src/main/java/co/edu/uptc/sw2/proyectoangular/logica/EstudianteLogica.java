package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.EstudianteDTO;
import co.edu.uptc.sw2.proyectoangular.dto.MatriculaDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.EstudianteDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class EstudianteLogica {
    @EJB
    public EstudianteDao estudianteDao;
    
    public List<EstudianteDTO> getListaEstudiante(){
        return estudianteDao.getListaEstudiante();
    }
    //nuevo estudiante
    public EstudianteDTO nuevoEstudiante(int id, String nombre,
            String correo,String curso,MatriculaDTO matricula){
    return new EstudianteDTO(id, nombre, correo, curso, matricula);
    }
    
    //editar estudiante
    public void editarEstudiante(EstudianteDTO estudianteAModif){
        for (EstudianteDTO estudiante : estudianteDao.getListaEstudiante()) {
            if(estudiante.getId()==estudianteAModif.getId()){
            estudianteDao.getListaEstudiante().remove(estudiante);
            estudianteDao.getListaEstudiante().add(estudianteAModif);
            break;
            }
            
        }
        
    }
    //eliminar estudiante
    public void eliminarEstudiante(int id){
        for (EstudianteDTO estudiante : estudianteDao.getListaEstudiante()) {
            if(estudiante.getId()==id){
           estudianteDao.getListaEstudiante().remove(id);
           break;
            }
            
        }
    }
}
