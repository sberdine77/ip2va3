package br.ufrpe.ip2.va3.questao2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner positionScanner = new Scanner(System.in)) {
            Matrix matrix = new Matrix();
            Boolean continueGame = true;
            while(matrix.getGameState() == GameState.ONGOING && continueGame) {
                System.out.println("Apresentação do tabuleiro:\n");
                matrix.printMatrix();
                System.out.println("Quantidade de rainhas posicionadas = " + matrix.getQueensPlaced());
                System.out.println("Digite a posição para colocar uma rainha:");
                String position = positionScanner.next();
                try {
                    matrix.insertQueen(position);
                } catch (PositionNotValidException e) {
                    System.out.println(e.getMessage());
                } catch (PositionAlreadyContainsQueenException e) {
                    System.out.println(e.getMessage());
                } catch (PositionAlreadyAttackedByQueenException e) {
                    System.out.println(e.getMessage());
                }
                if(matrix.getGameState() == GameState.WON) {
                    System.out.println("Apresentação do tabuleiro:\n");
                    matrix.printMatrix();
                    System.out.println("Quantidade de rainhas posicionadas = " + matrix.getQueensPlaced());
                    System.out.println("PARABÉNS! VOCÊ CONSEGUIU COLOCAR AS 8 RAINHAS NO TABULEIRO!");
                    System.out.println("Deseja jogar novamente (S/N)?");
                    String shouldContinueStr = positionScanner.next();
                    continueGame = shouldContinue(shouldContinueStr);
                    matrix.resetGame();
                } else if(matrix.getGameState() == GameState.LOST) {
                    matrix.printMatrix();
                    System.out.println("Quantidade de rainhas posicionadas = " + matrix.getQueensPlaced());
                    System.out.println("VOCÊ FALHOU, POIS COLOCOU MENOS DE 8 RAINHAS NO TABULEIRO.");
                    System.out.println("Deseja jogar novamente (S/N)?");
                    String shouldContinueStr = positionScanner.next();
                    continueGame = shouldContinue(shouldContinueStr);
                    matrix.resetGame();
                }
                System.out.println("================================================\n");
            }
        }
    }
    static Boolean shouldContinue(String shouldContinue) {
        if(shouldContinue.equals("S") || shouldContinue.equals("s")) {
            return true;
        } else {
            return false;
        }
    }
}
