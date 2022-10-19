package ao1.carrito;

import java.util.List;
import java.util.Scanner;

public class Caja {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        Carrito carrito = new Carrito();
        double precio = 0;
        System.out.println("Ingrese 0 (cero) para finalizar");
        do {
            System.out.print("Ingrese el precio del articulo: ");
            precio = terminal.nextDouble();
            if (precio > 0) {
                carrito.agregarArticulo(new Articulo(precio));
            }
        } while (precio != 0);
        terminal.close();
        imprimirTicket(carrito.finalizarCompra());
    }

    private static void imprimirTicket(List<Articulo> articulos) {
        if (articulos.isEmpty()) {
            System.out.println("El carrito está vacío!");
        } else {
            System.out.println("\n---------------------------------");
            System.out.println("|             Ticket             |");
            System.out.println("----------------------------------");
            articulos.forEach(articulo -> {
                System.out.println(String.format("Precio de lista $ %.2f", articulo.getPrecio()));
                System.out.println(String.format("Descuento $ %.2f", articulo.getDescuento()));
                System.out.println(String.format("Precio final $ %.2f", articulo.getCosto()));
                System.out.println("\n---------------------------------");
            });
            System.out.println(String.format(
                    "Total $ %.2f",
                    articulos.stream().mapToDouble(articulo -> articulo.getCosto()).reduce(0L, Double::sum)));
        }
    }

}
