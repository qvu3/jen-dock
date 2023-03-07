package com.sv.svtodo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

    TodoDao dao = new TodoDaoImpl();

    Configuration con = new Configuration().configure().addAnnotatedClass(Todo.class);
    StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    SessionFactory sf = con.buildSessionFactory(reg);

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transaction transaction = null;
//
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            List<Todo> todos = session.createQuery("FROM Todo").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

//        String desc = req.getParameter("desc");
//        String stat = req.getParameter("stat");
//        Todo todo = new Todo(desc,stat);
//
//        try {
//            dao.insertTodo(todo);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        resp.sendRedirect("ListServlet");
    }
}
