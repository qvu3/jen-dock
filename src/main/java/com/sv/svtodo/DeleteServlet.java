package com.sv.svtodo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    TodoDao dao = new TodoDaoImpl();
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            dao.deleteTodo(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ListServlet");
    }
}
