/*
 * ChatBotBean.java
 * Handles communication between Chatbot logic class
 * and GUI classes.
 */
package bean;

import chatbot.Chatbot;
import javax.ejb.Stateful;

/**
 *
 * @author Federica
 */
@Stateful
public class ChatBotBean {
    
    public String processUserQuery(String query) {
        
        Chatbot cb = new Chatbot();
        cb.readAllLines();
        
        return cb.answer(query);
    }
}
