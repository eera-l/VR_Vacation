/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author felic
 */
public class DBHelper {
      Session session = null;

    public DBHelper() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
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
}
