/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMisEnsayosRS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TestPruebas {
    
    private SessionFactory sessionFactory;
    private Session session = null;
    
    /**
     * Operaciones que se realizan antes de ejecutar el banco de pruebas.
     * En este caso se crea una misma sesión que será usada en todas las
     * pruebas.
     */
    @Before
    public void setupSession() {
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-inmemory.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        
    }
        
    /**
     * Operaciones que se realizan cuando finalice la ejecución de las pruebas.
     * En este caso se cierra la sesi_n y la f_brica de sesiones.
     */
    @After
    public void closeResources(){
        session.close();
        sessionFactory.close();
    }
 

    @Test
    public void sampleTest(){
        Transaction tx=session.beginTransaction();
        //realizar operación de persistencia
        //realizar una consulta
        //comparar el resultado esperado contra el obtenido con un assert
        assertTrue(0==0);
        
        tx.commit();        
    }
    
}
