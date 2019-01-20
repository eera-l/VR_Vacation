package servlet;

import bean.ChatBotBean;
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
 * @author Federica
 */
@WebServlet(name = "ChatbotServlet", urlPatterns = {"/ChatbotServlet"})
public class ChatbotServlet extends HttpServlet {

    ChatBotBean chatBotBean = lookupChatBotBeanBean();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String answer = "error";
        
        String query = request.getParameter("query");
        if (request.getParameter("query") != null && !request.getParameter("query").equalsIgnoreCase("")) {
            answer = chatBotBean.processUserQuery(query);
            
            System.out.println(answer);
        }
        response.getWriter().write(answer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ChatBotBean lookupChatBotBeanBean() {
        try {
            Context c = new InitialContext();
            return (ChatBotBean) c.lookup("java:global/VR_VacationWeb/ChatBotBean!bean.ChatBotBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
