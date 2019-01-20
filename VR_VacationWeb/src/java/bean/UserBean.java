/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import global.DataStorage;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class UserBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   public boolean checkIfUserLoggedIn() {
       
       if (DataStorage.getInstance().getUser() != null) {
           return true;
       }       
       return false;
   }
   
   public String getUserName() {
       
       if (DataStorage.getInstance().getUser() != null) {
           return DataStorage.getInstance().getUser().getUsername();
       }
       
       return "";
   }
   
   
    
    
}
