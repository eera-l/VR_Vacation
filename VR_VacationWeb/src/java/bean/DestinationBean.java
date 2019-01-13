package bean;

import hibernate.DBHelper;
import hibernate.Destination;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Felicity
 */
@Stateless
public class DestinationBean {
    DBHelper db = null;

    //get list of all detinations from hibernate db service
    //preferably Destination object with an id
    public List<Destination> getAllDestinations() {
        db = new DBHelper();
        return db.findAllDestinations();
    }

    //get destinations by ID from hibernate db service
    //preferably Destinations table object
    public Destination findDestinationByID(int id) {
        db = new DBHelper();
        return db.findDestinationById(id);
    }
}
