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
 * Instrumento generated by hbm2java
 */
@Entity
@Table(name="Instrumento")
public class Instrumento  implements java.io.Serializable {


     private int idInstrumento;
     private DetalleInstrumento detalleInstrumento;
     private Ensayo ensayo;
     private Establecimiento establecimiento;
     private String descripcion;

    public Instrumento() {
    }

	
    public Instrumento(int idInstrumento, DetalleInstrumento detalleInstrumento, Establecimiento establecimiento) {
        this.idInstrumento = idInstrumento;
        this.detalleInstrumento = detalleInstrumento;
        this.establecimiento = establecimiento;
    }
    public Instrumento(int idInstrumento, DetalleInstrumento detalleInstrumento, Ensayo ensayo, Establecimiento establecimiento, String descripcion) {
       this.idInstrumento = idInstrumento;
       this.detalleInstrumento = detalleInstrumento;
       this.ensayo = ensayo;
       this.establecimiento = establecimiento;
       this.descripcion = descripcion;
    }
   
     @Id 

    
    @Column(name="idInstrumento", unique=true, nullable=false)
    public int getIdInstrumento() {
        return this.idInstrumento;
    }
    
    public void setIdInstrumento(int idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DetalleInstrumento_idDetalleInstrumento", nullable=false)
    public DetalleInstrumento getDetalleInstrumento() {
        return this.detalleInstrumento;
    }
    
    public void setDetalleInstrumento(DetalleInstrumento detalleInstrumento) {
        this.detalleInstrumento = detalleInstrumento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Ensayo_idEnsayo")
    public Ensayo getEnsayo() {
        return this.ensayo;
    }
    
    public void setEnsayo(Ensayo ensayo) {
        this.ensayo = ensayo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Establecimiento_idEstablecimiento", nullable=false)
    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }
    
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    
    @Column(name="Descripcion", length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

