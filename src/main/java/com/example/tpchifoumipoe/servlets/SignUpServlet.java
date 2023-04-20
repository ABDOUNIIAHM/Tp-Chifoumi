package com.example.tpchifoumipoe.servlets;

import com.example.tpchifoumipoe.entities.User;
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
import java.sql.SQLException;

@WebServlet(urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/signup.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        setService(req);
        IntUserDao userDao = (IntUserDao) session.getAttribute("userDao");
        UserService userService = (UserService) session.getAttribute("userService");

        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String mdps = req.getParameter("mdps");

        try {
            if(userService.validInscription(id) == true){
                try {
                    userDao.save(new User(name,id,mdps));
                    resp.sendRedirect(getServletContext().getContextPath()+"/signup");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                String message = "Sorry your id is not available, choose another one !";
                req.setAttribute("error",message);
                req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
