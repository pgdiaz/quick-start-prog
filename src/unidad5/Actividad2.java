package unidad5;

import java.util.Scanner;

/*
 * Escribir un programa que permita cargar dos arreglos unidimensionales de n elementos cada uno.
 * El primero contendrá el DNI de n personas y el segundo los nombres correspondientes.
 * Se pide desarrollar los métodos necesarios que permitan la carga de los arreglos.
 * El programa debe mostrar el nombre de una persona ingresando su DNI por teclado.
 * Si la misma no se encuentra en el arreglo, emitir un mensaje indicándolo expresamente.
 */
public class Actividad2 {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de personas: ");
        try {
            int cantidad = terminal.nextInt();
            Personas listado = new Personas(cantidad);
            System.out.println("----------- Carga de personas -----------");
            for (int i = 0; i < cantidad; i++) {
                System.out.print("> Ingrese el DNI: ");
                long dni = terminal.nextLong();
                terminal.nextLine();
                System.out.print("> Ingrese el nombre: ");
                String nombre = terminal.nextLine();
                listado.agregar(dni, nombre);
            }
            System.out.println("----------- Buscar persona -----------");
            System.out.print("> Ingrese el DNI: ");
            long dni = terminal.nextLong();
            listado.mostrar(dni);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

}
