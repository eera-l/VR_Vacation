/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
