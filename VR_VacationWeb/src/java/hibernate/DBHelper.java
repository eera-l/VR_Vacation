/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Federica
 */
@SuppressWarnings("CallToPrintStackTrace")
public class DBHelper {
    
    Session session = null;

    public DBHelper() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public User findUserByEmail(String email) {
        User user = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from User as user where user.emailAddress = '" + email +
                    "'");
            user = (User)q.uniqueResult();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        return user;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Order> findOrdersByUserEmail(String email) {
        List<Order> orders = null;

         session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Order as ord where ord.user.emailAddress = '" +
                    email + "'");

            orders = (List<Order>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return orders;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean checkIfUserExists(String email) {
        
        User user = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from User as user where user.emailAddress = '" + email +
                    "'");
            user = (User)q.uniqueResult();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean checkLogIn(String email, String password) {
        
        User user = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from User as user where user.emailAddress = '" + email +
                    "' and password = '" + password + "'");
            user = (User)q.uniqueResult();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
     public List<Package> findAllPackages() {

        List<Package> packages = null;

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package");

            packages = (List<Package>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return packages;
    }
     
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
     public Package findPackageById(int packageId) {
         Package pack = null;
         
         try {
             session.beginTransaction();
             Query q = session.createQuery("from Package as package where package.packageId = " + packageId);
             
             pack = (Package)q.uniqueResult();
             
            
         } catch (Exception ex) {
             ex.printStackTrace();
         }finally {
            session.close();
        }
         return pack;
     }
     
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Destination> findPackagesByOrder(int orderId) {
        
        List<Destination> dests = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package where package.order.orderId = " + orderId);

            dests = (List<Destination>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return dests;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Package> findPackagesByDestination(int destId) {
         List<Package> packages = null;
         session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Package as package where package.destination.destinationId = " + destId);

            packages = (List<Package>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return packages;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Destination> findAllDestinations() {

        List<Destination> dests = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Destination as destination");

            dests = (List<Destination>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return dests;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
     public Destination findDestinationById(int destId) {
         Destination dest = null;
         session = HibernateUtil.getSessionFactory().openSession();
         try {
             session.beginTransaction();
             Query q = session.createQuery("from Destination as dest where dest.destinationId = " + destId);
             
             dest = (Destination)q.uniqueResult();
             
            
         } catch (Exception ex) {
             ex.printStackTrace();
         }finally {
            session.close();
        }
         return dest;
     }
     
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
     public Experience findExperienceById(int expId) {
         Experience exp = null;
         session = HibernateUtil.getSessionFactory().openSession();
         try {
             session.beginTransaction();
             Query q = session.createQuery("from Experience as exp where exp.experienceId = " + expId);
             
             exp = (Experience)q.uniqueResult();
             
            
         } catch (Exception ex) {
             ex.printStackTrace();
         }finally {
            session.close();
        }
         return exp;
     }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Experience> findExpByDestination(int destId) {
        
        List<Experience> exps = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Experience as experience where experience.destination.destinationId = " + destId);

            exps = (List<Experience>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return exps;
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public List<Experience> findExpByPackage(int packageId) {
        
        List<Experience> exps = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Experience as experience where experience.package.packageId = " + packageId);

            exps = (List<Experience>)q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return exps;
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
     public Order findOrderById(int orderId) {
         Order order = null;
         session = HibernateUtil.getSessionFactory().openSession();
         try {
             session.beginTransaction();
             Query q = session.createQuery("from Order as ord where ord.orderId = " + orderId);
             
             order = (Order)q.uniqueResult();
             
            
         } catch (Exception ex) {
             ex.printStackTrace();
         }finally {
            session.close();
        }
         return order;
     }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean createUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(user);            
            session.getTransaction().commit();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean createUser(String emailAddress, String username, String password, String firstName, String lastName, String phoneNumber, String addressStreet, String addressZipCode, String addressCity, String addressCountry, String creditCardNumber) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        User user = new User(emailAddress, username, password, firstName, lastName, phoneNumber, addressStreet, addressZipCode, addressCity, addressCountry, creditCardNumber);
        try {
            session.beginTransaction();
            session.save(user);            
            session.getTransaction().commit();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean createOrder(Order order) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(order);            
            session.getTransaction().commit();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean createOrder(User user, BigDecimal price, Date date, boolean isPaid) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        Order order = new Order(user, price, date, isPaid);
        try {
            session.beginTransaction();
            session.save(order);            
            session.getTransaction().commit();
           
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }
      
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean assignOrderToPackage(Package pack, Order order) {
        boolean ok = false;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            pack.setOrder(order);
            session.beginTransaction();
            session.merge(pack);
            session.getTransaction().commit();
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return ok;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean assignOrderToPackage(int packId, int orderId) {
        boolean ok = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Package pack = findPackageById(packId);
        session = HibernateUtil.getSessionFactory().openSession();
       Order order = findOrderById(orderId);
       session = HibernateUtil.getSessionFactory().openSession();
        try {
            pack.setOrder(order);
            session.beginTransaction();
            session.merge(pack);
            session.getTransaction().commit();
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return ok;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean assignPackageToExperience(Package pack, Experience exp) {
        boolean ok = false;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            exp.setPackage(pack);
            session.beginTransaction();
            session.merge(exp);
            session.getTransaction().commit();
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return ok;
    }
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    //</editor-fold>
    public boolean assignPackageToExperience(int packId, int expId) {
        boolean ok = false;
        session = HibernateUtil.getSessionFactory().openSession();
        Package pack = findPackageById(packId);
        session = HibernateUtil.getSessionFactory().openSession();
        Experience exp = findExperienceById(expId);
       session = HibernateUtil.getSessionFactory().openSession();
        try {
            exp.setPackage(pack);
            session.beginTransaction();
            session.merge(exp);
            session.getTransaction().commit();
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        
        return ok;
    }
     
}
