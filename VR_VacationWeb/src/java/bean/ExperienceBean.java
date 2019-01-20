/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private DBHelper db;
    
    public ExperienceBean() {
        db = new DBHelper();
    }
    
    private List<Experience> getExperiences(Package pack) {
        List<Experience> exps;
        
        int pack_id = pack.getPackageId();        
        exps = db.findExpByPackage(pack_id);
        
        return exps;
    }    
    
}
