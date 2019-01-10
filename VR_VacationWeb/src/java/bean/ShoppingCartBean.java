package bean;

import java.util.ArrayList;
import javax.ejb.Stateful;
import hibernate.Package;
import hibernate.Order;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Federica
 */
@Stateful
public class ShoppingCartBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    ArrayList<Package> packages = new ArrayList<>();
    Order order;

    public void addItems(Package... packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
    }

    public boolean removeItems(Package pack) {
        
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
                total.add(p.getPrice());
            }
        }
        
        return total;
    }

    public void checkOut() {
        order = new Order(null, getTotal(), new Date(), true);
    }
    
   
}
