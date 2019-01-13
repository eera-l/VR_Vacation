package servlet;

import bean.DestinationBean;
import hibernate.Destination;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felicity
 */
@WebServlet(name = "ID_Destination", urlPatterns = {"/ID_Destination"})
public class ID_Destination extends HttpServlet {

    @EJB
    private DestinationBean destinationBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //return destination id from jsp page button click
        //forward to id jsp page
        Integer id = Integer.valueOf(request.getParameter("destinationId"));
        Destination destination = destinationBean.findDestinationByID(id);
        request.setAttribute("destination", destination);
        request.getRequestDispatcher("/id_destination.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
