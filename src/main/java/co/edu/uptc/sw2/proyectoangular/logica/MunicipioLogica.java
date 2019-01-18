package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MunicipioDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Municipio;
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
    
    public List<Municipio> getListaMunicipio(){
        return municipioDao.getListaMunicipio();
    }
    //metodos
    
    //nuevo municipio
    public Municipio nuevoMunicipio(Municipio municipio){
return municipioDao.guardarMunicipio(municipio);    }
    //editar municipio
     public void editarMunicipio(Municipio municipioAModif){
        for (Municipio facultad : municipioDao.getListaMunicipio()) {
            if(facultad.getId()==municipioAModif.getId()){
            municipioDao.getListaMunicipio().remove(facultad);
            municipioDao.getListaMunicipio().add(municipioAModif);
            break;
            }
            
        }
        
    }    
    //eliminar municipio
         public void eliminarMunicipio(int id){
        for (Municipio municipio : municipioDao.getListaMunicipio()) {
            if(municipio.getId()==id){
           municipioDao.getListaMunicipio().remove(id);
           break;
            }
            
        }
    }
}
