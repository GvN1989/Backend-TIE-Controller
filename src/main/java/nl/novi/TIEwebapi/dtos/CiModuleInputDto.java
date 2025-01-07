package nl.novi.TIEwebapi.dtos;

import nl.novi.TIEwebapi.models.CiModule;

public class CiModuleInputDto {
    private Long Id;
    private String name;
    private String type;
    private Double price;

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

    public CiModule toCIModule(){

        CiModule ciModule = new CiModule();

        ciModule.setId(Id);
        ciModule.setName(name);
        ciModule.setType(type);
        ciModule.setPrice(price);

        return ciModule;

    }

}
