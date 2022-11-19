package unidad5;

import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            System.out.print("> Ingrese la cantidad de productos: ");
            int cantidad = terminal.nextInt();
            Productos productos = new Productos(cantidad);
            int opcion = 0;
            do {
                terminal.nextLine();
                mostrarMenu();
                opcion = terminal.nextInt();
                ejecutarOpcion(opcion, terminal, productos);
            } while (opcion != 0);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

    private static void mostrarMenu() {
        System.out.println("-------------------- Menú --------------------");
        System.out.println("    1) Ingreso de datos");
        System.out.println("    2) Ordenamiento por código de producto");
        System.out.println("    3) Búsqueda por código de producto");
        System.out.println("    4) Producto con mayor precio");
        System.out.println("    0) Salir del programa");
        System.out.print("\n> Selecciones una opción: ");
    }

    private static void ejecutarOpcion(int opcion, Scanner terminal, Productos productos) {
        terminal.nextLine();
        switch (opcion) {
            case 0:
                System.out.println("Hasta pronto!");
                break;
            case 1:
                cargar(terminal, productos);
                break;
            case 2:
                ordenar(terminal, productos);
                break;
            case 3:
                buscar(terminal, productos);
                break;
            case 4:
                mayor(terminal, productos);
                break;
            default:
                throw new IllegalArgumentException("La opción no tiene una operación definida.");
        }
    }

    private static void cargar(Scanner terminal, Productos productos) {
        System.out.println("-------------------- Carga de productos --------------------");
        for (int i = 0; i < productos.getCantidad(); i++) {
            System.out.print("> Ingrese el código: ");
            long codigo = terminal.nextLong();
            terminal.nextLine();
            System.out.print("> Ingrese el nombre: ");
            String nombre = terminal.nextLine();
            System.out.print("> Ingrese el precio: ");
            double precio = terminal.nextDouble();
            productos.agregar(codigo, nombre, precio);
        }
    }

    private static void ordenar(Scanner terminal, Productos productos) {
        System.out.println("-------------------- Ordenar productos --------------------");
        System.out.print("\n> Seleccione el tipo de ordenamiento DESC [D]/ASC [A]:");
        Productos.Ordenamiento orden;
        try {
            orden = Productos.Ordenamiento.of(terminal.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Error en la selección, se aplicará el ordenamiento por defecto: ASC");
            orden = Productos.Ordenamiento.ASC;
        }
        productos.ordenar(orden);
        productos.imprimir();
    }

    private static void buscar(Scanner terminal, Productos productos) {
        System.out.println("-------------------- Búsqueda de productos --------------------");
        System.out.print("\n> Seleccione el tipo de búsqueda LINEAL [L]/BINARIA [B]:");
        Productos.TipoBusqueda tipo;
        try {
            tipo = Productos.TipoBusqueda.of(terminal.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Error en la selección, se aplicará el tipo de búsqueda por defecto: BINARIA");
            tipo = Productos.TipoBusqueda.BINARIA;
        }
        System.out.print("> Ingrese el código del producto a buscar: ");
        long codigo = terminal.nextLong();
        int indice = productos.buscar(tipo, codigo);
        if (indice < 0) {
            System.out.println("No se encontró un producto con el código ingresado");
        } else {
            productos.imprimir(indice);
        }
    }

    private static void mayor(Scanner terminal, Productos productos) {
        int indice = productos.mayorPrecio();
        System.out.println("-------------------- Producto de mayor precio --------------------");
        productos.imprimir(indice);
    }

}
