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

        jugar(tablero);
    }

    /**
     * Selecciona la fila y columna a jugar para introducir un numero
     * Despues detecta que se pueda jugar en esa casilla y si se cumplen las normas del sudoku
     * @param tablero
     */
    public static void jugar(int[][] tablero) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            imprimirTablero(tablero);
            System.out.println("Ingresa la fila (1-9, 0 para salir): ");
            int fila = scanner.nextInt();
            if (fila == 0) {
                break;
            }

            System.out.println("Ingresa la columna (1-9): ");
            int columna = scanner.nextInt();

            if (!esCasillaEditable(tablero, fila, columna)) {
                System.out.println("No puedes modificar este número.");
                continue;
            }

            System.out.println("Ingresa el número (1-9) o '0' para borrar: ");
            int numero = scanner.nextInt();

            if (numero >= 0 && numero <= 9 && esMovimientoValido(tablero, fila, columna, numero)) {
                tablero[fila - 1][columna - 1] = numero;
            } else {
                System.out.println("Movimiento no válido. Intenta nuevamente.");
            }
        }

        scanner.close();
    }

    /**
     * Imprime el tablero de juego
     * @param tablero
     */
    public static void imprimirTablero(int[][] tablero) {
        System.out.println("Tablero de Sudoku:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = tablero[i][j];
                if (num == 0) {
                    System.out.print("\u001B[31m" + num + "\u001B[0m "); // Rojo para 0
                } else {
                    System.out.print(num + " "); // Resto sin color
                }
                //Falta averiguar como los nuevos sean de otro color
            }
            System.out.println();
        }
    }

    /**
     * Detecta si se puede jugar en esa casilla, es decir que sea un '0'
     * @param tablero
     * @param fila
     * @param columna
     * @return
     */
    public static boolean esCasillaEditable(int[][] tablero, int fila, int columna) {
        return tablero[fila - 1][columna - 1] == 0;
    }

    /**
     * Llama al resto de metodos para comprobar que se cumplan las reglas del sudoku
     * @param tablero
     * @param fila
     * @param columna
     * @param numero
     * @return
     */
    public static boolean esMovimientoValido(int[][] tablero, int fila, int columna, int numero) {
        return !existeEnFila(tablero, fila, numero) &&
                !existeEnColumna(tablero, columna, numero) &&
                !existeEnCuadrante(tablero, fila, columna, numero);
    }

    /**
     * Detecta que el mismo numero no este en la misma fila
     * @param tablero
     * @param fila
     * @param numero
     * @return
     */
    public static boolean existeEnFila(int[][] tablero, int fila, int numero) {
        for (int i = 0; i < 9; i++) {
            if (tablero[fila - 1][i] == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Detecta que el mismo numero no este en la misma columna
     * @param tablero
     * @param columna
     * @param numero
     * @return
     */
    public static boolean existeEnColumna(int[][] tablero, int columna, int numero) {
        for (int i = 0; i < 9; i++) {
            if (tablero[i][columna - 1] == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Detecta que el mismo numero introducido no este en el mismo cuadrante 3x3
     * @param tablero
     * @param fila
     * @param columna
     * @param numero
     * @return
     */
    public static boolean existeEnCuadrante(int[][] tablero, int fila, int columna, int numero) {
        int cuadranteFilaInicio = (fila - 1) / 3 * 3;
        int cuadranteColumnaInicio = (columna - 1) / 3 * 3;

        for (int i = cuadranteFilaInicio; i < cuadranteFilaInicio + 3; i++) {
            for (int j = cuadranteColumnaInicio; j < cuadranteColumnaInicio + 3; j++) {
                if (tablero[i][j] == numero) {
                    return true;
                }
            }
        }

        return false;
    }
}