package unidad4;

import java.util.Scanner;

public class DeclaracionArrays {

    /*
     * Distintos tipos de declaraciones
     * char cad[], p; -> cad es un array de tipo char y p es una variable de tipo char
     * int [] v, w; -> tanto v como w son declarados arrays unidimensionales de tipo int
     * double []m, t[], x; -> m y x son arrays de tipo double, t es un array de array de tipo double
     * edades = new int[10]; -> Asignamos al vector edades el numero de elementos
     * int []edades = new int[30]; -> Se podria declarar todo en una misma sentencia
     */

    public static void main(String[] args) {

        int[] edades = { 10, 15, 21, 55 };

        Scanner terminal = new Scanner(System.in);
        System.out.println(String.format("Cantidad de edades %d", edades.length));
        System.out.print("Ingrese el indice del valor a leer: ");
        int indice = terminal.nextInt();
        if (indice >= edades.length) {
            System.out.println(String.format("Fuera de rango: No se puede acceder a la posición %d", indice));
        } else {
            System.out.println(String.format("El valor de la posición %d es %d", indice, edades[indice]));
        }
        terminal.close();
    }

}
