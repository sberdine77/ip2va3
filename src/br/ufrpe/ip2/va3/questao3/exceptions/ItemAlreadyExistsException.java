package br.ufrpe.ip2.va3.questao3.exceptions;

public class ItemAlreadyExistsException extends Exception {
	private Object item;
    
    public ItemAlreadyExistsException(Object obj) {
        super("Objeto já está cadastrado no repositório.");
        this.item = obj;        
    }
    
    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
