
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.HorarioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.HorarioDao;
import java.util.Date;
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
    
    public List<HorarioDTO> getListaHorario(){
        return horarioDao.getListaHorario();
    }
    
     //nuevo Materia
    public HorarioDTO nuevoHorario(int id, String dia,Date horaInicio, Date horaFin){
    return new HorarioDTO(id, dia, horaInicio, horaFin);
    }
    
    //editar Materia
    public void editarHorario(HorarioDTO horarioEdit){
        for (HorarioDTO horario : horarioDao.getListaHorario()) {
            if(horario.getId()==horarioEdit.getId()){
            horarioDao.getListaHorario().remove(horario);
            horarioDao.getListaHorario().add(horarioEdit);
            break;
            }
            
        }
        
    }
    //eliminar Horario
    public void eliminarHorario(int id){
        for (HorarioDTO horario : horarioDao.getListaHorario()) {
            if(horario.getId()==id){
           horarioDao.getListaHorario().remove(id);
           break;
            }
            
        }
    }
    
}
