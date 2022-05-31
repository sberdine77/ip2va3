package br.ufrpe.ip2.va3.questao3.model;

public class Store extends RepositoryItem {
    private String name;
    private String description;

    public Store(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object item) {
        if(item instanceof Store) {
            Store castedStore = (Store) item;
            return this.getId().equals(castedStore.getId());
        } else {
            return false;
        }
    }

}
