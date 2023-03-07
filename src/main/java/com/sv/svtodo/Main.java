package com.sv.svtodo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class Main {
    public static void main(String[] args){

        Configuration con = new Configuration().configure().addAnnotatedClass(Todo.class);
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session ss = sf.openSession();

        ss.getTransaction().begin();

        Todo todo = new Todo("something else","done");
        ss.persist(todo);

        ss.getTransaction().commit();
        ss.close();
    }
}
