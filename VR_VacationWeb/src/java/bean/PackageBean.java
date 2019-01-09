package bean;

import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Felicity
 */
@Stateless
public class PackageBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //get all packages from hibernateDB service
    public List<Package> getAllPackages() {
        return null;
    }

    //get package with ID from hibernateDB service
    public Package getPackageWithID() {
        return null;
    }
}
