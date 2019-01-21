package bean;

import global.DataStorage;
import hibernate.DBHelper;
import hibernate.Experience;
import java.util.ArrayList;
import javax.ejb.Stateful;
import hibernate.Package;
import hibernate.Order;
import hibernate.User;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
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
    ArrayList<Package> packages = new ArrayList<>();
    ArrayList<Experience> experiences = new ArrayList<>();
    Order order;
    User user;
    Timer timer;

    public ShoppingCartBean() {
        user = DataStorage.getInstance().getUser();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Your database code here
                System.out.println("Timer expired!");
            }
        }, 5 * 1000);
        timer.cancel();
    }

    public void addPackages(Package... packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
    }

    public boolean removePackage(Package pack) {

        if (packages.size() > 0 && packages.contains(pack)) {
            packages.remove(pack);
            return true;
        } else {
            return false;
        }
    }

    public void addExperience(Experience... experiences) {
        this.experiences.addAll(Arrays.asList(experiences));
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
                total.add(p.getPrice());
            }
        }

        return total;
    }

    public String checkOut() {

        BankAppBean baBean = new BankAppBean();

        if (baBean.contactBank(user.getCreditCardNumber())) {
            order = new Order(user, getTotal(), new Date(), true);
            order.setPackages((Set<Package>) packages);
            DBHelper dbHelper = new DBHelper();
            for (int i = 0; i < packages.size(); i++) {
                dbHelper.assignOrderToPackage(packages.get(i), order);
            }
            dbHelper.createOrder(order);

            String message = "Order nr. " + order.getOrderId() + "completed successfully by " + user.getFirstName() + " " + user.getLastName();
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
        for (int i = 0; i < packages.size(); i++) {
            body += (i + 1) + " - " + packages.get(i).getName() + "\r\n";
        }

        body += "The total of your order is " + order.getPrice() + " SEK.";
        body += "Thank you for your purchase and we hope you enjoy your virtual vacation!";

        String subject = "Confirmation for order nr. " + order.getOrderId();

        eBean.sendEmail(user.getEmailAddress(), subject, body);
    }

    public void sendJMSMessageToVrQueue(String message) {

        try {
            Context ctx = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/vrQueueConnectionFactory");
            Queue queue = (Queue) ctx.lookup("jms/vrQueue");

            javax.jms.Connection connection = connectionFactory.createConnection();
            javax.jms.Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage JMSmessage = session.createTextMessage();
            JMSmessage.setText(message);
            System.out.println("***** Shopping Bean: Sent the message to vrQueue:" + JMSmessage.getText());
            messageProducer.send(JMSmessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
