/**
 * Gerencia conexao com o banco de dados.
 */
package com.douglas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author douglas
 */
public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try{
            System.out.println("Tentando configurar uma Session Factory");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Session Factory criada corretamente");
        }catch(Exception ex){
            System.out.println("Falhou na construção da Session Factory");
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSESSION_FACTORY() {
        return SESSION_FACTORY;
    }
}
