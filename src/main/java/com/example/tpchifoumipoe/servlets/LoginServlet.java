package com.example.tpchifoumipoe.servlets;

import com.example.tpchifoumipoe.repository.GameDao;
import com.example.tpchifoumipoe.repository.IntGameDao;
import com.example.tpchifoumipoe.repository.IntUserDao;
import com.example.tpchifoumipoe.repository.UserDao;
import com.example.tpchifoumipoe.service.GameService;
import com.example.tpchifoumipoe.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        setService(req); // adding service and dao to session attributs
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = (UserService) session.getAttribute("userService");
        String id = req.getParameter("identifier");
        String password = req.getParameter("password");
        if(userService.validAuthentification(id, password) == true){
            session.setAttribute("identifier", id);
            resp.sendRedirect(getServletContext().getContextPath()+"/home");
        }else{
            String message = "Incorrect id or password, try again !";
            req.setAttribute("error",message);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }
    }
    public void setService(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("userDao")==null){
            IntUserDao userDao = new UserDao();
            session.setAttribute("userDao",userDao);
        }
        IntUserDao userDao = (IntUserDao) session.getAttribute("userDao");
        if(session.getAttribute("userService")==null){
            UserService userService = new UserService(userDao);
            session.setAttribute("userService",userService);
        }
        if(session.getAttribute("gameDao")==null){
            IntGameDao gameDao = new GameDao();
            session.setAttribute("gameDao",gameDao);
        }
        IntGameDao gameDao = (IntGameDao) session.getAttribute("gameDao");
        if(session.getAttribute("gameService")==null){
            GameService gameService = new GameService(gameDao);
            session.setAttribute("gameService",gameService);
        }
    }
}
