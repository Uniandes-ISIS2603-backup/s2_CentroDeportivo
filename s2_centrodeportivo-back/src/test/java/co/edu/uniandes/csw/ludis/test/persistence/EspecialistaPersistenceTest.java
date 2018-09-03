/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ludis.test.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.EspecialistaPersistence;
import java.lang.reflect.Type;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import uk.co.jemos.podam.api.ClassInfoStrategy;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Mac
 */
public class EspecialistaPersistenceTest {
    
 @Inject
 private EspecialistaPersistence especialistaPersistence;
 @PersistenceContext
 private EntityManager em;
     
 @Test
 public void createEspecialistaTest()
 {
     PodamFactory factory =new PodamFactoryImpl();
     EspecialistaEntity newEntity =factory.manufacturePojo(EspecialistaEntity.class);
     EspecialistaEntity result= especialistaPersistence.create(newEntity);
     
     Assert.assertNotNull(result);
     EspecialistaEntity entity=em.find(EspecialistaEntity.class, result.getId());
     org.junit.Assert.assertEquals(newEntity.getName(), entity.getName());
 }
  @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspecialistaEntity.class.getPackage())
                .addPackage(EspecialistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

}
