package unidad4;

import java.util.Scanner;

public class CargaArrays {

    /*
     * Crear un array de N edades de Alumnos, cargar el array, mostrar la mayor edad
     */
    public static void main(String[] args) {
        int[] edades;
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de alumnos: ");
        edades = new int[terminal.nextInt()];
        cargarEdades(terminal, edades);
        terminal.close();
        mostrarEdades(edades);
        System.out.println("------------ Buscar la mayor edad ------------");
        System.out.println(String.format("La mayor edad es %d", buscarMayorEdad(edades)));
    }

    private static void cargarEdades(Scanner terminal, int[] edades) {
        System.out.println("------------ Cargar edades ------------");
        for (int i = 0; i < edades.length; i++) {
            System.out.print("Ingrese la edad del alumno: ");
            edades[i] = terminal.nextInt();
        }
    }

    private static void mostrarEdades(int[] edades) {
        System.out.println("------------ Mostrar edades ------------");
        for (int i = 0; i < edades.length; i++) {
            System.out.println(String.format("La edad en la posición %d es %d", i, edades[i]));
        }
    }

    private static int buscarMayorEdad(int[] edades) {
        int mayor = 0;
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] > mayor) {
                mayor = edades[i];
            }
        }

        return mayor;
    }

}
