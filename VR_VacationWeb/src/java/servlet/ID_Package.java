package servlet;

import bean.PackageBean;
import bean.ShoppingCartBean;
import bean.UserBean;
import java.io.IOException;
import javax.ejb.EJB;
import hibernate.Package;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ID_Package", urlPatterns = {"/ID_Package"})
public class ID_Package extends HttpServlet {

    ShoppingCartBean shoppingCartBean = lookupShoppingCartBeanBean();

    @EJB
    private PackageBean packageBean;
    
    @EJB
    private UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (userBean.checkIfUserLoggedIn()) {
            request.setAttribute("userLogged", true);
        } else {
            request.setAttribute("userLogged", false);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String id = request.getParameter("packageId");
        if (id != null) {
            Package aPackage = packageBean.getPackageWithID(Integer.parseInt(id));
            request.setAttribute("package", aPackage);
            request.getRequestDispatcher("/id_package.jsp").forward(request, response);
        }
        
                //TODO:
        //handle add to cart
        String addToCartId = request.getParameter("addPackToCart");
        if (!request.getParameter("addPackToCart").equalsIgnoreCase("")) {
            //get package to add to cart
            Package aPackage = packageBean.getPackageWithID(Integer.parseInt(addToCartId));
            //call shopping cart bean
            shoppingCartBean.addItems(aPackage);
            //return to current page
            response.getWriter().write("Package added to cart");
        }


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
