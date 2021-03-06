package hibernate;
// Generated 13-Jan-2019 15:00:45 by Hibernate Tools 4.3.1

import java.math.BigDecimal;



import java.math.BigDecimal;

/**
 * Experience generated by hbm2java
 */
public class Experience  implements java.io.Serializable {


     private int experienceId;
     private Destination destination;
     private Package pack;
     private Order order;
     private String name;
     private boolean isExtra;
     private String description;
     private BigDecimal price;
     private String imagePath;

    public Experience() {
    }

	
    public Experience(int experienceId, Destination destination, String name, boolean isExtra, String description, BigDecimal price) {
        this.experienceId = experienceId;
        this.destination = destination;
        this.name = name;
        this.isExtra = isExtra;
        this.description = description;
        this.price = price;
    }
    public Experience(int experienceId, Destination destination, Package pack, Order order, String name, boolean isExtra, String description, BigDecimal price, String imagePath) {
       this.experienceId = experienceId;
       this.destination = destination;
       this.pack = pack;
       this.order = order;
       this.name = name;
       this.isExtra = isExtra;
       this.description = description;
       this.price = price;
       this.imagePath = imagePath;
    }
   
    public int getExperienceId() {
        return this.experienceId;
    }
    
    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }
    public Destination getDestination() {
        return this.destination;
    }
    
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    public Package getPackage() {
        return this.pack;
    }
    
    public void setPackage(Package pack) {
        this.pack = pack;
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
    public boolean isIsExtra() {
        return this.isExtra;
    }
    
    public void setIsExtra(boolean isExtra) {
        this.isExtra = isExtra;
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




}

