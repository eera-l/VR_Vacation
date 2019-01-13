package servlet;

import bean.ShoppingCartBean;
import bean.SignUpBean;
import hibernate.Main;
import hibernate.User;
import java.io.IOException;
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

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        
        ShoppingCartBean scb = new ShoppingCartBean();
        scb.sendJMSMessageToVrQueue(email);
        
        
        /*SignUpBean su = new SignUpBean();
        
        if (su.checkIfUserExists(email)) {
            System.out.println("User exists");
        } else {
            System.out.println("User doesn't exist");
        }*/
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
        //load page
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
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

        //TO:DO
        //if user doesnt already exists
        
        //create new user
        User user = new User(email, userName, password, firstName, lastName,
                phoneNumber, street, zipCode, city, country, ccNumber
        );

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
            
            
            //if transaction with db success
            // redirect to index page?
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
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
