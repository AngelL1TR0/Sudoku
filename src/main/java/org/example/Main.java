package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] tablero = {

                //Tablero para jugar
                /*
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
                 */

                //tablero bien
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}


                //tablero mal
                /*
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 5}
                 */

        };

        //Metodo para empezar a jugar
        //comprobar(tablero);

        //Condicion que determina si la plantilla esta bien o no
        if (verificarSudoku(tablero)) {
            System.out.println("El sudoku está resuelto correctamente.");
        } else {
            System.out.println("El sudoku no está resuelto correctamente.");
        }
    }

    /**
     * Comprueba si un tablero de Sudoku es válido o no.
     *
     * @param tablero El tablero de Sudoku a comprobar.
     * @return `true` si el Sudoku es válido, `false` si no lo es.
     */
    private static boolean verificarSudoku(int[][] tablero) {
        // Verificaciones
        if (verificarFila(tablero) || verificarColumna(tablero)
                || verificarCuadrante(tablero)) return false;

        return true;
    }

    /**
     * Verifica si un número en una posición específica de un cuadrante ya existe en el mismo.
     *
     * @param tablero El tablero de Sudoku a comprobar.
     * @return `true` si se encuentra un número repetido en un cuadrante, `false` si no se encuentra.
     */
    public static boolean verificarCuadrante(int[][] tablero) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                ArrayList<Integer> numerosVistos = new ArrayList<>();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        int numero = tablero[x][y];
                        if (numerosVistos.contains(numero)) {
                            return true;
                        }
                        numerosVistos.add(numero);
                    }
                }
            }
        }
        return false;
    }
        /*
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int pos = 0; pos < 8; pos++) {
                    for (int pos2 = pos + 1; pos2 < 9; pos2++) {
                        int x1 = i + pos % 3;
                        int y1 = j + pos / 3;
                        int x2 = i + pos2 % 3;
                        int y2 = j + pos2 / 3;

                        if (tablero[x1][y1] == tablero[x2][y2]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

        int cuadranteFilaInicio = (i / 3) * 3;
        int cuadranteColumnaInicio = (j / 3) * 3;
        for (int x = cuadranteFilaInicio; x < cuadranteFilaInicio + 3; x++) {
            for (int y = cuadranteColumnaInicio; y < cuadranteColumnaInicio + 3; y++) {
                int num = tablero[x][y];
                for (int w = cuadranteFilaInicio; w < cuadranteFilaInicio + 3; x++) {
                    for (int z = w + 1; z < cuadranteColumnaInicio + 3; y++) {
                        if (x != w && y != z && tablero[x][y] == num) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
         */

    /**
     * Verifica que no se repitan números en la misma columna.
     *
     * @param tablero El tablero de Sudoku a comprobar.
     * @return `true` si se encuentra un número repetido en una columna, `false` si no se encuentra.
     */
    public static boolean verificarColumna(int[][] tablero) {
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                for (int k = i + 1; k < 9; k++) {
                    if (tablero[i][j] == tablero[k][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /*
        for (int j = 0; j < 9; j++) {
            ArrayList<Integer> repetidos = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                int numero = tablero[i][j];
                if (repetidos.contains(numero)) {
                    return true;
                }
                repetidos.add(numero);
            }
        }
        return false;
    }

     */

    /**
     * Verifica que no se repitan números en la misma fila.
     *
     * @param tablero El tablero de Sudoku a comprobar.
     * @return `true` si se encuentra un número repetido en una fila, `false` si no se encuentra.
     */
    public static boolean verificarFila(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (tablero[i][j] == tablero[i][k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
        /*
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> repetidos = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                int numero = tablero[i][j];
                if (repetidos.contains(numero)) {
                    return true;
                }
                repetidos.add(numero);
            }
        }
        return false;
    }
         */


    /**
     * Inicia el juego de Sudoku, permitiendo al usuario ingresar números en el tablero.
     *
     * @param tablero El tablero de Sudoku en el que se jugará.
     */
    public static void comprobar(int[][] tablero) {
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
            }

            System.out.println("Ingresa el número (1-9) o '0' para borrar: ");
            int numero = scanner.nextInt();

            if (numero >= 0 && numero <= 9 && esMovimientoValido(tablero, fila, columna, numero)) {
                tablero[fila - 1][columna - 1] = numero;
            } else {
                System.out.println("Movimiento no válido. Intenta nuevamente.");
            }
        }

    }

    /**
     * Imprime el tablero de Sudoku en la consola.
     *
     * @param tablero El tablero de Sudoku a imprimir.
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
     * Verifica si una casilla en el tablero de Sudoku es editable (es decir, no contiene un número fijo).
     *
     * @param tablero El tablero de Sudoku.
     * @param fila    La fila de la casilla.
     * @param columna La columna de la casilla.
     * @return `true` si la casilla es editable, `false` si no lo es.
     */
    public static boolean esCasillaEditable(int[][] tablero, int fila, int columna) {
        return tablero[fila - 1][columna - 1] == 0;
    }

    /**
     * Verifica si un movimiento (inserción de un número) en el tablero de Sudoku es válido.
     *
     * @param tablero El tablero de Sudoku.
     * @param fila    La fila en la que se realiza el movimiento.
     * @param columna La columna en la que se realiza el movimiento.
     * @param numero  El número que se intenta colocar en la casilla.
     * @return `true` si el movimiento es válido, `false` si no lo es.
     */
    public static boolean esMovimientoValido(int[][] tablero, int fila, int columna, int numero) {
        return !existeEnFila(tablero, fila, numero) &&
                !existeEnColumna(tablero, columna, numero) &&
                !existeEnCuadrante(tablero, fila, columna, numero);
    }

    /**
     * Verifica si un número ya existe en la misma fila en el tablero de Sudoku.
     *
     * @param tablero El tablero de Sudoku.
     * @param fila    La fila en la que se verifica.
     * @param numero  El número a verificar.
     * @return `true` si el número ya existe en la fila, `false` si no existe.
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
     * Verifica si un número ya existe en la misma columna en el tablero de Sudoku.
     *
     * @param tablero El tablero de Sudoku.
     * @param columna La columna en la que se verifica.
     * @param numero  El número a verificar.
     * @return `true` si el número ya existe en la columna, `false` si no existe.
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
     * Verifica si un número ya existe en el mismo cuadrante 3x3 en el tablero de Sudoku.
     *
     * @param tablero El tablero de Sudoku.
     * @param fila    La fila de la casilla.
     * @param columna La columna de la casilla.
     * @param numero  El número a verificar.
     * @return `true` si el número ya existe en el cuadrante, `false` si no existe.
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