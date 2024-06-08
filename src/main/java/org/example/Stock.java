package org.example;

import java.util.ArrayList;
import java.util.List;

class Stock {
    private List<StockObserver> observers = new ArrayList<>();
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyAllObservers();
    }

    public void attach(StockObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (StockObserver observer : observers) {
            observer.update();
        }
    }
}

