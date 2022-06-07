package br.ufrpe.ip2.va3.questao2;

import java.security.PublicKey;

public class Matrix {
    private char[][] matrix = new char[8][8];
    private int tries;
    private int queensPlaced;
    private GameState gameState;

    public Matrix() {
        this.tries = 0;
        this.queensPlaced = 0;
        this.gameState = GameState.ONGOING;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                this.matrix[i][j] = '_';
            }
        }
    }

    public void resetGame() {
        this.tries = 0;
        this.queensPlaced = 0;
        this.gameState = GameState.ONGOING;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                this.matrix[i][j] = '_';
            }
        }
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    private void decideIfGameIsLost() {
        if(this.gameState == GameState.WON) {
            return;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '_') {
                    return;
                }
            }
        }
        this.gameState = GameState.LOST;
    }

    public int getQueensPlaced() {
        return this.queensPlaced;
    }

    public int getTries() {
        return this.tries;
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.printf("%s ", matrix[i][j]);
                if(j == matrix[i].length - 1) {
                    System.out.printf("%d\n", i + 1);
                }
            }
        }
        System.out.printf("a b c d e f g h\n\n");
    }

    public void insertQueen(String position) throws Exception {
        if(position.length() != 2) {
            throw new PositionNotValidException(position);
        }
        String columnStr = position.substring(0, 1);
        String lineStr = position.substring(1);

        int column;
        int line;

        switch (columnStr) {
            case "a":
                column = 0;
                break;
            case "b":
                column = 1;
                break;
            case "c":
                column = 2;
                break;
            case "d":
                column = 3;
                break;
            case "e":
                column = 4;
                break;
            case "f":
                column = 5;
                break;
            case "g":
                column = 6;
                break;
            case "h":
                column = 7;
                break;
            default:
                throw new PositionNotValidException(position);
        }

        switch (lineStr) {
            case "1":
                line = 0;
                break;
            case "2":
                line = 1;
                break;
            case "3":
                line = 2;
                break;
            case "4":
                line = 3;
                break;
            case "5":
                line = 4;
                break;
            case "6":
                line = 5;
                break;
            case "7":
                line = 6;
                break;
            case "8":
                line = 7;
                break;
            default:
                throw new PositionNotValidException(position);
        }
        if(this.matrix[line][column] == 'R') {
            throw new PositionAlreadyContainsQueenException(position);
        } else if(this.matrix[line][column] == '.') {
            throw new PositionAlreadyAttackedByQueenException(position);
        } else {
            this.matrix[line][column] = 'R';
            this.queensPlaced += 1;
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    if(!(i == line && j == column)) {
                        if(i == line) {
                            this.matrix[i][j] = '.';
                        } else if(j == column) {
                            this.matrix[i][j] = '.';
                        } else if(Math.abs(i - line) == Math.abs(j - column)) {
                            this.matrix[i][j] = '.';
                        }
                    }
                }
            }
        }
        this.tries += 1;
        if(this.tries > 7) {
            if(this.queensPlaced > 7) {
                this.gameState = GameState.WON;
            } else {
                this.gameState = GameState.LOST;
            }
        }
        decideIfGameIsLost();
    }
}
