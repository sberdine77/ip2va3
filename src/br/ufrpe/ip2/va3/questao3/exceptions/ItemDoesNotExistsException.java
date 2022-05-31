package br.ufrpe.ip2.va3.questao3.exceptions;

public class ItemDoesNotExistsException extends Exception {
    private Object item;
    
    public ItemDoesNotExistsException(Object obj) {
        super("Objeto não existe no repositório.");
        this.item = obj;        
    }
    
    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
