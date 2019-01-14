package servlet;

import bean.DestinationBean;
import java.io.IOException;
import hibernate.Destination;
import java.util.List;
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
@WebServlet(name = "Destinations", urlPatterns = {"/Destinations"})
public class Destinations extends HttpServlet {

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
        //Send destinations as list of objects with ID
        List<Destination> destinations = destinationBean.getAllDestinations();
        request.setAttribute("destinations", destinations);
        //load page
        request.getRequestDispatcher("/destinations.jsp").forward(request, response);
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
