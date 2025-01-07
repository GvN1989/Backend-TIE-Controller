package nl.novi.TIEwebapi.dtos;

import java.util.Set;

public class WallBracketDto {

    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
    private Set<Long> televisionIds;

    public Set<Long> getTelevisionIds() {
        return televisionIds;
    }

    public void setTelevisionIds(Set<Long> televisionIds) {
        this.televisionIds = televisionIds;
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
