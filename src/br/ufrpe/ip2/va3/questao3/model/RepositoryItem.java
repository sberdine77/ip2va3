package br.ufrpe.ip2.va3.questao3.model;

import java.io.Serializable;

public abstract class RepositoryItem implements Serializable {
    private String id;

    public RepositoryItem(String id) {
        this.id = id;
    }

    String getId() {
        return this.id;
    }
    
    @Override
    public boolean equals(Object item) {
        if(item instanceof RepositoryItem) {
            RepositoryItem castedRepositoryItem = (RepositoryItem) item;
            return this.getId().equals(castedRepositoryItem.getId());
        } else {
            return false;
        }
    }
}
