/*
 * UserPageServlet.java
 * Handles information for the user page. Returns
 * user info if the user is logged in.
 */
package servlet;

import bean.ShoppingCartBean;
import bean.UserBean;
import global.DataStorage;
import hibernate.Order;
import hibernate.Package;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Federica
 */
@WebServlet(name = "UserPageServlet", urlPatterns = {"/UserPageServlet"})
public class UserPageServlet extends HttpServlet {

    @EJB
    private ShoppingCartBean scb = lookupShoppingCartBeanBean();
    
    @EJB
    private UserBean userBean;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (DataStorage.getInstance().isCheckOut()) {
            request.setAttribute("result", scb.checkOut());
            DataStorage.getInstance().setCheckOut(false);
        }
        request.setAttribute("user_first_name", userBean.getFirstName());
        request.setAttribute("user_last_name", userBean.getLastName());
        request.setAttribute("email_address", userBean.getEmail());
        List<Order> orders = userBean.returnUserOrders();
        
        request.setAttribute("orders", orders);
        
        request.getRequestDispatcher("/userpage.jsp").forward(request, response);
        
    }
    private ShoppingCartBean lookupShoppingCartBeanBean() {
        try {
            Context c = new InitialContext();
            return (ShoppingCartBean) c.lookup("java:global/VR_VacationWeb/ShoppingCartBean!bean.ShoppingCartBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
