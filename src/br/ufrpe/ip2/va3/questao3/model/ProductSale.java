package br.ufrpe.ip2.va3.questao3.model;

import java.time.LocalDate;

public class ProductSale extends RepositoryItem {
    private Product product;
    private Store store;
    private LocalDate date;
    private double price;

    public ProductSale(Product product, Store store, LocalDate date, double price, String id) {
        super(id);
        this.product = product;
        this.store = store;
        this.date = date;
        this.price = price;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object item) {
        if(item instanceof ProductSale) {
            ProductSale castedProductSale = (ProductSale) item;
            return this.getId().equals(castedProductSale.getId());
        } else {
            return false;
        }
    }

}
