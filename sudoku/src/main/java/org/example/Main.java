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
     * @param tablero
     * @return
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
     * @param tablero
     * @return
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
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
     * Verifica que no se repitan numeros en la misma columna
     *
     * @param tablero
     * @return
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
     * Verifica que no se repitan numeros en la misma fila
     *
     * @param tablero
     * @return
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
     * Selecciona la fila y columna a jugar para introducir un numero
     * Despues detecta que se pueda jugar en esa casilla y si se cumplen las normas del sudoku
     *
     * @param tablero
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
     * Imprime el tablero de juego
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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