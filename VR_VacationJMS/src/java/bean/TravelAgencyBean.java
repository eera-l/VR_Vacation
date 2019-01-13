/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
