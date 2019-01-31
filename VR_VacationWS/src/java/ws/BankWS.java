/*
 * BankWS.java
 * Funct.: Web service that checks whether the credit card number matches
 * the hard-coded ones and returns the result.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@WebService(serviceName = "BankWS")
@Stateless()
public class BankWS {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkFunds")
    public boolean checkFunds(@WebParam(name = "ccNumber") String ccNumber) {
        if (ccNumber.equals("1111222233334444") || ccNumber.equals("5555666677778888")) {
            return true;
        } else {
            return false;
        }
    }
}
