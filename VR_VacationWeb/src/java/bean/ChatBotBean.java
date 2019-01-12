/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String processUserQuery(String query) {
        
        Chatbot cb = new Chatbot();
        cb.readAllLines();
        
        return cb.answer(query);
    }
}
