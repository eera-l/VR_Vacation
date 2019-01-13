/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import hibernate.DBHelper;
import hibernate.Experience;
import java.util.ArrayList;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class ID_PackageBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    ArrayList<Experience> experiences = new ArrayList<>();
    hibernate.Package pack;
    
    public ID_PackageBean() {}
    
    public ID_PackageBean(hibernate.Package pack) {
        this.pack = pack;
    }
    
    public void addExperience(Experience exp) {
        experiences.add(exp);        
    }
    
    public boolean removeExperience(Experience exp) {
        
        if (experiences.size() > 0 && experiences.contains(exp)) {
            experiences.remove(exp);
            return true; 
        } 
        
        return false;
    }
    
    public void confirmAndAddToCart() {
        DBHelper dbHelper = new DBHelper();
        for (int i = 0; i < experiences.size(); i++) {
            dbHelper.assignPackageToExperience(pack, experiences.get(i));
        }
        
        pack.setExperiences((Set<Experience>) experiences);
    }
}
