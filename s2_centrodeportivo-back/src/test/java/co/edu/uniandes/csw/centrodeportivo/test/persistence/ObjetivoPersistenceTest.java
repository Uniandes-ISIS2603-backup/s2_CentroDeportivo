/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.test.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.DeportistaPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.ObjetivoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author Leidy Romero
 */
@RunWith(Arquillian.class)
public class ObjetivoPersistenceTest {
    
    @Inject
    private ObjetivoPersistence objetivoPersistance;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ObjetivoEntity> data = new ArrayList<>();
    
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el 
     * archivo beans.xml para resolver la inyeccion de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ObjetivoEntity.class.getPackage())
                .addPackage(ObjetivoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            inserData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
     /**
     * Limpia las tablas que estan implicada en la prueba.
     */
    private void clearData()
    {
        em.createQuery("delete from ObjetivoaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas
     */
    private void inserData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i<10 ; i++)
        {
            ObjetivoEntity entidad = factory.manufacturePojo(ObjetivoEntity.class);
            
            em.persist (entidad);
            data.add (entidad);
        }
    }
    
     /**
     * Prueba para crear un objetivo
     */
    @Test
    public void createObjetivoEntity()
    {
        PodamFactory factory =  new PodamFactoryImpl();
        ObjetivoEntity nuevoObjetivo = factory.manufacturePojo(ObjetivoEntity.class);
        ObjetivoEntity resultado = objetivoPersistance.create(nuevoObjetivo);
        
        Assert.assertNotNull(resultado);
        ObjetivoEntity entidad = em.find(ObjetivoEntity.class, resultado.getId());
        
        //Assert.assertEquals(nuevoObjetivo.getId(), entidad.getId());
    }
}
