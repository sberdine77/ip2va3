package br.ufrpe.ip2.va3.questao3.model;

public class PriceAlert extends RepositoryItem {
    private User user;
    private Product product;
    private double price;

    public PriceAlert(User user, Product product, double price, String id) {
        super(id);
        this.user = user;
        this.product = product;
        this.price = price;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object item) {
        if(item instanceof PriceAlert) {
            PriceAlert castedPriceAlert = (PriceAlert) item;
            return this.getId().equals(castedPriceAlert.getId());
        } else {
            return false;
        }
    }

}
