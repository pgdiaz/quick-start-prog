package banco;

import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        Cuenta cuenta = crearCuenta(terminal);
        terminal.nextLine();
        int opcion = 0;
        do {
            opcion = obtenerOpcionMenu(terminal);
            terminal.nextLine();
            ejecutarOpcion(terminal, opcion, cuenta);
        } while (opcion != 0);
        terminal.close();
    }

    private static void ejecutarOpcion(Scanner terminal, int opcion, Cuenta cuenta) {
        switch (opcion) {
            case 0:
                System.out.println("Adios!");
                break;
            case 1:
                cuenta.mostrar();
                break;
            case 2:
                System.out.print("Ingrese el importe a depositar: ");
                cuenta.depositar(terminal.nextDouble());
                break;
            case 3:
                System.out.print("Ingrese el importe a retirar: ");
                if (!cuenta.extraer(terminal.nextDouble())) {
                    System.out.println("No tiene saldo suficiente para retirar.");
                }
                break;
            case 4:
                System.out.print("¿Desea bloquear la cuenta? s/n: ");
                String bloquear = terminal.nextLine();
                if (bloquear.toLowerCase().equals("s")) {
                    cuenta.bloquear();
                }
                break;
            case 5:
                System.out.print("¿Desea habilitar la cuenta? s/n: ");
                String habilitar = terminal.nextLine();
                if (habilitar.toLowerCase().equals("s")) {
                    cuenta.desbloquear();
                }
                break;
            default:
                System.out.println("Selección inválida!");
        }
    }

    private static int obtenerOpcionMenu(Scanner terminal) {
        System.out.println("\n------------------------------");
        System.out.println("|       Menu de Opciones       |");
        System.out.println("------------------------------");
        System.out.println("    1) Mostrar datos de la cuenta");
        System.out.println("    2) Ingresar dinero");
        System.out.println("    3) Extraer dinero");
        System.out.println("    4) Bloquear cuenta");
        System.out.println("    5) Desbloquear cuenta\n");
        System.out.print("Seleccione una opción del menu o 0 (cero) para finalizar: ");

        return terminal.nextInt();
    }

    private static Cuenta crearCuenta(Scanner terminal) {
        System.out.println("Creaación de cuenta");
        System.out.println("-----------------------");
        System.out.println("Ingrese los datos de la cuenta: ");
        System.out.print("\tNombre del cliente: ");
        String nombreCliente = terminal.nextLine();
        System.out.print("\tNúmero de cuenta: ");
        long numeroCuenta = terminal.nextLong();

        return new Cuenta(nombreCliente, numeroCuenta, 0);
    }

}
