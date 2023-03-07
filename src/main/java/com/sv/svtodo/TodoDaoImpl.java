package com.sv.svtodo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.List;
public class TodoDaoImpl implements TodoDao {

    Configuration con = new Configuration().configure().addAnnotatedClass(Todo.class);
    StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    SessionFactory sf = con.buildSessionFactory(reg);
    public TodoDaoImpl() {
    }

    @Override
    public boolean authorization(String username, String password) throws SQLException {
        Transaction transaction = null;
        User usr = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            usr = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", username)
                    .uniqueResult();
            if (usr != null && usr.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insertTodo(Todo todo) throws SQLException {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.persist(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Todo selectTodo(int todoId) {
        Transaction transaction = null;
        Todo todo = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            todo = session.get(Todo.class, todoId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public List<Todo> selectAllTodos() {

        Transaction transaction = null;
        List<Todo> todos = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            todos = session.createQuery("from Todo").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public void deleteTodo(int id) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Todo todo = session.get(Todo.class, id);
            if (todo != null) {
                session.remove(todo);
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void updateTodo(Todo todo) throws SQLException {

        Transaction transaction = null;
        try (Session session = sf.openSession()) {

            transaction = session.beginTransaction();

            session.update(todo);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

