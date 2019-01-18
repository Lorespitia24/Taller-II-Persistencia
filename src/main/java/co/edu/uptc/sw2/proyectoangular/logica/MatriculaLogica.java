
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MatriculaDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Matricula;
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
    
    public List<Matricula> getListaMatricula(){
        return matriculaDao.getListaMatricula();
    }
    
     //nuevo Materia
    public Matricula nuevoMatricula(Matricula matricula){
    return matriculaDao.guardarMatricula(matricula);
    }
    
    //editar Materia
    public void editarMatricula(Matricula matriculaEdit){
        for (Matricula matricula : matriculaDao.getListaMatricula()) {
            if(matricula.getId()==matriculaEdit.getId()){
            matriculaDao.getListaMatricula().remove(matricula);
            matriculaDao.getListaMatricula().add(matriculaEdit);
            break;
            }
            
        }
        
    }
    //eliminar Matricula
    public void eliminarMatricula(int id){
        for (Matricula matricula : matriculaDao.getListaMatricula()) {
            if(matricula.getId()==id){
           matriculaDao.getListaMatricula().remove(id);
           break;
            }
            
        }
    }
}
