/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
}
