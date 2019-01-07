/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
/**
 *
 * @author Federica
 */
public class HBHelper {
    
    Session session = null;
    
    public HBHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public User findUserByEmail(String email) {
        User user = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from User as user where user.emailAddress = '" + email +
                    "'");
            user = (User)q.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public List<Order> findOrdersByUserEmail(String email) {
        List<Order> orders = null;
        
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Order as ord where ord.user.emailAddress = '" +
                    email + "'");
            
            orders = (List<Order>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return orders;
    }
    
    public List<Package> findAllPackages() {
        
        List<Package> packages = null;
        
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package");
            
            packages = (List<Package>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return packages;
    }
    
    public List<Package> findPackagesBtOrder(int orderId) {
        List<Package> packages = null;
        
        try {
            session.beginTransaction();
            Query q = session.createQuery("select packages from Order as ord where ord.orderId = " 
            + orderId);
            
            packages = (List<Package>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return packages;
    }
    
}
