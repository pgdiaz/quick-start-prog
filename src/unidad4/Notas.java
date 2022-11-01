package unidad4;

import java.util.Scanner;

public class Notas {

    public static void main(String[] args) {
        long[] legajos;
        double[] notas;
        Scanner terminal = new Scanner(System.in);
        System.out.print("\n> Ingrese la cantidad de notas a cargar: ");
        int cantidad = terminal.nextInt();
        legajos = new long[cantidad];
        notas = new double[cantidad];
        cargar(terminal, legajos, notas);
        System.out.print("\n> Ingrese la nota de aprobación: ");
        double notaLimite = terminal.nextDouble();
        terminal.close();
        mostrarAprobados(legajos, notas, notaLimite);
    }

    private static void cargar(Scanner terminal, long[] legajos, double[] notas) {
        System.out.println("\n-------------- Cargar notas --------------");
        for (int i = 0; i < legajos.length; i++) {
            System.out.print("Ingrese el legajo del alumno: ");
            legajos[i] = terminal.nextLong();
            System.out.print("Ingrese la nota del alumno: ");
            notas[i] = terminal.nextDouble();
        }
    }

    private static void mostrarAprobados(long[] legajos, double[] notas, double limite) {
        System.out.println("\n-------------- Alumnos aprobados --------------");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= limite) {
                System.out.println(String.format(
                        "La nota del alumno de legajo %d es %.2f",
                        legajos[i],
                        notas[i]));
            }
        }
    }

}
