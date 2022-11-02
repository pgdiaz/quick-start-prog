package unidad3.autoevaluacion;

import java.util.Scanner;

public class Tienda {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        registrarArticulo(terminal);
        registrarRopa(terminal);
        terminal.close();
    }

    private static void registrarArticulo(Scanner terminal) {
        System.out.println("------------ Registrar Articulo ------------");
        System.out.print("> Ingrese el código: ");
        long codigo = terminal.nextLong();
        terminal.nextLine();
        System.out.print("> Ingrese el nombre: ");
        String nombre = terminal.nextLine();
        System.out.print("> Ingrese el precio: ");
        double precio = terminal.nextDouble();
        Articulo articulo = new Articulo(codigo, nombre, precio);
        articulo.imprimir();
    }

    private static void registrarRopa(Scanner terminal) {
        System.out.println("------------ Registrar Ropa ------------");
        System.out.print("> Ingrese el código: ");
        long codigo = terminal.nextLong();
        terminal.nextLine();
        System.out.print("> Ingrese el nombre: ");
        String nombre = terminal.nextLine();
        System.out.print("> Ingrese el precio: ");
        double precio = terminal.nextDouble();
        terminal.nextLine();
        System.out.print("> Ingrese el talle: ");
        String talle = terminal.nextLine();
        System.out.print("> Ingrese el modelo: ");
        String modelo = terminal.nextLine();
        Ropa ropa = new Ropa(codigo, nombre, precio, talle, modelo);
        ropa.imprimir();
    }

}
