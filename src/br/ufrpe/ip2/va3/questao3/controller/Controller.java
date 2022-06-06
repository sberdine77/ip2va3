package br.ufrpe.ip2.va3.questao3.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.ufrpe.ip2.va3.questao3.model.PriceAlert;
import br.ufrpe.ip2.va3.questao3.model.Product;
import br.ufrpe.ip2.va3.questao3.model.ProductSale;
import br.ufrpe.ip2.va3.questao3.model.Store;
import br.ufrpe.ip2.va3.questao3.model.User;
import br.ufrpe.ip2.va3.questao3.repository.GenericRepository;

public class Controller {
    private GenericRepository<User> users = new GenericRepository<User>("users.dat");
    private GenericRepository<Store> stores = new GenericRepository<Store>("stores.dat");
    private GenericRepository<Product> products = new GenericRepository<Product>("products.dat");
    private GenericRepository<PriceAlert> priceAlerts = new GenericRepository<PriceAlert>("priceAlerts.dat");
    private GenericRepository<ProductSale> productSales = new GenericRepository<ProductSale>("productSales.dat");

    public List<ProductSale> listSalesOfProductOrderedByPriceOnDate (Product product, LocalDate currentDate) {
        ArrayList<ProductSale> sales = this.getProductSales();
        List<ProductSale> salesList = sales.stream().filter(s -> s.getProduct().equals(product) && s.getDate().equals(currentDate)).collect(Collectors.toList());
        Collections.sort(salesList, (s1, s2) -> {
            if(s1.getPrice() >= s2.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        });
        return salesList;
    }

    public List<ProductSale> listSalesOrderedByPriceOnDate (LocalDate currentDate) {
        ArrayList<ProductSale> sales = this.getProductSales();
        List<ProductSale> salesList = sales.stream().filter(s -> s.getDate().equals(currentDate)).collect(Collectors.toList());
        Collections.sort(salesList, (s1, s2) -> {
            if(s1.getPrice() >= s2.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        });
        return salesList;
    }

    public Map<LocalDate, List<ProductSale>> buildProductSalesHistoryOnTimePeriod(Product product, LocalDate startDate, LocalDate finalDate) {
        ArrayList<ProductSale> sales = this.getProductSales();
        List<ProductSale> salesList = sales.stream().filter(s -> s.getProduct().equals(product) && ((s.getDate().isAfter(startDate) && s.getDate().isBefore(finalDate)) || s.getDate().isEqual(startDate) || s.getDate().isEqual(finalDate))).collect(Collectors.toList());
        Collections.sort(salesList, (s1, s2) -> s1.getDate().compareTo(s2.getDate()));
        Map<LocalDate, List<ProductSale>> resultMap = new HashMap<LocalDate, List<ProductSale>>();
        for (ProductSale productSale : salesList) {
            resultMap.merge(productSale.getDate(), List.of(productSale), (oldList, newList) -> {
                oldList.addAll(newList);
                return oldList;
            });
        }
        return resultMap;
    }

    public List<PriceAlert> verifyMatchedPriceAlertForUser(User user) {
        List<PriceAlert> alertsForUser = this.getPriceAlerts().stream().filter(pA -> pA.getUser().equals(user)).collect(Collectors.toList());
        alertsForUser = alertsForUser.stream().filter(pA -> {
            List<ProductSale> salesForProduct = this.listSalesOfProductOrderedByPriceOnDate(pA.getProduct(), LocalDate.now());
            for (ProductSale sale : salesForProduct) {
                if(pA.getPrice() >= sale.getPrice()) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
        return alertsForUser;
    }

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

    public ArrayList<User> getUsers() {
        return users.getItems();
    }

    public ArrayList<Store> getStores() {
        return stores.getItems();
    }

    public ArrayList<Product> getProducts() {
        return products.getItems();
    }

    public ArrayList<PriceAlert> getPriceAlerts() {
        return priceAlerts.getItems();
    }

    public ArrayList<ProductSale> getProductSales() {
        return productSales.getItems();
    }

    public void removeUser(User user) throws Exception {
        users.removeItem(user);
    }

    public void removeStore(Store store) throws Exception {
        stores.removeItem(store);
    }

    public void removeProduct(Product product) throws Exception {
        products.removeItem(product);
    }

    public void removePriceAlert(PriceAlert priceAlert) throws Exception {
        priceAlerts.removeItem(priceAlert);
    }

    public void removeProductSale(ProductSale productSale) throws Exception {
        productSales.removeItem(productSale);
    }

    public void updateUser(User user) throws Exception {
        users.updateItem(user);
    }

    public void updateStore(Store store) throws Exception {
        stores.updateItem(store);
    }

    public void updateProduct(Product product) throws Exception {
        products.updateItem(product);
    }

    public void updatePriceAlert(PriceAlert priceAlert) throws Exception {
        priceAlerts.updateItem(priceAlert);
    }

    public void updateProductSale(ProductSale productSale) throws Exception {
        productSales.updateItem(productSale);
    }

    public void setUsers(ArrayList<User> users) throws Exception {
        this.users.setItems(users);
    }

    public void setStores(ArrayList<Store> stores) throws Exception {
        this.stores.setItems(stores);
    }

    public void setProducts(ArrayList<Product> products) throws Exception {
        this.products.setItems(products);
    }

    public void setPriceAlerts(ArrayList<PriceAlert> priceAlerts) throws Exception {
        this.priceAlerts.setItems(priceAlerts);
    }

    public void setProductSales(ArrayList<ProductSale> productSales) throws Exception {
        this.productSales.setItems(productSales);
    }
}
