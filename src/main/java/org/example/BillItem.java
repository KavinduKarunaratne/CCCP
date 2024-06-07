package org.example;

public class BillItem {
    private int id;
    private String code;
    private String name;
    private int quantity;
    private int price;

    public BillItem(int id, String code, String name, int quantity, int price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return quantity * price;
    }
}

