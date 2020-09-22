/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author af.garciab
 */
@Entity
public class VideoJuegoEntity extends BaseEntity implements Serializable {
    private String titulo;
    
    private String empresa; 
    
    private int rangoEdadRecomendado;
    
    private String consola;
    
    private int calificacionNumeroEstrellas;
    
    private Long llavePrimaria;

    public VideoJuegoEntity() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getRangoEdadRecomendado() {
        return rangoEdadRecomendado;
    }

    public void setRangoEdadRecomendado(int rangoEdadRecomendado) {
        this.rangoEdadRecomendado = rangoEdadRecomendado;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getCalificacionNumeroEstrellas() {
        return calificacionNumeroEstrellas;
    }

    public void setCalificacionNumeroEstrellas(int calificacionNumeroEstrellas) {
        this.calificacionNumeroEstrellas = calificacionNumeroEstrellas;
    }

    public Long getLlavePrimaria() {
        return llavePrimaria;
    }

    public void setLlavePrimaria(Long llavePrimaria) {
        this.llavePrimaria = llavePrimaria;
    }
    
}
