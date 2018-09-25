package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.MunicipioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MunicipioDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * 
 * @author Viviana Lizarazo
 */
@Stateless
public class MunicipioLogica {
      @EJB
    public MunicipioDao municipioDao;
    
    public List<MunicipioDTO> getListaMunicipio(){
        return municipioDao.getListaMunicipio();
    }
    //metodos
    
    //nuevo municipio
    public MunicipioDTO nuevoMunicipio(int id, String nombre){
    return new MunicipioDTO(id, nombre);
    }
    //editar municipio
     public void editarMunicipio(MunicipioDTO municipioAModif){
        for (MunicipioDTO facultad : municipioDao.getListaMunicipio()) {
            if(facultad.getId()==municipioAModif.getId()){
            municipioDao.getListaMunicipio().remove(facultad);
            municipioDao.getListaMunicipio().add(municipioAModif);
            break;
            }
            
        }
        
    }    
    //eliminar municipio
         public void eliminarMunicipio(int id){
        for (MunicipioDTO municipio : municipioDao.getListaMunicipio()) {
            if(municipio.getId()==id){
           municipioDao.getListaMunicipio().remove(id);
           break;
            }
            
        }
    }
}
