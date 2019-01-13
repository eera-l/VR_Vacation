package servlet;

import bean.EmailBean;
import bean.ShoppingCartBean;
import bean.SignUpBean;
import hibernate.User;
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
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @EJB
    private EmailBean emailBean;

    @EJB
    private SignUpBean signUpBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");

        ShoppingCartBean scb = new ShoppingCartBean();
        scb.sendJMSMessageToVrQueue(email);
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
        String ccNumber = request.getParameter("ccNumber");

        //create new user
        User user = new User(email, userName, password, firstName, lastName,
                phoneNumber, street, zipCode, city, country, ccNumber
        );

        //if user doesnt already exists
        if (signUpBean.checkIfUserExists(email)) {
            request.setAttribute("user", user);
            request.setAttribute("error", "User already exists");
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }

        //IF error in form 
        //error message all feilds are required
        if (email.isEmpty() || userName.isEmpty() || password.isEmpty()
                || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()
                || street.isEmpty() || zipCode.isEmpty() || city.isEmpty()
                || country.isEmpty()) {
            request.setAttribute("user", user);
            request.setAttribute("error", "all fields must be completed");
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
                request.setAttribute("error", "an error occured");
                request.getRequestDispatcher("signUp.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
