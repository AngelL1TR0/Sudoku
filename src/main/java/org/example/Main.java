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
            int fila = scanner.nextInt();
            if (fila == 0) {
                break;
            }

            System.out.print("Ingresa la columna (1-9): ");
            int columna = scanner.nextInt();

            if (!esEntradaValida(fila, columna) || !esCasillaVacia(board, fila, columna)) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            System.out.print("Ingresa el número (1-9) o '0' para borrar: ");
            int num = scanner.nextInt();

            if (!esNumeroValido(num)) {
                System.out.println("Número inválido. Intenta nuevamente.");
                continue;
            }

            if (!esMovimientoValido(board, fila, columna, num)) {
                System.out.println("Movimiento no válido. Intenta nuevamente.");
                continue;
            }

            board[fila - 1][columna - 1] = num;
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
                } else if (num < 0) {
                    System.out.print("\u001B[32m" + num + "\u001B[0m "); // Verde para números nuevos
                } else {
                    System.out.print("\u001B[31m" + num + "\u001B[0m "); // Rojo para originales
                }
            }
            System.out.println();
        }
    }

    public static boolean esEntradaValida(int fila, int columna) {
        return fila >= 1 && fila <= 9 && columna >= 1 && columna <= 9;
    }

    public static boolean esCasillaVacia(int[][] board, int fila, int columna) {
        return board[fila - 1][columna - 1] == 0;
    }

    public static boolean esNumeroValido(int num) {
        return num >= 0 && num <= 9;
    }

    public static boolean esMovimientoValido(int[][] board, int fila, int columna, int num) {
        // Verificar si el número ya existe en la misma fila, columna o cuadrante
        return !existeEnFila(board, fila, num) && !existeEnColumna(board, columna, num) && !existeEnCuadrante(board, fila, columna, num);
    }

    public static boolean existeEnFila(int[][] board, int fila, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[fila - 1][col] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeEnColumna(int[][] board, int columna, int num) {
        for (int fila = 0; fila < 9; fila++) {
            if (board[fila][columna - 1] == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeEnCuadrante(int[][] board, int fila, int columna, int num) {
        int cuadranteFilaInicio = (fila - 1) / 3 * 3;
        int cuadranteColumnaInicio = (columna - 1) / 3 * 3;
        for (int i = cuadranteFilaInicio; i < cuadranteFilaInicio + 3; i++) {
            for (int j = cuadranteColumnaInicio; j < cuadranteColumnaInicio + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}