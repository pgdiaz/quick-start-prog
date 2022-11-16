package unidad5;

import java.util.Scanner;

/*
 * Escribir un programa que permita cargar dos arreglos unidimensionales de n elementos cada uno.
 * El primero contendrá la descripción de 'n' artículos y el segundo sus precios unitarios.
 * Se pide desarrollar los métodos necesarios que permitan la carga de los arreglos y,
 * la muestra de la descripción y el precio unitario de cada artículo ordenados por este ultimo
 * en forma ascendente.
 */
public class Actividad1 {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de artículos: ");
        try {
            int cantidad = terminal.nextInt();
            Articulos listado = new Articulos(cantidad);
            System.out.println("----------- Carga de artículos -----------");
            for (int i = 0; i < cantidad; i++) {
                terminal.nextLine();
                System.out.print("> Ingrese la descripción: ");
                String descripcion = terminal.nextLine();
                System.out.print("> Ingrese el precio: ");
                double precio = terminal.nextDouble();
                listado.agregar(descripcion, precio);
            }
            listado.imprimir();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

}
