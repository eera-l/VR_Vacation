package servlet;

import bean.ShoppingCartBean;
import bean.UserBean;
import java.io.IOException;
import hibernate.Package;
import java.util.ArrayList;
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
 * @author Felicity
 */
@WebServlet(name = "ShoppingCart", urlPatterns = {"/ShoppingCart"})
public class ShoppingCart extends HttpServlet {

    ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
    
    @EJB
    UserBean userBean;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (userBean.checkIfUserLoggedIn()) {
            shoppingCartBean = new ShoppingCartBean();
            ArrayList<Package> packages = shoppingCartBean.getShoppingCart().getPackages();

            request.setAttribute("packages", packages);
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/logIn.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("package_to_remove") != null) {
            int id = Integer.parseInt(request.getParameter("package_to_remove"));
            shoppingCartBean.removeItem(id);
        }
        processRequest(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
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

}
