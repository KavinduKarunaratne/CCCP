package org.example;

public class ItemDTO {
    private int id;
    private int code;
    private String name;
    private int quantity;
    private String purchaseDate;
    private String expiryDate;

    public ItemDTO(int id, int code, String name, int quantity, String purchaseDate, String expiryDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
        return "Item{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
