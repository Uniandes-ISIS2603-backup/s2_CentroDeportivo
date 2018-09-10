/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;

import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.*;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.DeportistaPersistenc;
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
public class DeportistaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private DeportistaLogic deportistaLogic;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<DeportistaEntity> data = new ArrayList<>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DeportistaEntity.class.getPackage())
                .addPackage(DeportistaLogic.class.getPackage())
                .addPackage(DeportistaPersistenc.class.getPackage())
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
        em.createQuery("delete from DeportistaEntity").executeUpdate();
        em.createQuery("delete from ObjetivoEntity").executeUpdate();
    }
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData()
    {
        //______________________________________________TODO!!!!!!!!!____________________________________
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i<10 ; i++)
        {
            DeportistaEntity entidad = factory.manufacturePojo(DeportistaEntity.class);
            
            em.persist (entidad);
            entidad.setObjetivos(new ArrayList<>());
            data.add (entidad);
        }
        
        DeportistaEntity deportista = data.get(5);
        ObjetivoEntity objetivo = factory.manufacturePojo(ObjetivoEntity.class);
        objetivo.setDeportista(deportista);
        em.persist(objetivo);
        deportista.getObjetivos().add(objetivo);
    }
    /**
     * Prueba para crear un deportista.
     */
    @Test
    public void CreateDeportistaTest()
    {
        DeportistaEntity nuevoDeportistaEntity = factory.manufacturePojo(DeportistaEntity.class);
        DeportistaEntity result = deportistaLogic.createDeportista(nuevoDeportistaEntity);
        Assert.assertNotNull(result);
        DeportistaEntity entity = em.find(DeportistaEntity.class, result.getId());
        Assert.assertEquals(nuevoDeportistaEntity.getId(), entity.getId());
        Assert.assertEquals(nuevoDeportistaEntity.getCedula(), entity.getCedula());
        Assert.assertEquals(nuevoDeportistaEntity.getFechaNacimiento(), entity.getFechaNacimiento());
    }
    
    /**
     * Prueba para consultar la lista de deportistas.
     */
    @Test
    public void getDeportistasTest() {
        List<DeportistaEntity> list = deportistaLogic.getDeportistas();
        Assert.assertEquals(data.size(), list.size());
        for (DeportistaEntity entity : list) {
            boolean found = false;
            for (DeportistaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un deportista.
     */
    @Test
    public void getDeportistaTest() {
        DeportistaEntity entity = data.get(0);
        DeportistaEntity resultEntity = deportistaLogic.getDeportista(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getFechaNacimiento(), resultEntity.getFechaNacimiento());
    }
    /**
     * Prueba para actualizar un deportista.
     */
    @Test
    public void updateDeportistaTest() {
        DeportistaEntity entity = data.get(0);
        DeportistaEntity pojoEntity = factory.manufacturePojo(DeportistaEntity.class);

        pojoEntity.setId(entity.getId());

        deportistaLogic.updateDeportista(pojoEntity.getId(), pojoEntity);

        DeportistaEntity resp = em.find(DeportistaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getFechaNacimiento(), resp.getFechaNacimiento());
    }

    /**
     * Prueba para eliminar un Deportista
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void deleteDeportistaTest() throws BusinessLogicException {
        DeportistaEntity entity = data.get(0);
        deportistaLogic.deleteDeportista(entity.getId());
        DeportistaEntity deleted = em.find(DeportistaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
