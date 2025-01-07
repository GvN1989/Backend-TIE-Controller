package nl.novi.TIEwebapi.models;

import jakarta.persistence.*;

import javax.swing.text.StyledEditorKit;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name= "wallbrackets")

public class WallBracket {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    @ManyToMany(mappedBy = "wallBrackets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Television> televisions = new HashSet<>();

    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
