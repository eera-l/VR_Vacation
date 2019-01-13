package servlet;

import bean.PackageBean;
import java.io.IOException;
import javax.ejb.EJB;
import hibernate.Package;
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
    private PackageBean packageBean;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
        Integer id = Integer.valueOf(request.getParameter("packageId"));
        Package aPackage = packageBean.getPackageWithID(id);
        request.setAttribute("package", aPackage );
        request.getRequestDispatcher("/id_package.jsp").forward(request, response);
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

}
