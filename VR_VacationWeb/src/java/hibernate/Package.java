package hibernate;
// Generated 13-Jan-2019 15:00:45 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Package generated by hbm2java
 */
public class Package  implements java.io.Serializable {


     private Integer packageId;
     private Destination destination;
     private Order order;
     private String name;
     private String description;
     private BigDecimal price;
     private String imagePath;
     private Set<Experience> experiences = new HashSet<Experience>(0);

    public Package() {
    }

	
    public Package(Destination destination, String name, String description, BigDecimal price) {
        this.destination = destination;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Package(Destination destination, Order order, String name, String description, BigDecimal price, String imagePath, Set<Experience> experiences) {
       this.destination = destination;
       this.order = order;
       this.name = name;
       this.description = description;
       this.price = price;
       this.imagePath = imagePath;
       this.experiences = experiences;
    }
   
    public Integer getPackageId() {
        return this.packageId;
    }
    
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }
    public Destination getDestination() {
        return this.destination;
    }
    
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getImagePath() {
        return this.imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public Set<Experience> getExperiences() {
        return this.experiences;
    }
    
    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }




}


