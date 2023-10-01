package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] tablero = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        imprimeTablero(tablero);

        if (jugar(tablero)) {
            System.out.println("¡Has completado el Sudoku!");
            imprimeTablero(tablero);
        } else {
            System.out.println("No se pudo completar el Sudoku.");
        }
    }

    public static boolean jugar(int[][] board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa la fila (1-9, 0 para terminar): ");
            int row = scanner.nextInt();
            if (row == 0) {
                break;
            }

            System.out.print("Ingresa la columna (1-9): ");
            int col = scanner.nextInt();

            if (row < 1 || row > 9 || col < 1 || col > 9) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            System.out.print("Ingresa el número (1-9) o '0' para borrar: ");
            int num = scanner.nextInt();

            if (num < 0 || num > 9) {
                System.out.println("Número inválido. Intenta nuevamente.");
                continue;
            }

            if (board[row - 1][col - 1] == 0) {
                board[row - 1][col - 1] = num;
            } else if (num == 0) {
                board[row - 1][col - 1] = 0;
            } else {
                System.out.println("Casilla ocupada. Intenta nuevamente.");
                continue;
            }

            imprimeTablero(board);
        }

        scanner.close();
        return true;
    }

    public static void imprimeTablero(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = tablero[i][j];
                if (num == 0) {
                    System.out.print("\u001B[33m" + num + "\u001B[0m "); // Amarillo para 0
                } else {
                    System.out.print("\u001B[31m" + num + "\u001B[0m "); // Rojo para originales
                }
            }
            System.out.println();
        }
    }

}