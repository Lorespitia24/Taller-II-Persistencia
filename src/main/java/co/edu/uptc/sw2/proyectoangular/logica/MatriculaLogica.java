
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.EstudianteDTO;
import co.edu.uptc.sw2.proyectoangular.dto.MateriaDTO;
import co.edu.uptc.sw2.proyectoangular.dto.MatriculaDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MatriculaDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lorespitia_24
 */
@Stateless
public class MatriculaLogica {
      @EJB
    public MatriculaDao matriculaDao;
    
    public List<MatriculaDTO> getListaMatricula(){
        return matriculaDao.getListaMatricula();
    }
    
     //nuevo Materia
    public MatriculaDTO nuevoMatricula(int id, int year, int semestre, EstudianteDTO estudiante, MateriaDTO materia){
    return new MatriculaDTO(id, id, id, estudiante, materia);
    }
    
    //editar Materia
    public void editarMatricula(MatriculaDTO matriculaEdit){
        for (MatriculaDTO matricula : matriculaDao.getListaMatricula()) {
            if(matricula.getId()==matriculaEdit.getId()){
            matriculaDao.getListaMatricula().remove(matricula);
            matriculaDao.getListaMatricula().add(matriculaEdit);
            break;
            }
            
        }
        
    }
    //eliminar Matricula
    public void eliminarMatricula(int id){
        for (MatriculaDTO matricula : matriculaDao.getListaMatricula()) {
            if(matricula.getId()==id){
           matriculaDao.getListaMatricula().remove(id);
           break;
            }
            
        }
    }
}
