/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.testLogic;

import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioMaquinasLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
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
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class EjercicioMaquinasLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EjercicioLogic ejercicioLogic;
    @Inject
    private EjercicioMaquinasLogic ejercicioMaquinasLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EjercicioEntity> data = new ArrayList<EjercicioEntity>();

    private List<MaquinaEntity> maquinasData = new ArrayList();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EjercicioEntity.class.getPackage())
                .addPackage(EjercicioLogic.class.getPackage())
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
        em.createQuery("delete from MaquinaEntity").executeUpdate();
        em.createQuery("delete from EjercicioEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            MaquinaEntity maquinas = factory.manufacturePojo(MaquinaEntity.class);
            em.persist(maquinas);
            maquinasData.add(maquinas);
        }
        for (int i = 0; i < 3; i++) {
            EjercicioEntity entity = factory.manufacturePojo(EjercicioEntity.class);
            em.persist(entity);
            data.add(entity);
            if (i == 0) {
                maquinasData.get(i).setEjercicio(entity);
            }
        }
    }

    /**
     * Prueba para asociar un Maquinas existente a un Ejercicio.
     */
    @Test
    public void addMaquinasTest() {
        EjercicioEntity entity = data.get(0);
        MaquinaEntity maquinaEntity = maquinasData.get(1);
        MaquinaEntity response = ejercicioMaquinasLogic.addMaquina(maquinaEntity.getId(), entity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(maquinaEntity.getId(), response.getId());
    }

    /**
     * Prueba para obtener una colección de instancias de Maquinas asociadas a una
     * instancia Ejercicio.
     */
    @Test
    public void getMaquinasTest() {
        List<MaquinaEntity> list = ejercicioMaquinasLogic.getMaquinas(data.get(0).getId());

        Assert.assertEquals(1, list.size());
    }

    /**
     * Prueba para obtener una instancia de Maquinas asociada a una instancia
     * Ejercicio
     *
     * @throws co.edu.uniandes.csw.maquinastore.exceptions.BusinessLogicException
     */
    @Test
    public void getMaquinaTest() throws BusinessLogicException {
        EjercicioEntity entity = data.get(0);
        MaquinaEntity maquinaEntity = maquinasData.get(0);
        MaquinaEntity response = ejercicioMaquinasLogic.getMaquina(entity.getId(), maquinaEntity.getId());

        Assert.assertEquals(maquinaEntity.getId(), response.getId());
        Assert.assertEquals(maquinaEntity.getNombre(), response.getNombre());
        
    }

    /**
     * Prueba para obtener una instancia de Maquinas asociada a una instancia
     * Ejercicio que no le pertenece.
     *
     * @throws co.edu.uniandes.csw.maquinastore.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void getMaquinaNoAsociadoTest() throws BusinessLogicException {
        EjercicioEntity entity = data.get(0);
        MaquinaEntity maquinaEntity = maquinasData.get(1);
        ejercicioMaquinasLogic.getMaquina(entity.getId(), maquinaEntity.getId());
    }

    /**
     * Prueba para remplazar las instancias de Maquinas asociadas a una instancia
     * de Ejercicio.
     */
    @Test
    public void replaceMaquinasTest() {
        EjercicioEntity entity = data.get(0);
        List<MaquinaEntity> list = maquinasData.subList(1, 3);
        ejercicioMaquinasLogic.replaceMaquinas(entity.getId(), list);

        entity = ejercicioLogic.getEjercicio(entity.getId());
        Assert.assertFalse(entity.getMaquinas().contains(maquinasData.get(0)));
        Assert.assertTrue(entity.getMaquinas().contains(maquinasData.get(1)));
        Assert.assertTrue(entity.getMaquinas().contains(maquinasData.get(2)));
    }
}
