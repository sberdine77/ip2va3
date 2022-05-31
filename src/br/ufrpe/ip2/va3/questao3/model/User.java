package br.ufrpe.ip2.va3.questao3.model;

public class User extends RepositoryItem {
    private String name;
    private String email;

    public User(String name, String email, String id) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object item) {
        if(item instanceof User) {
            User castedUser = (User) item;
            return ((this.getId().equals(castedUser.getId())) || this.getEmail().equals(castedUser.getEmail()));
        } else {
            return false;
        }
    }
}
