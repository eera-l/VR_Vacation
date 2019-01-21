/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   public boolean checkIfUserLoggedIn() {
       
       if (DataStorage.getInstance().getUser() != null) {
           return true;
       }       
       return false;
   }
   
   public String getUserName() {
       
       if (DataStorage.getInstance().getUser() != null) {
           return DataStorage.getInstance().getUser().getUsername();
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
