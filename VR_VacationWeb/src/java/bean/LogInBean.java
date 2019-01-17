package bean;

import global.DataStorage;
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
            setUser(email);
        }
        return loggedIn;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    private void setUser(String email) {
        DataStorage.getInstance().setUser(db.findUserByEmail(email));
    }
}
