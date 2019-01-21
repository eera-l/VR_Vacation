/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.math.BigDecimal;
import java.util.ArrayList;
import hibernate.Package;

/**
 *
 * @author Federica
 */
public class ShoppingCart {
    
    ArrayList<Package> packages = new ArrayList<>();
    
    
     public ArrayList<Package> getPackages() {
        return packages;
     }   
     
    public void addItems(Package... packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
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
    
      public boolean removeItem(Package pack) {
        
        if (packages.size() > 0 && packages.contains(pack)) {
            packages.remove(pack);
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
        
        return total;
    }
      
      
}
