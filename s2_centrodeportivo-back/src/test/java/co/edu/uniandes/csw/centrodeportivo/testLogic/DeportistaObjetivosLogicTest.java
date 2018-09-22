/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;

import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaObjetivosLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
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
public class DeportistaObjetivosLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
   @Inject 
   private DeportistaLogic deportistaLogic;
   @Inject
   private DeportistaObjetivosLogic deportistaObjetivosLogic;
   
   @PersistenceContext
   private EntityManager em;
   
   @Inject
   private UserTransaction utx;
      
   private List<DeportistaEntity> data = new ArrayList<DeportistaEntity>();
   
   private List<ObjetivoEntity> objetivosData = new ArrayList<>();
   
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
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from ObjetivoEntity").executeUpdate();
        em.createQuery("delete from DeportistaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ObjetivoEntity objetivos = factory.manufacturePojo(ObjetivoEntity.class);
            em.persist(objetivos);
            objetivosData.add(objetivos);
        }
        for (int i = 0; i < 3; i++) {
            DeportistaEntity entity = factory.manufacturePojo(DeportistaEntity.class);
            em.persist(entity);
            data.add(entity);
            if (i == 0) {
                objetivosData.get(i).setDeportista(entity);
            }
        }
    }
    
    /**
     * Prueba para asociar un Objetivo existente a una Deportista.
     */
    @Test
    public void addObjetivoTest() {
        DeportistaEntity entity = data.get(0);
        ObjetivoEntity objetivoEntity = objetivosData.get(1);
        ObjetivoEntity response = deportistaObjetivosLogic.addObjetivo(objetivoEntity.getId(), entity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(objetivoEntity.getId(), response.getId());
    }
    
    /**
     * Prueba para obtener una colección de instancias de Objetivos asociadas a una
     * instancia Deportista.
     */
    @Test
    public void getObjetivosTest() {
        List<ObjetivoEntity> list = deportistaObjetivosLogic.getObjetivos(data.get(0).getId());

        Assert.assertEquals(1, list.size());
    }
    
    /**
     * Prueba para obtener una instancia de Objetivo asociada a una instancia
     * Deportista.
     *
     * @throws co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException
     */
    @Test
    public void getObjetivoTest() throws BusinessLogicException {
        DeportistaEntity entity = data.get(0);
        ObjetivoEntity objetivoEntity = objetivosData.get(0);
        ObjetivoEntity response = deportistaObjetivosLogic.getObjetivo(entity.getId(), objetivoEntity.getId());

        Assert.assertEquals(objetivoEntity.getId(), response.getId());
        Assert.assertEquals(objetivoEntity.getDescripcion(), response.getDescripcion());
    }

    /**
     * Prueba para obtener una instancia de Objetivo asociada a una instancia
     * Deportista que no le pertenece.
     *
     * @throws co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void getObjetivoNoAsociadoTest() throws BusinessLogicException {
        DeportistaEntity entity = data.get(0);
        ObjetivoEntity objetivoEntity = objetivosData.get(1);
        deportistaObjetivosLogic.getObjetivo(entity.getId(), objetivoEntity.getId());    
    }
    /**
     * Prueba para remplazar las instancias de Objetivos asociadas a una instancia
     * de Deportista.
     */
    @Test
    public void replaceObjetivosTest() {
        DeportistaEntity entity = data.get(0);
        List<ObjetivoEntity> list = objetivosData.subList(1, 3);
        deportistaObjetivosLogic.replaceObjetivos(entity.getId(), list);

        entity = deportistaLogic.getDeportista(entity.getId());
        Assert.assertFalse(entity.getObjetivos().contains(objetivosData.get(0)));
        Assert.assertTrue(entity.getObjetivos().contains(objetivosData.get(1)));
        Assert.assertTrue(entity.getObjetivos().contains(objetivosData.get(2)));
    }
}
