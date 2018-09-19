/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;

import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoEjercicioLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
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
 * @author Daniel Pardo
 */
@RunWith(Arquillian.class)
public class ZonaCuerpoEjercicioLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ZonaCuerpoLogic zonaCuerpoLogic;
    @Inject
    private ZonaCuerpoEjercicioLogic zonaCuerpoEjercicioLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EjercicioEntity> data = new ArrayList<EjercicioEntity>();

    private List<ZonaCuerpoEntity> zonasCuerpoData = new ArrayList();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EjercicioEntity.class.getPackage())
                .addPackage(ZonaCuerpoLogic.class.getPackage())
                .addPackage(EjercicioPersistence.class.getPackage())
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
        em.createQuery("delete from ZonaCuerpoEntity").executeUpdate();
        em.createQuery("delete from EjercicioEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ZonaCuerpoEntity zonasCuerpo = factory.manufacturePojo(ZonaCuerpoEntity.class);
            em.persist(zonasCuerpo);
            zonasCuerpoData.add(zonasCuerpo);
        }
        for (int i = 0; i < 3; i++) {
            EjercicioEntity entity = factory.manufacturePojo(EjercicioEntity.class);
            em.persist(entity);
            data.add(entity);
            if (i == 0) {
                zonasCuerpoData.get(i).setEjercicio(entity);
            }
        }
    }

    /**
     * Prueba para remplazar las instancias de ZonasCuerpo asociadas a una instancia
     * de Ejercicio.
     */
    @Test
    public void replaceEjercicioTest() {
        ZonaCuerpoEntity entity = zonasCuerpoData.get(0);
        zonaCuerpoEjercicioLogic.replaceEjercicio(entity.getId(), data.get(1).getId());
        entity = zonaCuerpoLogic.getZonaCuerpo(entity.getId());
        Assert.assertEquals(entity.getEjercicio(), data.get(1));
    }

    /**
     * Prueba para desasociar un ZonaCuerpo existente de un Ejercicio existente
     *
     * @throws co.edu.uniandes.csw.zonasCuerpotore.exceptions.BusinessLogicException
     */
    @Test
    public void removeZonasCuerpoTest() throws BusinessLogicException {
        zonaCuerpoEjercicioLogic.removeEjercicio(zonasCuerpoData.get(0).getId());
        ZonaCuerpoEntity response = zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoData.get(0).getId());
        Assert.assertNull(response.getEjercicio());
    }
}
