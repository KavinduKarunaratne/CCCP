package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<BillItem> items;
    private double discount;
    private double tax;

    private int cash;
    private int change;

    private Bill() {
        items = new ArrayList<>();
    }

    public List<BillItem> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public int getCash() {
        return cash;
    }

    public int getChange() {
        return change;
    }

    public double getTotal() {
        double subtotal = items.stream().mapToDouble(BillItem::getTotal).sum();
        double discountAmount = subtotal * (discount / 100);
        double taxAmount = (subtotal - discountAmount) * (tax / 100);
        return subtotal - discountAmount + taxAmount;
    }

    public static class Builder {
        private Bill bill;

        public Builder() {
            bill = new Bill();
        }

        public Builder addItem(int id, String code, String name, int quantity, int price) {
            bill.items.add(new BillItem(id, code, name, quantity, price));
            return this;
        }

        public Builder setDiscount(double discount) {
            bill.discount = discount;
            return this;
        }

        public Builder setTax(double tax) {
            bill.tax = tax;
            return this;
        }

        public Builder setCash(int cash) {
            bill.cash = cash;
            return this;
        }

        public Builder setChange(int change) {
            bill.change = change;
            return this;
        }

        public Bill build() {
            return bill;
        }
    }
}

