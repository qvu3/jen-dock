package com.sv.svtodo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    TodoDao dao = new TodoDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String udesc = req.getParameter("u-desc");
        String ustat = req.getParameter("u-stat");

        Todo updateTodo = new Todo(id, udesc, ustat);

        try {
            dao.updateTodo(updateTodo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("ListServlet");
    }
}
