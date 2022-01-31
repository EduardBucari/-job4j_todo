package ru.job4j.todo.servlet;

import ru.job4j.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ChangeTaskStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean done = Boolean.parseBoolean(req.getParameter("done"));
        TodoService.instOf().changeTaskStatus(id, done);
    }
}
