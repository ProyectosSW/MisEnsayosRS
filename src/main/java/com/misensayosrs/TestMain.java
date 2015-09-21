/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misensayosrs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author 2089978
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        
        Session session=sessionFactory.openSession();        
        Transaction tx=session.beginTransaction();
                
        List<String> listaNombreDetalleInstrumentos = new ArrayList<>();
        listaNombreDetalleInstrumentos.add("Acordeon");
        listaNombreDetalleInstrumentos.add("Arpa");
        listaNombreDetalleInstrumentos.add("Bajo");
        listaNombreDetalleInstrumentos.add("Bateria");
        listaNombreDetalleInstrumentos.add("Clarinete");
        listaNombreDetalleInstrumentos.add("Flauta");
        listaNombreDetalleInstrumentos.add("Guitarra");
        listaNombreDetalleInstrumentos.add("Piano");
        listaNombreDetalleInstrumentos.add("Saxofon");
        listaNombreDetalleInstrumentos.add("Trompeta");
        listaNombreDetalleInstrumentos.add("Violin");
        String listaIns="(";
        for(String s : listaNombreDetalleInstrumentos){
            listaIns = listaIns+"'"+s+"',";
        }
        listaIns=listaIns.substring(0, listaIns.length()-1);
        listaIns = listaIns+")";

        Query establecimientosPrecio = session.getNamedQuery("establecimientoporprecio");
        establecimientosPrecio.setString("nombrex", listaIns);
        establecimientosPrecio.setString("localidadx", "Usaquen");
        List<Object> listaEstablecimientosPrecio = establecimientosPrecio.list();
        for(Object establecimiento: listaEstablecimientosPrecio){
            System.out.println("Establecimiento "+(Establecimiento)establecimiento);
        }
        
        Query establecimientosEvaluacion = session.getNamedQuery("establecimientoporcalificacion");
        establecimientosEvaluacion.setString("nombrex", listaIns);
        establecimientosEvaluacion.setString("localidadx", "Usaquen");
        List<Object[]> listaEstablecimientosEvaluacion = establecimientosEvaluacion.list();
        for(Object[] establecimiento: listaEstablecimientosEvaluacion){
            System.out.println("Establecimiento "+establecimiento[0]+" : "+establecimiento[1]);
        }
        
        
        Query horarioN = session.getNamedQuery("horarioN");
        List<Object[]> listaHor= horarioN.list();
        for(Object[] i:listaHor){
            System.out.println((String)i[0]+" "+(Date)i[1]+" "+(Integer)i[2]);
        }
        
        
        Query q = session.getNamedQuery("EstablecimientoInstru");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_YEAR, 10);
        q.setDate("n", c.getTime());
        q.setInteger("idInst", 0);
        q.setInteger("idEst", 0);
        List<Object[]> l = q.list();
        
        for(Object[] i:l){
            System.out.println((String)i[0]+" "+(java.sql.Date)i[1]+" "+(Integer)i[2]);
        }
        
        tx.commit();
        session.close();
    
    }
    
    
    public static void insercion(Session s, Cliente clien, List<Integer> codIns, Date fecha, int tiempoEnsayo, Integer abrilRecords, Sala salaA){
        Reservacion reser= new Reservacion(555, salaA, fecha,tiempoEnsayo);
        s.save(reser);
        Ensayo ensay=new Ensayo(124, clien, "Ensayo de la banda the strokes");
        s.save(ensay);
        Alquiler alqui=new Alquiler(123, ensay, reser, "debito", 0, "15%");
        s.save(alqui);
        for(int i=0;i<=codIns.size();i++){
            ((Instrumento)s.load(Instrumento.class,codIns.get(i))).setEnsayo(ensay);
            s.update(codIns.get(i));
            
        } 
    }
}
