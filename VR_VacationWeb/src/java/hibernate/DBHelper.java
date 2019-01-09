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
public class DBHelper {
    
    Session session = null;

    public DBHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public User findUserByEmail(String email) {
        User user = null;
        try {
            session.beginTransaction();
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
            session.beginTransaction();
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
     
     
    public List<Destination> findPackagesByOrder(int orderId) {
        
        List<Destination> dests = null;

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package where package.order.orderId = " + orderId);

            dests = (List<Destination>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dests;
    }
    
    public List<Package> findPackagesByDestination(int destId) {
         List<Package> packages = null;

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package where package.destination.destinationId = " + destId);

            packages = (List<Package>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return packages;
    }
    
    public List<Destination> findAllDestinations() {

        List<Destination> dests = null;

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Destination as destination");

            dests = (List<Destination>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dests;
    }
    
    public List<Experience> findExpByDestination(int destId) {
        
        List<Experience> exps = null;

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Experience as experience where experience.destination.destinationId = " + destId);

            exps = (List<Experience>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return exps;
        
    }
    
    public List<Experience> findExpByPackage(int packageId) {
        
        List<Experience> exps = null;

        try {
            session.beginTransaction();
            Query q = session.createQuery("from Experience as experience where experience.package.packageId = " + packageId);

            exps = (List<Experience>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return exps;
        
    }
    
    
}
