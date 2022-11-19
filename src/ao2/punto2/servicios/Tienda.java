package ao2.punto2.servicios;

import java.util.Scanner;

import ao2.punto2.dominio.Ropa;

public class Tienda {

    private static final int MAX_REINTENTOS = 3;

    private Ropa[] articulos;
    private Scanner terminal;

    public Tienda(Scanner terminal) {
        this.terminal = terminal;
        System.out.print("> Ingrese la cantidad de artículos: ");
        int cantidad = terminal.nextInt();
        this.articulos = new Ropa[cantidad];
    }

    public Operacion obtener() {
        terminal.nextLine();
        System.out.print("\n> Presione enter para continuar");
        terminal.nextLine();
        System.out.println("-------------------- Operaciones --------------------");
        System.out.println("    1) Cargar artículos");
        System.out.println("    2) Modificar un artículo");
        System.out.println("    3) Imprimir información de un artículo");
        System.out.println("    4) Informe de stock de artículos");
        System.out.println("    0) Salir del programa");
        System.out.print("\n> Selecciones una opción: ");

        return Operacion.of(this.terminal.nextInt());
    }

    public void ejecutar(Operacion operacion) {
        boolean reintentar = false;
        int reintentos = 0;
        do {
            try {
                operacion.ejecutar(terminal, articulos);
                reintentar = false;
            } catch (IllegalArgumentException input) {
                reintentar = true;
                System.out.println("ERROR: " + input.getMessage());
            } catch (IndexOutOfBoundsException limit) {
                reintentar = false;
                System.out.println("ERROR: " + limit.getMessage());
            }
        } while (reintentar && reintentos < MAX_REINTENTOS);
    }

}
