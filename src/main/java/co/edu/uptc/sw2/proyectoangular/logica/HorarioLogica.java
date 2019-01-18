
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.HorarioDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Horario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lorespitia_24
 */
@Stateless
public class HorarioLogica {
      @EJB
    public HorarioDao horarioDao;
    
    public List<Horario> getListaHorario(){
        return horarioDao.getListaHorario();
    }
    
     //nuevo Materia
    public Horario nuevoHorario(Horario horario){
    return horarioDao.guardarHorario(horario);
    }
    
    //editar Materia
    public void editarHorario(Horario horarioEdit){
        for (Horario horario : horarioDao.getListaHorario()) {
            if(horario.getId()==horarioEdit.getId()){
            horarioDao.getListaHorario().remove(horario);
            horarioDao.getListaHorario().add(horarioEdit);
            break;
            }
            
        }
        
    }
    //eliminar Horario
    public void eliminarHorario(int id){
        for (Horario horario : horarioDao.getListaHorario()) {
            if(horario.getId()==id){
           horarioDao.getListaHorario().remove(id);
           break;
            }
            
        }
    }
    
}
