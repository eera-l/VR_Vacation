/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import hibernate.Experience;
import java.math.BigDecimal;
import java.util.ArrayList;
import hibernate.Package;
import java.util.Arrays;

/**
 *
 * @author Federica
 */
public class ShoppingCart {
    
    ArrayList<Package> packages = new ArrayList<>();
    ArrayList<Experience> experiences = new ArrayList<>();
    
    
    
     public ArrayList<Package> getPackages() {
        return packages;
     }   
     
    public void addPackage(Package... packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
    }
    
     public void addExperience(Experience... experiences) {
        this.experiences.addAll(Arrays.asList(experiences));
    }
    
    public Package returnRightPackage(int packId) {
        
        Package pack = null;
        
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).getPackageId() == packId) {
                pack = packages.get(i);
                break;
            }
        }
        
        return pack;
    }
    
    public Experience returnRightExperience(int expId) {
        
        Experience exp = null;
        
        for (int i = 0; i < experiences.size(); i++) {
            if (experiences.get(i).getExperienceId() == expId) {
                exp = experiences.get(i);
                break;
            }
        }
        
        return exp;
    }
    
      public boolean removePackage(Package pack) {
        
        if (packages.size() > 0 && packages.contains(pack)) {
            packages.remove(pack);
            return true;
        } else {
            return false;
        }
    }
      
      public boolean removeExperience(Experience exp) {

        if (experiences.size() > 0 && experiences.contains(exp)) {
            experiences.remove(exp);
            return true;
        } else {
            return false;
        }
    }
      
      public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        if (packages.size() > 0) {
            for (Package p : packages) {
                total = total.add(p.getPrice());
            }
        }
        
        if (experiences.size() > 0) {
            for (Experience exp : experiences) {
                total = total.add(exp.getPrice());
            }
        }
        
        return total;
    }
      
      
}
