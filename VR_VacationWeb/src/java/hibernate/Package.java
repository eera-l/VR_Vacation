package hibernate;
// Generated 5-gen-2019 19.39.33 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * Package generated by hbm2java
 */
@Entity
@Table(name = "package", catalog = "vr_vacation", uniqueConstraints = {
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "description"),
                @UniqueConstraint(columnNames = "destination"),
                @UniqueConstraint(columnNames = "price")})
public class Package  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String description;
     private String destination;
     private BigDecimal price;
     private Set<Extra> extras = new HashSet<Extra>(0);
     private Set<Order> orders = new HashSet<Order>(0);

    public Package() {
    }

	
    public Package(String name, String description, String destination, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.destination = destination;
        this.price = price;
    }
    public Package(String name, String description, String destination, BigDecimal price, Set<Extra> extras, Set<Order> orders) {
       this.name = name;
       this.description = description;
       this.destination = destination;
       this.price = price;
       this.extras = extras;
       this.orders = orders;
    }
   
    @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public String getDestination() {
        return this.destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Set<Extra> getExtras() {
        return this.extras;
    }
    
    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "packages")
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }




}


