package ru.job4j.todo.servlet;

import ru.job4j.todo.model.User;
import ru.job4j.todo.persistence.HbmStore;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User dbUser = HbmStore.instOf().findUserByEmail(email);
        if (dbUser == null) {
            User newUser = User.of(userName, email, password);
            HbmStore.instOf().addUser(newUser);
            HttpSession sc = req.getSession();
            sc.setAttribute("user", newUser);
            resp.sendRedirect(req.getContextPath());
        } else {
            req.setAttribute("error", "Пользователь с такой почтой уже зарегистрирован");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
