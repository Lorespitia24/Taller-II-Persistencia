package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacultadDao;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Facultad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Lorespitia_24
 */
@Stateless
public class FacultadLogica {

    @EJB
    public FacultadDao facultadDao;

    public List<Facultad> getListaFacultad() {
        return facultadDao.getListaFacultad();
    }

    public Facultad nuevaFacultad(Facultad facultad) {
        System.out.println("logica: "+facultad.getNombre());
        return facultadDao.guardarFacultad(facultad);
       }

    public void editarFacultad(Facultad facultadAModif) {
        for (Facultad facultad : facultadDao.getListaFacultad()) {
            if (facultad.getId() == facultadAModif.getId()) {
                facultadDao.getListaFacultad().remove(facultad);
                facultadDao.getListaFacultad().add(facultadAModif);
                break;
            }

        }

    }

    public void eliminarFacultad(int id) {
        for (Facultad facultad : facultadDao.getListaFacultad()) {
            if (facultad.getId() == id) {
                facultadDao.getListaFacultad().remove(id);
                break;
            }

        }
    }

}
