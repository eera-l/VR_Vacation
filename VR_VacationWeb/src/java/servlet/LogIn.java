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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //load page
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //call bean to verify password
        //if bad credentials - error message
        if (password.isEmpty()) {
            if (!username.isEmpty()) {
                request.setAttribute("username", username);
            }
            request.setAttribute("error", "*username and password must be entered");
            request.getRequestDispatcher("logIn.jsp").forward(request, response);
        } else {
            if (logInBean.authenticateUser(username, password)) {
                //redirect to home page
                //TO:DO add username feild to menu - diasble logIn signUp buttons
                request.setAttribute("userName", username);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "*username or password incorrect");
                request.getRequestDispatcher("logIn.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

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
