package ru.job4j.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.todo.model.Item;
import ru.job4j.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddTask extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = GSON.fromJson(req.getReader(), Item.class);
        TodoService.instOf().addTask(item);
    }
}
