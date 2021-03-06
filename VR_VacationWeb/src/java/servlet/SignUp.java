package servlet;

import bean.EmailBean;
import bean.ShoppingCartBean;
import bean.SignUpBean;
import global.DataStorage;
import hibernate.User;
import java.io.IOException;
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
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    ShoppingCartBean shoppingCartBean = lookupShoppingCartBeanBean();

    @EJB
    private EmailBean emailBean;

    @EJB
    private SignUpBean signUpBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");

        shoppingCartBean.sendJMSMessageToVrQueue(email);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //load page
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //get data from form
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String street = request.getParameter("street");
        String zipCode = request.getParameter("zipCode");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String creditCardNumber = request.getParameter("creditCardNumber");

        //create new user
        User user = new User(email, userName, password, firstName, lastName,
                phoneNumber, street, zipCode, city, country, creditCardNumber
        );

        //if user doesnt already exists
        if (signUpBean.checkIfUserExists(email)) {
            request.setAttribute("user", user);
            request.setAttribute("error", "User already exists");
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }

        //IF error in form 
        //error message all feilds are required
        if (request.getParameter("email")!= null && email.isEmpty() || 
                request.getParameter("userName")!= null && userName.isEmpty() || 
                request.getParameter("password")!= null && password.isEmpty() || 
                request.getParameter("firstName")!= null && firstName.isEmpty() || 
                request.getParameter("lastName")!= null && lastName.isEmpty() || 
                request.getParameter("phoneNumber")!= null && phoneNumber.isEmpty()||
                request.getParameter("street")!= null && street.isEmpty() || 
                request.getParameter("zipCode")!= null && zipCode.isEmpty() ||
                request.getParameter("city")!= null && city.isEmpty()|| 
                request.getParameter("country")!= null && country.isEmpty() || 
                request.getParameter("creditCardNumber")!= null && creditCardNumber.isEmpty()) {
            request.setAttribute("user", user);
            request.setAttribute("error", "All fields must be completed");
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        } else {

            //call bean DB transaction
            if (signUpBean.addNewUser(user)) {
                //if transaction with db success
                //send welcome email with login details
                emailBean.signUpWelcomeEmail(email, firstName, userName);
                // redirect to index page
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("user", user);
                request.setAttribute("error", "An error occured");
                request.getRequestDispatcher("signUp.jsp").forward(request, response);
            }
        }
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
