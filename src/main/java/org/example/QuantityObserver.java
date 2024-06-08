package org.example;

class QuantityObserver implements StockObserver {
    private Stock stock;

    public QuantityObserver(Stock stock) {
        this.stock = stock;
        this.stock.attach(this);
    }

    @Override
    public void update() {
        if (stock.getQuantity() < 50) {
            System.out.println("Stock quantity is below 50! Current quantity: " + stock.getQuantity());
        }
    }
}

