package br.ufrpe.ip2.va3.questao2;

public class PositionAlreadyContainsQueenException extends Exception {
    private String position;

    public PositionAlreadyContainsQueenException(String position) {
        super("POSIÇÃO " + position + " JÁ CONTÉM OUTRA RAINHA.");
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }   
}
