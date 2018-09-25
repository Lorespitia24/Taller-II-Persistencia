
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.CarreraDTO;
import co.edu.uptc.sw2.proyectoangular.dto.FacultadDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.CarreraDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class CarreraLogica {
      @EJB
    public CarreraDao carreraDao;//carreradao
    
    public List<CarreraDTO> getListaCarrera(){
        return carreraDao.getListaCarrera();
    }
    public CarreraDTO nuevaCarrera(int id, String nombre,FacultadDTO facultad){
    return new CarreraDTO(id, nombre,facultad);
    }
    public void editarCarrera(CarreraDTO carreraAModif){
        for (CarreraDTO carrera : carreraDao.getListaCarrera()) {
            if(carrera.getId()==carreraAModif.getId()){
            carreraDao.getListaCarrera().remove(carrera);
            carreraDao.getListaCarrera().add(carreraAModif);
            break;
            }
            
        }
        
    }
    public void eliminarCarrera(int id){
        for (CarreraDTO carrera : carreraDao.getListaCarrera()) {
            if(carrera.getId()==id){
           carreraDao.getListaCarrera().remove(id);
           break;
            }
            
        }
    }

}
