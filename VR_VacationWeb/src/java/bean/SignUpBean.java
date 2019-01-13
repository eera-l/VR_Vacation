package bean;

import hibernate.DBHelper;
import hibernate.User;
import javax.ejb.Stateless;

/**
 *
 * @author Felicity
 */
@Stateless
public class SignUpBean {

    DBHelper db = null;
    
    //check db User table to see if user already exists
    public boolean checkIfUserExists(String email) {
        db = new DBHelper();
        return db.checkIfUserExists(email);
    }

    //add new user to db
    public boolean addNewUser(User user) {
        db = new DBHelper();
        return db.createUser(user);
    }
}
