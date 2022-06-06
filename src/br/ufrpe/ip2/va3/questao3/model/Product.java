package br.ufrpe.ip2.va3.questao3.model;

public class Product extends RepositoryItem {
    private String name;
    private String description;
    private ProductCategory category;


    public Product(String id, String name, String description, ProductCategory category) {
        super(id);
        this.name = name;
        this.description = description;
        this.category = category;
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

    public ProductCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object item) {
        if(item instanceof Product) {
            Product castedProduct = (Product) item;
            return this.getId().equals(castedProduct.getId());
        } else {
            return false;
        }
    }
}
