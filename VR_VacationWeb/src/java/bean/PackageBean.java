package bean;

import hibernate.DBHelper;
import hibernate.Package;
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
        DBHelper dbHelper = new DBHelper();
        
        return dbHelper.findAllPackages();
    }

    //get package with ID from hibernateDB service
    public Package getPackageWithID(int packageID) {
        DBHelper dbHelper = new DBHelper();
        
        return dbHelper.findPackageById(packageID);
    }
}
