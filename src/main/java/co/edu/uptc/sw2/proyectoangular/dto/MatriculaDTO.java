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
public class MatriculaDTO {
    private  int id;
    private int year;
    private int semestre;
    private EstudianteDTO estudiante;
    private MateriaDTO materia;

    public MatriculaDTO(int id, int year, int semestre, EstudianteDTO estudiante, MateriaDTO materia) {
        this.id = id;
        this.year = year;
        this.semestre = semestre;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    

}
