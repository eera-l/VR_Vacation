/*
 * ExperienceBean.java
 * Handles retrieving of experiences from a given Package.
 */
package bean;

import hibernate.DBHelper;
import hibernate.Experience;
import hibernate.Package;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Federica
 */
@Stateless
public class ExperienceBean {

   
    private DBHelper db;

    public ExperienceBean() {
        db = new DBHelper();
    }

    public List<Experience> getExperiences(Package pack) {
        List<Experience> exps;

        int pack_id = pack.getPackageId();
        exps = db.findExpByPackage(pack_id);

        return exps;
    }

    public Experience getExperienceById(Integer id) {
        return db.findExperienceById(id);
    }

}
