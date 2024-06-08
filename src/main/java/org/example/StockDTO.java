package org.example;

public class StockDTO {
    private int id;
    private String code;
    private String name;
    private int quantity;
    private int price;
    private String purchaseDate;
    private String expiryDate;

    public StockDTO(int id, String code, String name, int quantity, int price, String purchaseDate, String expiryDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
