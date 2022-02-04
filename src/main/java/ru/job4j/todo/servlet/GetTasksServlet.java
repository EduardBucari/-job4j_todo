package ru.job4j.todo.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.todo.service.TodoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


    public class GetTasksServlet extends HttpServlet {

        private static final Gson GSON = new GsonBuilder()
                .setDateFormat("dd/MM/yy HH:mm").create();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json; charset=utf-8");
            OutputStream output = resp.getOutputStream();
            String json = GSON.toJson(TodoService.instOf().findAllTasks());
            output.write(json.getBytes(StandardCharsets.UTF_8));
            output.flush();
            output.close();
        }

    }
