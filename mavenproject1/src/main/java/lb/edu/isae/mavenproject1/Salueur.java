package lb.edu.isae.mavenproject1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/hello"})
public class Salueur extends HttpServlet {
    private static final String ERREUR= "S'il vous plait, indiquez "+
    "votre nom dans l'url\n"+
    "ainsi: http://localhost:8080/hello?nom=toto";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String nom = req.getParameter("nom");
        resp.setCharacterEncoding("utf-8");
        if (nom == null) {
            resp.getWriter().println(ERREUR);
        } else {
            resp.getWriter().println("Bonjour "+ nom);
        }
    }
    
}