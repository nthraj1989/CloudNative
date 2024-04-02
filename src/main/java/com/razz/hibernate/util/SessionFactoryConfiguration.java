package com.razz.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.engine.spi.SubselectFetch;

public class SessionFactoryConfiguration {

    private static SessionFactory sf = null;

    private SessionFactoryConfiguration(){

    }

    public static SessionFactory getSessionFactory(){
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                                                     .configure("hibernate.cfg.xml")
                                                     .build();
        sf = new MetadataSources(standardServiceRegistry)
                                    .buildMetadata()
                                    .buildSessionFactory();
        return sf;
    }
}
