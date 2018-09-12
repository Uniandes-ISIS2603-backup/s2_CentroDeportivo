/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;


import co.edu.uniandes.csw.centrodeportivo.ejb.EspecialistaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.EspecialistaPersistence;
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
 *
 * @author Leidy Romero
 */
@RunWith(Arquillian.class)
public class EspecialistaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private EspecialistaLogic especialistaLogic;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EspecialistaEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspecialistaEntity.class.getPackage())
                .addPackage(EspecialistaLogic.class.getPackage())
                .addPackage(EspecialistaPersistence.class.getPackage())
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
            clearData();
            insertData();
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
        em.createQuery("delete from EspecialistaEntity").executeUpdate();
    }
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i<10 ; i++)
        {
            EspecialistaEntity entidad = factory.manufacturePojo(EspecialistaEntity.class);
            
            em.persist (entidad);
            data.add (entidad);
        }
    }
    /**
     * Prueba para crear un especialista
     */
    @Test
    public void createEspecialistaEntity()
    {
        PodamFactory factory =  new PodamFactoryImpl();
        EspecialistaEntity nuevoEspecialista = factory.manufacturePojo(EspecialistaEntity.class);
        EspecialistaEntity resultado = especialistaLogic.createEspecialista(nuevoEspecialista);
        
        Assert.assertNotNull(resultado);
        EspecialistaEntity entidad = em.find(EspecialistaEntity.class, resultado.getId());
        
        Assert.assertEquals(nuevoEspecialista.getId(), entidad.getId());
    }
    
     /**
     * Prueba para consultar la lista de Especialistas.
     */
    @Test
    public void getEspecialistasTest() {
        List<EspecialistaEntity> list = especialistaLogic.getEspecialistas();
        Assert.assertEquals(data.size(), list.size());
        for (EspecialistaEntity ent : list) {
            boolean found = false;
            for (EspecialistaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Especialista.
     */
    @Test
    public void getEspecialistaTest() {
        EspecialistaEntity entity = data.get(0);
        EspecialistaEntity newEntity = especialistaLogic.getEspecialista(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Prueba para actualizar un Especialista.
     */
    @Test
    public void updateEspecialistaTest() {
        EspecialistaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EspecialistaEntity nuevaEntity = factory.manufacturePojo(EspecialistaEntity.class);

        nuevaEntity.setId(entity.getId());

        especialistaLogic.updateEspecialista(nuevaEntity.getId(), nuevaEntity);

        EspecialistaEntity resp = em.find(EspecialistaEntity.class, entity.getId());

        Assert.assertEquals(nuevaEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(nuevaEntity.getEspecialidad(), resp.getEspecialidad());
    }
}
