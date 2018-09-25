/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.CarreraDTO;
import co.edu.uptc.sw2.proyectoangular.dto.HorarioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.MateriaDTO;
import co.edu.uptc.sw2.proyectoangular.dto.ProfesorDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MateriaDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Carrera;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Horario;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Materia;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Profesor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class MateriaLogica {
      @EJB
    public MateriaDao materiaDao;
    
    public List<MateriaDTO> getListaMateria(){
        return materiaDao.getListaMateria();
    }
    
    //nuevo Materia
    public MateriaDTO nuevoMateria(int id, String nombre,int creditos,CarreraDTO carrera,ProfesorDTO profesor,HorarioDTO horario){
    return new MateriaDTO(id, nombre, creditos, carrera, profesor, horario);
    }
    
    //editar Materia
    public void editarMateria(MateriaDTO materiaEdit){
        for (MateriaDTO materia : materiaDao.getListaMateria()) {
            if(materia.getId()==materiaEdit.getId()){
            materiaDao.getListaMateria().remove(materia);
            materiaDao.getListaMateria().add(materiaEdit);
            break;
            }
            
        }
        
    }
    //eliminar Materia
    public void eliminarMateria(int id){
        for (MateriaDTO materia : materiaDao.getListaMateria()) {
            if(materia.getId()==id){
           materiaDao.getListaMateria().remove(id);
           break;
            }
            
        }
    }
}
