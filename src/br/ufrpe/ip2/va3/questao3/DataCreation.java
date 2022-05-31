package br.ufrpe.ip2.va3.questao3;

import java.util.UUID;

import br.ufrpe.ip2.va3.questao3.exceptions.ItemAlreadyExistsException;
import br.ufrpe.ip2.va3.questao3.model.PriceAlert;
import br.ufrpe.ip2.va3.questao3.model.Product;
import br.ufrpe.ip2.va3.questao3.model.ProductCategory;
import br.ufrpe.ip2.va3.questao3.model.Store;
import br.ufrpe.ip2.va3.questao3.model.User;
import br.ufrpe.ip2.va3.questao3.repository.GenericRepository;

public class DataCreation {
    public static void main(String[] args) {
        GenericRepository<User> userRepository = new GenericRepository<User>("users.dat");
        GenericRepository<Product> productRepository = new GenericRepository<Product>("products.dat");
        GenericRepository<PriceAlert> priceAlertRepository = new GenericRepository<PriceAlert>("priceAlerts.dat");
        GenericRepository<Store> storeRepository = new GenericRepository<Store>("stores.dat");

        User user1 = new User("João Miguel", "joao.miguel@email.com", UUID.randomUUID().toString());
        User user2 = new User("Felipe Antônio", "felipe.antoniio@email.com", UUID.randomUUID().toString());
        Product product1 = new Product(UUID.randomUUID().toString(), "Geladeira Azul", "Geladeira bonita", ProductCategory.COOKING);
        Product product2 = new Product(UUID.randomUUID().toString(), "Geladeira Branca", "Geladeira feia", ProductCategory.COOKING);
        PriceAlert priceAlert1 = new PriceAlert(user1, product1, 1500, UUID.randomUUID().toString());
        PriceAlert priceAlert2 = new PriceAlert(user2, product2, 1600, UUID.randomUUID().toString());
        Store store1 = new Store(UUID.randomUUID().toString(), "Loja1", "A melhor loja da região");
        Store store2 = new Store(UUID.randomUUID().toString(), "Loja2", "A segunda melhor loja da região");

        try {
            userRepository.addItem(user1);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            userRepository.addItem(user2);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            productRepository.addItem(product1);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            productRepository.addItem(product2);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            priceAlertRepository.addItem(priceAlert1);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            priceAlertRepository.addItem(priceAlert2);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            storeRepository.addItem(store1);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            storeRepository.addItem(store2);
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
