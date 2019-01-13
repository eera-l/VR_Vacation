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

    DBHelper db = null;
    
    
    //get all packages from hibernateDB service
    public List<Package> getAllPackages() {
        db = new DBHelper();
        return db.findAllPackages();
    }

    //get package with ID from hibernateDB service
    public Package getPackageWithID(int packageID) {
        db = new DBHelper();
        return db.findPackageById(packageID);
    }
}
