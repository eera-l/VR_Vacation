package bean;

import global.DataStorage;
import global.ShoppingCart;
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

    public boolean authenticateUser(String username, String password) {
        db = new DBHelper();
        if(db.checkLogIn(username, password)){
            loggedIn = true;
            setUser(username);
        }
        return loggedIn;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }
    

    private void setUser(String username) {
        ataStorage.getInstance().setUser(db.findUserByUserName(username));
        DataStorage.getInstance().setShoppingCart(new ShoppingCart());
    }
}
