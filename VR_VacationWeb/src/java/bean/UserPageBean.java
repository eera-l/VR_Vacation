/*
 * UserPageBean.java
 * Returns a urser's orders.
 */
package bean;

import global.DataStorage;
import hibernate.DBHelper;
import hibernate.Order;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class UserPageBean {
    
    private DBHelper db;
    
    public UserPageBean() {
        db = new DBHelper();
    }
    
    public List<Order> findOrders() {
        List<Order> orders;
        
        orders = db.findOrdersByUserEmail(DataStorage.getInstance().getUser().getEmailAddress());
        return orders;
    }
}
