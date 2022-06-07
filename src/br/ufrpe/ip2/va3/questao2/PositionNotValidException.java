package br.ufrpe.ip2.va3.questao2;

public class PositionNotValidException extends Exception {
    private String position;

    public PositionNotValidException(String position) {
        super("POSIÇÃO " + position + " NÃO É VÁLIDA.");
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }    
}
