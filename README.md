# Sudoku

Este es un simple juego de Sudoku en Java, diseñado para jugar en la consola. El juego cumple con las reglas básicas del Sudoku y proporciona una interfaz de usuario simple para interactuar con el tablero.

## Características

- Cumple con las reglas básicas del Sudoku.
- Interfaz de consola simple y fácil de usar.
- Colores para destacar números editables y originales.
- Prevención de movimientos inválidos, como números duplicados en la misma fila, columna o cuadrante.

## Cómo Jugar

Para jugar al Sudoku en este programa, sigue estos pasos:

1. Ejecuta la aplicación Java.
2. Observa el tablero de Sudoku en la consola.
3. Ingresa la fila en la que deseas colocar un número (1-9) o 0 para salir.
4. Ingresa la columna en la que deseas colocar el número (1-9).
5. Ingresa el número que deseas colocar (1-9) o 0 para borrar un número.
6. Repite los pasos 3 a 5 hasta que completes el Sudoku o decidas salir.

## Contribuir

Si deseas contribuir a este proyecto, siéntete libre de hacerlo. Puedes abrir problemas (issues) o enviar solicitudes de extracción (pull requests) para sugerir mejoras o correcciones. Además, puedes ayudar a mejorar la documentación y los comentarios del código para hacerlo más comprensible y legible.
Tambien hay metodos comentados ya que fueron versiones anteriores, toda mejora es bienvenida

## Métodos JavaDoc

Hemos agregado comentarios de JavaDoc a los métodos para mejorar la comprensión del código. Aquí tienes una descripción breve de los nuevos métodos:

- `verificarSudoku(int[][] tablero)`: Verifica si el tablero de Sudoku es válido, comprobando filas, columnas y cuadrantes.
- `verificarCuadrante(int[][] tablero)`: Verifica si un número en una posición específica de un cuadrante ya existe en el mismo.
- `verificarColumna(int[][] tablero)`: Verifica que no se repitan números en la misma columna.
- `verificarFila(int[][] tablero)`: Verifica que no se repitan números en la misma fila.
- `comprobar(int[][] tablero)`: Inicia el juego de Sudoku y permite al usuario ingresar números en el tablero.
- `imprimirTablero(int[][] tablero)`: Imprime el tablero de Sudoku en la consola.
- `esCasillaEditable(int[][] tablero, int fila, int columna)`: Verifica si una casilla en el tablero de Sudoku es editable.
- `esMovimientoValido(int[][] tablero, int fila, int columna, int numero)`: Verifica si un movimiento (inserción de un número) en el tablero de Sudoku es válido.
- `existeEnFila(int[][] tablero, int fila, int numero)`: Verifica si un número ya existe en la misma fila en el tablero de Sudoku.
- `existeEnColumna(int[][] tablero, int columna, int numero)`: Verifica si un número ya existe en la misma columna en el tablero de Sudoku.
- `existeEnCuadrante(int[][] tablero, int fila, int columna, int numero)`: Verifica si un número ya existe en el mismo cuadrante 3x3 en el tablero de Sudoku.
