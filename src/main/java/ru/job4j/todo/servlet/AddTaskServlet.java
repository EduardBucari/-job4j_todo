package ru.job4j.todo.servlet;

import ru.job4j.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        String description = req.getParameter("description");
        String userEmail = req.getParameter("userEmail");
        String[] categories = req.getParameterValues("categories[]");
        TodoService.instOf().addTask(task, description, userEmail, categories);
    }
}
