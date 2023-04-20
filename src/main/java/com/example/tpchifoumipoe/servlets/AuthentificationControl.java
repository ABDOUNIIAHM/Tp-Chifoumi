package com.example.tpchifoumipoe.servlets;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = "/*")
public class AuthentificationControl extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        // cette classe intervient pour chaque requete avec un URI (/*)
        //TODO: controle des credentials pour chaque user dans notre bdd

        if(req.getRequestURI().equals(req.getContextPath() + "/login")||req.getRequestURI().equals(req.getContextPath() + "/signup")) { // cette ligne autorise l'accès à l'URI /login
            chain.doFilter(req, res);
        }else{
            if(session.getAttribute("identifier") != null){ //vérification des bons crédentials
                chain.doFilter(req,res); // autorise la continuité définie dans les servlets
            }else{
                res.sendRedirect(getServletContext().getContextPath()+"/login");
            }
        }
    }
}
