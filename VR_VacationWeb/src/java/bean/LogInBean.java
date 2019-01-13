package bean;

import hibernate.DBHelper;
import javax.ejb.Stateful;

/**
 *
 * @author Felicity
 */
@Stateful
public class LogInBean {
    
    DBHelper db = null;
    boolean loggedIn = false;

    public boolean authenticateUser(String email, String password) {
        db = new DBHelper();
        if(db.checkLogIn(email, password)){
            loggedIn = true;
        }
        return loggedIn;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }
}
