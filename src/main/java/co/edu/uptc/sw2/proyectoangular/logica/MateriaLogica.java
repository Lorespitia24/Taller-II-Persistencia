/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MateriaDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Materia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class MateriaLogica {
      @EJB
    public MateriaDao materiaDao;
    
    public List<Materia> getListaMateria(){
        return materiaDao.getListaMateria();
    }
    
    //nuevo Materia
    public Materia nuevoMateria(Materia materia){
return materiaDao.guardarMateria(materia);
    }
    
    //editar Materia
    public void editarMateria(Materia materiaEdit){
        for (Materia materia : materiaDao.getListaMateria()) {
            if(materia.getId()==materiaEdit.getId()){
            materiaDao.getListaMateria().remove(materia);
            materiaDao.getListaMateria().add(materiaEdit);
            materiaDao.editarMateria(materia);
            break;
            }
            
        }
        
    }
    //eliminar Materia
    public void eliminarMateria(int id){
        for (Materia materia : materiaDao.getListaMateria()) {
            if(materia.getId()==id){
           materiaDao.getListaMateria().remove(id);
           materiaDao.eliminarMateria(materia);
           break;
            }
            
        }
    }
}
