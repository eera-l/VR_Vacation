package bean;

import global.DataStorage;
import global.ShoppingCart;
import hibernate.DBHelper;
import java.util.ArrayList;
import javax.ejb.Stateful;
import hibernate.Package;
import hibernate.Order;
import hibernate.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Federica
 */
@Stateful
public class ShoppingCartBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    Order order;
    User user;
    Timer timer;
    ShoppingCart shoppingCart;
    
    @PostConstruct
    private void init() {
       user = DataStorage.getInstance().getUser();
       //shoppingCart = new ShoppingCart();
       shoppingCart = DataStorage.getInstance().getShoppingCart();
    }
    
    public ShoppingCartBean() {
       user = DataStorage.getInstance().getUser();
       shoppingCart = DataStorage.getInstance().getShoppingCart();
       
       /*timer = new Timer();
       timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Your database code here
                System.out.println("Timer expired!");
            }
        }, 5*1000);
       timer.cancel();*/
    }      

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
  

    public void addItems(Package... packages) {
        shoppingCart.addItems(packages);
    }
    
    

    public boolean removeItem(int packId) {
        
        Package pack = shoppingCart.returnRightPackage(packId);
        
       return shoppingCart.removeItem(pack);
    }

    public BigDecimal getTotal() {
       
        return shoppingCart.getTotal();
    }

    public String checkOut() {
        
        BankAppBean baBean = new BankAppBean();
        
        user = DataStorage.getInstance().getUser();
        
        if (user != null && baBean.contactBank(user.getCreditCardNumber())) {
            order = new Order(user, getTotal(), new Date(), true);
            order.setPackages(new HashSet<Package>(shoppingCart.getPackages()));
            DBHelper dbHelper = new DBHelper();
            dbHelper.createOrder(order);
            for (int i = 0; i < shoppingCart.getPackages().size(); i++) {
                dbHelper.assignOrderToPackage(shoppingCart.getPackages().get(i), order);
            }
            
            
            String message = "Order nr. " + order.getOrderId() + " completed successfully by " + user.getFirstName() + " " + user.getLastName();
            sendJMSMessageToVrQueue(message);
            return message;
        } else {
            return "Bank operation not approved. The order has been cancelled.";
        }
    }
    
    public void sendEmailConfirmationToUser() {
        EmailBean eBean = new EmailBean();
        
        String body = "Thank you for your order on VR Vacation!\r\n";
        body += "You have ordered the following items:\r\n";
        for (int i = 0; i < shoppingCart.getPackages().size(); i++) {
           body += (i + 1) + " - " + shoppingCart.getPackages().get(i).getName() + "\r\n";
        }
        
        body += "The total of your order is " + order.getPrice() + " SEK.";
        body += "Thank you for your purchase and we hope you enjoy your virtual vacation!";
        
        String subject = "Confirmation for order nr. " + order.getOrderId();       
        
        eBean.sendEmail(user.getEmailAddress(), subject, body);
    }

    public void sendJMSMessageToVrQueue(String message) {
        
        try{
            Context ctx = new InitialContext();           
            ConnectionFactory     connectionFactory = (ConnectionFactory)ctx.lookup("jms/vrQueueConnectionFactory");
            Queue     queue = (Queue)ctx.lookup("jms/vrQueue");            
            
            javax.jms.Connection  connection = connectionFactory.createConnection();
            javax.jms.Session        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage JMSmessage = session.createTextMessage();
            JMSmessage.setText(message);
            System.out.println( "***** Shopping Bean: Sent the message to vrQueue:"+ JMSmessage.getText());
            messageProducer.send(JMSmessage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
       
    }

    
   
}
