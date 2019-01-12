package bean;

import hibernate.DBHelper;
import java.util.ArrayList;
import javax.ejb.Stateful;
import hibernate.Package;
import hibernate.Order;
import hibernate.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Federica
 */
@Stateful
public class ShoppingCartBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    ArrayList<Package> packages = new ArrayList<>();
    User user;
    
    public ShoppingCartBean() {}
    
    public ShoppingCartBean(User user) {
        this.user = user;
    }

    public void addItems(Package... packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
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
                total.add(p.getPrice());
            }
        }
        
        return total;
    }

    public String checkOut() {
        
        BankAppBean baBean = new BankAppBean();
        
        if (baBean.contactBank(user.getCreditCardNumber())) {
            Order order = new Order(user, getTotal(), new Date(), true);
            order.setPackages((Set<Package>) packages);
            DBHelper dbHelper = new DBHelper();
            for (int i = 0; i < packages.size(); i++) {
                dbHelper.assignOrderToPackage(packages.get(i), order);
            }
            dbHelper.createOrder(order);
            return "Order completed successfully!";
        } else {
            return "Bank operation not approved. The order has been cancelled.";
        }
    }
    
    public void sendEmailConfirmationToUser() {
        EmailBean eBean = new EmailBean();
        
        
    }
    
   
}
