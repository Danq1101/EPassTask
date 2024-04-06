package com.example.task.config;

import com.example.task.domain.Parties;
import com.example.task.domain.TradeItems;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Parties.class);
                configuration.addAnnotatedClass(TradeItems.class);

                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                System.out.println("Exceptions: " + e);
            }
        }
        return sessionFactory;
    }
}
