package com.sv.svtodo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    TodoDao dao = new TodoDaoImpl();

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        try {
            if (dao.authorization(uname, password)) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
//                dispatcher.forward(request, response);
                response.sendRedirect("ListServlet");
            } else {
                response.getWriter().println("Login not successful...");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
