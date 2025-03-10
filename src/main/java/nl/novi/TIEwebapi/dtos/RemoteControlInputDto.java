package nl.novi.TIEwebapi.dtos;

import nl.novi.TIEwebapi.models.RemoteControl;

public class RemoteControlInputDto {

    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public RemoteControl toRemoteControl(){

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setId(id);
        remoteControl.setCompatibleWith(compatibleWith);
        remoteControl.setBatteryType(batteryType);
        remoteControl.setName(name);
        remoteControl.setBrand(brand);
        remoteControl.setPrice(price);
        remoteControl.setOriginalStock(originalStock);

        return remoteControl;

    }

}
