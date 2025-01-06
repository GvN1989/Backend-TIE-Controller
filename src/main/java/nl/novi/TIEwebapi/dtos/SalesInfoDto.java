package nl.novi.TIEwebapi.dtos;

public class SalesInfoDto {

    private Long id;
    private String brand;
    private String name;
    private Double price;
    private Integer originalStock;
    private Integer sold;

    public SalesInfoDto(Long id, String brand, String name, Double price, Integer originalStock, Integer sold) {
        this.id = id;
        this.brand= brand;
        this.name= name;
        this.price = price;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    public Long getId() {
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

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
