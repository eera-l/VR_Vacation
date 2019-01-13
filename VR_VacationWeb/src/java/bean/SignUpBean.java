package bean;

import hibernate.DBHelper;
import javax.ejb.Stateless;

/**
 *
 * @author Felicity
 */
@Stateless
public class SignUpBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //check db User table to see if user already exists
    public boolean checkIfUserExists(String email) {
        DBHelper dbhelper = new DBHelper();
        
        return dbhelper.checkIfUserExists(email);
    }

    //add new user to db
    public boolean addNewUser() {
        return false;
    }
}
