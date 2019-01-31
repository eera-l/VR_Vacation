/*
 * UserBean.java
 * Handles retrieving of user's personal information,
 * plus logging out and checking if the user is logged in
 * functionalities.
 */
package bean;

import global.DataStorage;
import hibernate.DBHelper;
import hibernate.Order;
import hibernate.Package;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class UserBean {

   
    public boolean checkIfUserLoggedIn() {

        if (DataStorage.getInstance().getUser() != null) {
            return true;
        }
        return false;
    }

    public void logOut() {
        DataStorage.getInstance().setUser(null);
        DataStorage.getInstance().setShoppingCart(null);
    }

    public String getUserName() {

        if (DataStorage.getInstance().getUser() != null) {
            return DataStorage.getInstance().getUser().getUsername();
        }

        return "";
    }

    public String getFirstName() {

        if (DataStorage.getInstance().getUser() != null) {
            return DataStorage.getInstance().getUser().getFirstName();
        }

        return "";
    }

    public String getLastName() {

        if (DataStorage.getInstance().getUser() != null) {
            return DataStorage.getInstance().getUser().getLastName();
        }

        return "";
    }

    public String getEmail() {

        if (DataStorage.getInstance().getUser() != null) {
            return DataStorage.getInstance().getUser().getEmailAddress();
        }

        return "";
    }

    public List<Order> returnUserOrders() {
        List<Order> orders;

        DBHelper dbHelper = new DBHelper();

        orders = dbHelper.findOrdersByUserEmail(DataStorage.getInstance().getUser().getEmailAddress());

        return orders;
    }

    public List<Package> returnOrderPackages(Order order) {
        List<Package> packages;

        DBHelper dbHelper = new DBHelper();

        packages = dbHelper.findPackagesByOrder(order.getOrderId());

        return packages;
    }

}
