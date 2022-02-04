package ru.job4j.todo.servlet;

import ru.job4j.todo.model.User;
import ru.job4j.todo.persistence.HbmStore;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User dbUser = HbmStore.instOf().findUserByEmail(email);
        if (dbUser != null && dbUser.getPassword().equals(password)) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", dbUser);
            sc.setAttribute("categories", HbmStore.instOf().findAllCategories());
            resp.sendRedirect(req.getContextPath());
        } else {
            req.setAttribute("error", "Не верный email или пароль");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
