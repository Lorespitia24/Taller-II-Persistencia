
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.CarreraDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Carrera;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class CarreraLogica {
      @EJB
    public CarreraDao carreraDao;//carreradao
    
    public List<Carrera> getListaCarrera(){
        return carreraDao.getListaCarrera();
    }
    public Carrera nuevaCarrera(Carrera carrera){
    return carreraDao.guardarCarrera(carrera);
    }
    public void editarCarrera(Carrera carreraAModif){
        for (Carrera carrera : carreraDao.getListaCarrera()) {
            if(carrera.getId()==carreraAModif.getId()){
            carreraDao.getListaCarrera().remove(carrera);
            carreraDao.getListaCarrera().add(carreraAModif);
            break;
            }
            
        }
        
    }
    public void eliminarCarrera(int id){
        for (Carrera carrera : carreraDao.getListaCarrera()) {
            if(carrera.getId()==id){
           carreraDao.getListaCarrera().remove(id);
           break;
            }
            
        }
    }

}
