package com.sv.svtodo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {

    TodoDao dao = new TodoDaoImpl();

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Todo> listTodo = dao.selectAllTodos();
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }
}
