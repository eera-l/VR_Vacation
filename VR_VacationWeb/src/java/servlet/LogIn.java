package servlet;

import bean.LogInBean;
import java.io.IOException;
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
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

    LogInBean logInBean = lookupLogInBeanBean();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
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
        //get form data
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //call bean to verify password
        //if bad credentials - error message
        //TO:DO placeholder logic
        if (password.isEmpty()) {
            if (!userName.isEmpty()) {
                request.setAttribute("username", userName);
            }
            request.setAttribute("error", "*username or password incorrect");
            request.getRequestDispatcher("logIn.jsp").forward(request, response);
        } else {
            //redirect to home page
            //TO:DO add username feild to menu - diasble logIn signUp buttons
            request.setAttribute("userName", userName);
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

    private LogInBean lookupLogInBeanBean() {
        try {
            Context c = new InitialContext();
            return (LogInBean) c.lookup("java:global/VR_VacationWeb/LogInBean!bean.LogInBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
