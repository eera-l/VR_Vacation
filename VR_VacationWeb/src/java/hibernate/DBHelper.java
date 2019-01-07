/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Session;

/**
 *
 * @author Federica
 */
public class DBHelper {
    
    Session session = null;

    public DBHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
}
