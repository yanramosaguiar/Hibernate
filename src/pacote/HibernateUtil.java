/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Yan
 */
public class HibernateUtil {

    public static Session getSessionFactory() {
        Logger.getRootLogger().setLevel(Level.WARN);
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();

        // obtains the session
        Session session = sessionFactory.openSession();
        return session;
    }
}
