package com.misensayosrs;
// Generated 20/09/2015 08:58:00 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ensayo generated by hbm2java
 */
@Entity
@Table(name="Ensayo")
public class Ensayo  implements java.io.Serializable {


     private int idEnsayo;
     private Cliente cliente;
     private String descripcion;
     private Date fechaCancelacion;
     private Set<Calificacion> calificacions = new HashSet(0);
     private Set<Instrumento> instrumentos = new HashSet(0);
     private Set<Alquiler> alquilers = new HashSet(0);

    public Ensayo() {
    }

	
    public Ensayo(int idEnsayo, Cliente cliente, String descripcion) {
        this.idEnsayo = idEnsayo;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }
    public Ensayo(int idEnsayo, Cliente cliente, String descripcion, Date fechaCancelacion, Set<Calificacion> calificacions, Set<Instrumento> instrumentos, Set<Alquiler> alquilers) {
       this.idEnsayo = idEnsayo;
       this.cliente = cliente;
       this.descripcion = descripcion;
       this.fechaCancelacion = fechaCancelacion;
       this.calificacions = calificacions;
       this.instrumentos = instrumentos;
       this.alquilers = alquilers;
    }
   
     @Id 

    
    @Column(name="idEnsayo", unique=true, nullable=false)
    public int getIdEnsayo() {
        return this.idEnsayo;
    }
    
    public void setIdEnsayo(int idEnsayo) {
        this.idEnsayo = idEnsayo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Cliente_idCliente", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="Descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaCancelacion", length=10)
    public Date getFechaCancelacion() {
        return this.fechaCancelacion;
    }
    
    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ensayo")
    public Set<Calificacion> getCalificacions() {
        return this.calificacions;
    }
    
    public void setCalificacions(Set<Calificacion> calificacions) {
        this.calificacions = calificacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ensayo")
    public Set<Instrumento> getInstrumentos() {
        return this.instrumentos;
    }
    
    public void setInstrumentos(Set<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ensayo")
    public Set<Alquiler> getAlquilers() {
        return this.alquilers;
    }
    
    public void setAlquilers(Set<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }




}

