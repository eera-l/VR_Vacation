/*
 * TravelAgencyBean.java
 * Funct.: Message-driven bean which listens to messages arriving
 * in the VRQueue
 */
package bean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Federica
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/vrQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TravelAgencyBean implements MessageListener {
    
    public TravelAgencyBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
         TextMessage msg = null;
        String smessage="";
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                smessage = msg.getText();
                System.out.println("Message received from Travel Agency. User's email: " + smessage); 
            } else {
               System.err.println("Error with receiving message by Travel Agency: " +  message.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }  
    }
    
}
