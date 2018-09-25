/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.*;

/**
 *
 * @author Lorespitia_24
 */
public class MateriaDTO {
    private int id;
private String nombre;
private int creditos;
private CarreraDTO carrera;
private ProfesorDTO profesor;
private HorarioDTO horario;

       public MateriaDTO(int id, String nombre, int creditos, CarreraDTO carrera,
               ProfesorDTO profesor,HorarioDTO horario) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.carrera=carrera;
        this.profesor=profesor;
        this.horario = horario;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public HorarioDTO getHorario() {
        return horario;
    }

    public void setHorario(HorarioDTO horario) {
        this.horario = horario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


}
