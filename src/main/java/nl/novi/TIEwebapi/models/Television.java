package nl.novi.TIEwebapi.models;

public class Television {

    private Long id;
    private String brand;
    private String model;
    private int screenSize;
    private boolean smartTv;

    public Television (Long id, String brand, String model, int screenSize, boolean smartTv){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.smartTv = smartTv;
    }

    public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    @Override
    public String toString(){
        return "Television{" +
                "id= " + id +
                ", brand=" + brand + '\'' +
                ", model=" + model + '\'' +
                ", screenSize=" + screenSize +
                ", smartTv=" + smartTv +
                '}';
    }

}
