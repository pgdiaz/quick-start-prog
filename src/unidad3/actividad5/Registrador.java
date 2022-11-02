package unidad3.actividad5;

import java.util.Scanner;

public class Registrador {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        registrarCliente(terminal);
        terminal.nextLine();
        registrarEmpleado(terminal);
        terminal.close();
    }

    private static void registrarCliente(Scanner terminal) {
        System.out.println("------------ Registrar Cliente ------------");
        System.out.print("> Ingrese el nombre: ");
        String nombre = terminal.nextLine();
        System.out.print("> Ingrese el DNI: ");
        long dni = terminal.nextLong();
        System.out.print("> Ingrese la edad: ");
        int edad = terminal.nextInt();
        Persona cliente = new Persona();
        cliente.asignarDatos(nombre, dni, edad);
        cliente.imprimirInformacion();
    }

    private static void registrarEmpleado(Scanner terminal) {
        System.out.println("------------ Registrar Empleado ------------");
        System.out.print("> Ingrese el nombre: ");
        String nombre = terminal.nextLine();
        System.out.print("> Ingrese el DNI: ");
        long dni = terminal.nextLong();
        System.out.print("> Ingrese la edad: ");
        int edad = terminal.nextInt();
        System.out.print("> Ingrese el legajo: ");
        long legajo = terminal.nextLong();
        terminal.nextLine();
        System.out.print("> Ingrese el cargo: ");
        String cargo = terminal.nextLine();
        Empleado empleado = new Empleado();
        empleado.asignarDatos(nombre, dni, edad, legajo, cargo);
        empleado.imprimirInformacion();
    }

}
