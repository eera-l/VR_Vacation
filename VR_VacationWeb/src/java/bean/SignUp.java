package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Felicity
 */
@Stateless
public class SignUp {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //check db User table to see if user already exists
    public boolean checkIfUserExists() {
        return false;
    }

    //add new user to db
    public boolean addNewUser() {
        return false;
    }
}
