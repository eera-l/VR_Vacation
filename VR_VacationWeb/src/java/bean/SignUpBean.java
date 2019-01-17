package bean;

import global.DataStorage;
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

    public SignUpBean() {
        db = new DBHelper();
    }       
    
    //check db User table to see if user already exists
    public boolean checkIfUserExists(String email) {       
        return db.checkIfUserExists(email);
    }

    //add new user to db
    public boolean addNewUser(User user) {      
        DataStorage.getInstance().setUser(user);
        return db.createUser(user);
    }
}
