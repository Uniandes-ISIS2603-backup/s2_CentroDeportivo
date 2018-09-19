/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;

import co.edu.uniandes.csw.centrodeportivo.ejb.ObjetivoDeportistasLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ObjetivoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
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
 *
 * @author Leidy Romero
 */
@RunWith(Arquillian.class)
public class ObjetivoDeportistasLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
   @Inject 
   private ObjetivoLogic objetivoLogic;
   @Inject
   private ObjetivoDeportistasLogic objetivoDeportistasLogic;
   
   @PersistenceContext
   private EntityManager em;
   
   @Inject
   private UserTransaction utx;
      
   private List<ObjetivoEntity> data = new ArrayList<ObjetivoEntity>();
   
   private List<DeportistaEntity> deportistasData = new ArrayList<>();
   
   /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ObjetivoEntity.class.getPackage())
                .addPackage(ObjetivoLogic.class.getPackage())
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
        em.createQuery("delete from DeportistaEntity").executeUpdate();
        em.createQuery("delete from ObjetivoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            DeportistaEntity deportistas = factory.manufacturePojo(DeportistaEntity.class);
            em.persist(deportistas);
            deportistasData.add(deportistas);
        }
        for (int i = 0; i < 3; i++) {
            ObjetivoEntity entity = factory.manufacturePojo(ObjetivoEntity.class);
            em.persist(entity);
            data.add(entity);
            if (i == 0) {
                deportistasData.get(i).setObjetivo(entity);
            }
        }
    }
    
    /**
     * Prueba para asociar un Deportista existente a una Objetivo.
     */
    @Test
    public void addDeportistaTest() {
        ObjetivoEntity entity = data.get(0);
        DeportistaEntity deportistaEntity = deportistasData.get(1);
        DeportistaEntity response = objetivoDeportistasLogic.addDeportista(deportistaEntity.getId(), entity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(deportistaEntity.getId(), response.getId());
    }
    
    /**
     * Prueba para obtener una colección de instancias de Deportistas asociadas a una
     * instancia Objetivo.
     */
    @Test
    public void getDeportistasTest() {
        List<DeportistaEntity> list = objetivoDeportistasLogic.getDeportistas(data.get(0).getId());

        Assert.assertEquals(1, list.size());
    }
    
    /**
     * Prueba para obtener una instancia de Deportista asociada a una instancia
     * Objetivo.
     *
     * @throws co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException
     */
    @Test
    public void getDeportistaTest() throws BusinessLogicException {
        ObjetivoEntity entity = data.get(0);
        DeportistaEntity deportistaEntity = deportistasData.get(0);
        DeportistaEntity response = objetivoDeportistasLogic.getDeportista(entity.getId(), deportistaEntity.getId());

        Assert.assertEquals(deportistaEntity.getId(), response.getId());
        Assert.assertEquals(deportistaEntity.getCedula(), response.getCedula());

    }

    /**
     * Prueba para obtener una instancia de Deportista asociada a una instancia
     * Objetivo que no le pertenece.
     *
     * @throws co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void getDeportistaNoAsociadoTest() throws BusinessLogicException {
        ObjetivoEntity entity = data.get(0);
        DeportistaEntity deportistaEntity = deportistasData.get(1);
        objetivoDeportistasLogic.getDeportista(entity.getId(), deportistaEntity.getId());    
    }
    
    /**
     * Prueba para remplazar las instancias de Deportistas asociadas a una instancia
     * de Objetivo.
     */
    @Test
    public void replaceDeportistasTest() {
        ObjetivoEntity entity = data.get(0);
        List<DeportistaEntity> list = deportistasData.subList(1, 3);
        objetivoDeportistasLogic.replaceDeportistas(entity.getId(), list);

        entity = objetivoLogic.getObjetivo(entity.getId());
        Assert.assertFalse(entity.getCasosExitosos().contains(deportistasData.get(0)));
        Assert.assertTrue(entity.getCasosExitosos().contains(deportistasData.get(1)));
        Assert.assertTrue(entity.getCasosExitosos().contains(deportistasData.get(2)));
    }
}
