package com.example.tpchifoumipoe.servlets;

import com.example.tpchifoumipoe.entities.User;
import com.example.tpchifoumipoe.repository.IntUserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IntUserDao userDao = (IntUserDao) req.getSession().getAttribute("userDao");
        List<User> users = userDao.findAll();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/WEB-INF/Users.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IntUserDao userDao = (IntUserDao) req.getSession().getAttribute("userDao");
        int id = Integer.parseInt(req.getParameter("delete-user"));
        userDao.deleteById(id);

        resp.sendRedirect(getServletContext().getContextPath()+"/users");
    }
}
