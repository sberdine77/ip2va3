package br.ufrpe.ip2.va3.questao3.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.ip2.va3.questao3.data.DataBaseCommunication;
import br.ufrpe.ip2.va3.questao3.exceptions.ItemAlreadyExistsException;
import br.ufrpe.ip2.va3.questao3.exceptions.ItemDoesNotExistsException;

public class GenericRepository<T> {
    private ArrayList<T> items;
    private String filePath;

    public GenericRepository(String filePath) {
        this.filePath = filePath;
        this.items = new ArrayList<T>();
        Object itemsList = DataBaseCommunication.read(this.filePath);
        if (itemsList != null && itemsList instanceof List<?>){
            List<T> listOfItems = (List<T>) itemsList;
            this.items = new ArrayList<T>(listOfItems);
        }
    }

    public ArrayList<T> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<T> items) throws Exception {
        this.items = items;
        DataBaseCommunication.write(this.items, this.filePath);
    }

    public void addItem(T item) throws Exception {
        if(!this.items.contains(item)) {
            this.items.add(item);
            DataBaseCommunication.write(this.items, this.filePath);
        } else {
            throw new ItemAlreadyExistsException(item);
        }
    }

    public void removeItem(T item) throws Exception {
        if(this.items.contains(item)) {
            this.items.remove(this.items.indexOf(item));
            DataBaseCommunication.write(this.items, this.filePath);
        } else {
            throw new ItemDoesNotExistsException(item);
        }
    }

    public void updateItem(T item) throws Exception {
        if(!this.items.contains(item)) {
            this.items.set(this.items.indexOf(item), item);
            DataBaseCommunication.write(this.items, this.filePath);
        } else {
            throw new ItemAlreadyExistsException(item);
        }
    }
}
