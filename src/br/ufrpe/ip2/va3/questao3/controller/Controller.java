package br.ufrpe.ip2.va3.questao3.controller;

import br.ufrpe.ip2.va3.questao3.model.PriceAlert;
import br.ufrpe.ip2.va3.questao3.model.Product;
import br.ufrpe.ip2.va3.questao3.model.ProductSale;
import br.ufrpe.ip2.va3.questao3.model.Store;
import br.ufrpe.ip2.va3.questao3.model.User;
import br.ufrpe.ip2.va3.questao3.repository.GenericRepository;

public class Controller {
    private GenericRepository<User> users;
    private GenericRepository<Store> stores;
    private GenericRepository<Product> products;
    private GenericRepository<PriceAlert> priceAlerts;
    private GenericRepository<ProductSale> productSales;

    public void addUser(User user) throws Exception {
        users.addItem(user);
    }

    public void addStore(Store store) throws Exception {
        stores.addItem(store);
    }

    public void addProduct(Product product) throws Exception {
        products.addItem(product);
    }

    public void addPriceAlert(PriceAlert priceAlert) throws Exception {
        priceAlerts.addItem(priceAlert);
    }

    public void addProductSale(ProductSale productSale) throws Exception {
        productSales.addItem(productSale);
    }
}
