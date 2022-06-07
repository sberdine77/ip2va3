package br.ufrpe.ip2.va3.questao2;

public class PositionAlreadyAttackedByQueenException extends Exception {
    private String position;

    public PositionAlreadyAttackedByQueenException(String position) {
        super("POSIÇÃO " + position + " JÁ ATACADA POR OUTRA RAINHA.");
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    } 
}
