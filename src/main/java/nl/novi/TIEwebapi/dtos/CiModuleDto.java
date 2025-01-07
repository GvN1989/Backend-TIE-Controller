package nl.novi.TIEwebapi.dtos;

import java.util.List;

public class CiModuleDto {
    private Long Id;
    private String name;
    private String type;
    private Double price;
    private List<Long> televisionsIds;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Long> getTelevisionsIds() {
        return televisionsIds;
    }

    public void setTelevisionsIds(List<Long> televisionsIds) {
        this.televisionsIds = televisionsIds;
    }
}
