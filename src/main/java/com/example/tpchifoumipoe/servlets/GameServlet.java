package com.example.tpchifoumipoe.servlets;

import com.example.tpchifoumipoe.entities.Game;
import com.example.tpchifoumipoe.repository.GameDao;
import com.example.tpchifoumipoe.repository.IntGameDao;
import com.example.tpchifoumipoe.service.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/game")
public class GameServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            IntGameDao gameDao = (IntGameDao) req.getSession().getAttribute("gameDao");
            HttpSession session = req.getSession();
            GameService gameService = (GameService) session.getAttribute("gameService");
            Game game = gameService.getGame();
            game.setUserChoice(null);
            List<Game> games = gameDao.findAll();
            req.setAttribute("games",games);

            req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req,resp);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            HttpSession session = req.getSession();
            GameService gameService = (GameService) session.getAttribute("gameService");
            GameDao gameDao = (GameDao) session.getAttribute("gameDao");
            Game game = gameService.getGame();
            game.setUserChoice(req.getParameter("choice"));
            game.setServerChoice(gameService.serverChoice());
            gameService.checkWin(game.getUserChoice(),game.getServerChoice());
            gameDao.save(game);
            List<Game> games = gameDao.findAll();
            req.setAttribute("games",games);
            req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req,resp);
            game.setUserChoice(null);
            //game.setUserChoice(req.getParameter("choice"));


        }
    }

