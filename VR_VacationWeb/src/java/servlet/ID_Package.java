package servlet;

import bean.ExperienceBean;
import bean.PackageBean;
import bean.ShoppingCartBean;
import bean.UserBean;
import global.DataStorage;
import global.ShoppingCart;
import hibernate.Experience;
import java.io.IOException;
import javax.ejb.EJB;
import hibernate.Package;
import java.util.List;
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

    @EJB
    private ExperienceBean experienceBean;

    @EJB
    ShoppingCartBean shoppingCartBean = lookupShoppingCartBeanBean();

    @EJB
    private PackageBean packageBean;

    @EJB
    private UserBean userBean;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        if (request.getParameter("packageId") != null && !request.getParameter("packageId").equalsIgnoreCase("")) {
            String id = request.getParameter("packageId");
            Package aPackage = packageBean.getPackageWithID(Integer.parseInt(id));
            List<Experience> experiences = experienceBean.getExperiences(aPackage);
            request.setAttribute("package", aPackage);
            request.setAttribute("experiences", experiences);
            request.getRequestDispatcher("/id_package.jsp").forward(request, response);
        } else if (request.getParameter("addPackToCart") != null && !request.getParameter("addPackToCart").equalsIgnoreCase("")) {
            if (DataStorage.getInstance().getShoppingCart() == null) {
                DataStorage.getInstance().setShoppingCart(new ShoppingCart());
            }
            shoppingCartBean = new ShoppingCartBean();
            //get package to add to cart
            String addToCartId = request.getParameter("addPackToCart");
            Package aPackage = packageBean.getPackageWithID(Integer.parseInt(addToCartId));
            //call shopping cart bean
            shoppingCartBean.addPackage(aPackage);
            //return to current page
            response.getWriter().write("Package added to cart");
        } else if (request.getParameter("addExpToCart") != null && !request.getParameter("addExpToCart").equalsIgnoreCase("")) {
            //get package to add to cart
            if (DataStorage.getInstance().getShoppingCart() == null) {
                DataStorage.getInstance().setShoppingCart(new ShoppingCart());
            }
            shoppingCartBean = new ShoppingCartBean();
            String addExpToCartId = request.getParameter("addExpToCart");
            Experience experience = experienceBean.getExperienceById(Integer.parseInt(addExpToCartId) / 10);
            //call shopping cart bean
            shoppingCartBean.addExperience(experience);
            //return to current page
            response.getWriter().write("Experience added to cart");
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
