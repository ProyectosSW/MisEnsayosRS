package com.misensayosrs;
// Generated 20/09/2015 08:58:00 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Calificacion generated by hbm2java
 */
@Entity
@Table(name="Calificacion")
public class Calificacion  implements java.io.Serializable {


     private int idCalificacion;
     private Ensayo ensayo;
     private int calificacionBanda;
     private int calificacionEstablecimiento;
     private String descripcion;

    public Calificacion() {
    }

	
    public Calificacion(int idCalificacion, Ensayo ensayo, int calificacionBanda, int calificacionEstablecimiento) {
        this.idCalificacion = idCalificacion;
        this.ensayo = ensayo;
        this.calificacionBanda = calificacionBanda;
        this.calificacionEstablecimiento = calificacionEstablecimiento;
    }
    public Calificacion(int idCalificacion, Ensayo ensayo, int calificacionBanda, int calificacionEstablecimiento, String descripcion) {
       this.idCalificacion = idCalificacion;
       this.ensayo = ensayo;
       this.calificacionBanda = calificacionBanda;
       this.calificacionEstablecimiento = calificacionEstablecimiento;
       this.descripcion = descripcion;
    }
   
     @Id 

    
    @Column(name="idCalificacion", unique=true, nullable=false)
    public int getIdCalificacion() {
        return this.idCalificacion;
    }
    
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Ensayo_idEnsayo", nullable=false)
    public Ensayo getEnsayo() {
        return this.ensayo;
    }
    
    public void setEnsayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }

    
    @Column(name="CalificacionBanda", nullable=false)
    public int getCalificacionBanda() {
        return this.calificacionBanda;
    }
    
    public void setCalificacionBanda(int calificacionBanda) {
        this.calificacionBanda = calificacionBanda;
    }

    
    @Column(name="CalificacionEstablecimiento", nullable=false)
    public int getCalificacionEstablecimiento() {
        return this.calificacionEstablecimiento;
    }
    
    public void setCalificacionEstablecimiento(int calificacionEstablecimiento) {
        this.calificacionEstablecimiento = calificacionEstablecimiento;
    }

    
    @Column(name="Descripcion", length=1000)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

