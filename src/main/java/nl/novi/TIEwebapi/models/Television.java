package nl.novi.TIEwebapi.models;

public class Television {

    private int id;
    private String television;
    private String brand;
    private String model;
    private int screenSize;
    private boolean smartTv;



    public Television (int id, String television, String brand, String model, int screenSize, boolean smartTv){
        this.id = id;
        this.television= television;
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.smartTv = smartTv;
    }

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
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
