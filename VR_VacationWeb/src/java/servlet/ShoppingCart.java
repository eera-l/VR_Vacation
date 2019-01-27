package servlet;

import bean.ShoppingCartBean;
import bean.UserBean;
import global.DataStorage;
import hibernate.Experience;
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
        
        
        if (DataStorage.getInstance().getShoppingCart() != null) {
            shoppingCartBean = new ShoppingCartBean();
            if (shoppingCartBean.getShoppingCart().getPackages().size() > 0 || shoppingCartBean.getShoppingCart().getExperiences().size() > 0) {
                
                //shoppingCartBean = new ShoppingCartBean();
                ArrayList<Package> packages = shoppingCartBean.getShoppingCart().getPackages();
                ArrayList<Experience> experiences = shoppingCartBean.getShoppingCart().getExperiences();        
                request.setAttribute("packages", packages);
                request.setAttribute("experiences", experiences);
                request.setAttribute("introText", "Items in your shopping cart: ");
                request.setAttribute("total", "Total: " + shoppingCartBean.getShoppingCart().getTotal() + " SEK.");
                request.setAttribute("error", "");
                request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
                
            } else {
                request.setAttribute("introText", "There are no items in your shopping cart.");
                request.setAttribute("error", "Please put at least one item in your shopping cart to proceed.");
                request.setAttribute("total", "");
                request.setAttribute("packages", null);
                request.setAttribute("experiences", null);
                request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
            }
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
            shoppingCartBean.removePackage(id);
        }
        
        if (request.getParameter("experience_to_remove") != null) {
            int id = Integer.parseInt(request.getParameter("experience_to_remove"));
            shoppingCartBean.removeExperience(id);
        }
        
        if (request.getParameter("checkout") != null) {
            if (!userBean.checkIfUserLoggedIn()) {
                request.getRequestDispatcher("/logIn.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/loading.jsp").forward(request, response);
            }
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
