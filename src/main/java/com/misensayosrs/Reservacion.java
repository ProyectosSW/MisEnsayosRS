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
 * Reservacion generated by hbm2java
 */
@Entity
@Table(name="Reservacion")
public class Reservacion  implements java.io.Serializable {


     private int idReservacion;
     private Sala sala;
     private Date fecha;
     private int tiempo;
     private Set<Alquiler> alquilers = new HashSet(0);

    public Reservacion() {
    }

	
    public Reservacion(int idReservacion, Sala sala, Date fecha, int tiempo) {
        this.idReservacion = idReservacion;
        this.sala = sala;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }
    public Reservacion(int idReservacion, Sala sala, Date fecha, int tiempo, Set<Alquiler> alquilers) {
       this.idReservacion = idReservacion;
       this.sala = sala;
       this.fecha = fecha;
       this.tiempo = tiempo;
       this.alquilers = alquilers;
    }
   
     @Id 

    
    @Column(name="idReservacion", unique=true, nullable=false)
    public int getIdReservacion() {
        return this.idReservacion;
    }
    
    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Sala_idSala", nullable=false)
    public Sala getSala() {
        return this.sala;
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="Fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="Tiempo", nullable=false)
    public int getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="reservacion")
    public Set<Alquiler> getAlquilers() {
        return this.alquilers;
    }
    
    public void setAlquilers(Set<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }




}


