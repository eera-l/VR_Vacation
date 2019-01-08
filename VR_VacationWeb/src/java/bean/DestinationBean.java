package bean;

import java.util.List;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author Felicity
 */
@Stateless
public class DestinationBean {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //get list of all detinations from hibernate db service
    //preferably Destination object with an id
    public List<Package> getAllDestinations(String destinationName) {
        return null;
    }

    //get destinations by ID from hibernate db service
    //preferably Destinations table object
    public Package getDestinationByID() {
        return null;
    }
}
