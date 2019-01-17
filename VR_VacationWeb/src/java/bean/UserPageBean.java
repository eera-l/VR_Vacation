/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Order> findOrders() {
        List<Order> orders;
        
        orders = db.findOrdersByUserEmail(DataStorage.getInstance().getUser().getEmailAddress());
        return orders;
    }
}
