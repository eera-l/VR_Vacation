/*
 * DataStorage.java
 * Simple singleton for storing user's and shopping cart information
 * throughout the website transactions.
 */
package global;

import hibernate.User;

/**
 *
 * @author Federica
 */
public class DataStorage {
    
    private static DataStorage instance;
    private User user;
    private ShoppingCart shoppingCart;
    private boolean checkOut;
    
    
    private DataStorage() {}
    
    public static DataStorage getInstance() {
        
        if (instance == null) {
            instance = new DataStorage();
        }
        
        return instance;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
    
    
    
    
    
}
