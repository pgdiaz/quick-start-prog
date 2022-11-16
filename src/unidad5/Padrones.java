package unidad5;

import java.util.Scanner;

public class Padrones {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de empadronados: ");
        try {
            int cantidad = terminal.nextInt();
            long[] padron = new long[cantidad];
            System.out.println("----------- Carga -----------");
            for (int i = 0; i < cantidad; i++) {
                System.out.print("> Ingrese el DNI: ");
                insertar(padron, i, terminal.nextLong());
            }
            System.out.println("----------- Buscar -----------");
            System.out.print("> Ingrese el DNI: ");
            int indice = buscar(padron, terminal.nextLong());
            if (indice < 0) {
                System.out.println("No se encuentra empadronado");
            } else {
                System.out.println("Se encuentra empadronado");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

    private static void insertar(long[] arreglo, int tope, long valor) {
        if (tope == 0) {
            arreglo[tope] = valor;
        } else {
            int puntero = tope;
            while (puntero > 0 && valor < arreglo[puntero - 1]) {
                arreglo[puntero] = arreglo[puntero - 1];
                puntero--;
            }
            arreglo[puntero] = valor;
        }
    }

    private static int buscar(long[] arreglo, long valor) {
        int central, bajo = 0, alto = arreglo.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            if (valor == arreglo[central]) {
                return central;
            } else if (valor < arreglo[central]) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

}
