/*
 * Contacts the Bank Web Service to verify
 * whether the customer's credit card number is
 * approved for the purchase
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class BankAppBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public boolean contactBank(String ccNumber) {
        ws.BankWS_Service bankService = new ws.BankWS_Service();
        ws.BankWS port = bankService.getBankWSPort();
        
        if (port.checkFunds(ccNumber)) {
            return true;
        } else {
            return false;
        }
    }
}
