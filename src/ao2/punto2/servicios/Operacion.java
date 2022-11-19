package ao2.punto2.servicios;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import ao2.punto2.dominio.Articulo;
import ao2.punto2.dominio.Ropa;
import ao2.punto2.dominio.Talle;

public enum Operacion {

    FINALIZAR {
        @Override
        public void ejecutar(Scanner terminal, Ropa[] articulos) {
            System.out.println("Hasta pronto!");
        }
    },
    CARGAR {
        @Override
        public void ejecutar(Scanner terminal, Ropa[] articulos) {
            if (Articulo.getStock() == articulos.length) {
                throw new IndexOutOfBoundsException("Ha superado el limite de artículos.");
            }
            System.out.println("-------------------- Carga de artículos --------------------");
            for (int i = 0; i < articulos.length; i++) {
                Ropa articulo = new Ropa();
                System.out.print("> Ingrese el código: ");
                articulo.setCodigo(terminal.nextLong());
                cargar(terminal, articulo);
                articulos[i] = articulo;
            }
        }
    },
    MODIFICAR {
        @Override
        public void ejecutar(Scanner terminal, Ropa[] articulos) {
            System.out.println("-------------------- Modificar un artículo --------------------");
            System.out.print("> Ingrese el código del artículo: ");
            Ropa articulo = buscar(articulos, terminal.nextLong());
            cargar(terminal, articulo);
        }
    },
    IMPRIMIR {
        @Override
        public void ejecutar(Scanner terminal, Ropa[] articulos) {
            System.out.println("-------------------- Mostrar un artículo --------------------");
            System.out.print("> Ingrese el código del artículo: ");
            Ropa ropa = buscar(articulos, terminal.nextLong());
            System.out.println("Código: " + ropa.getCodigo());
            System.out.println("Nombre: " + ropa.getNombre());
            System.out.println("Precio: " + ropa.getPrecio());
            System.out.println("Origen: " + ropa.getOrigen());
            System.out.println("Modelo: " + ropa.getModelo());
            System.out.println("Talle: " + ropa.getTalle());
        }
    },
    INFORMAR {
        @Override
        public void ejecutar(Scanner terminal, Ropa[] articulos) {
            System.out.println("-------------------- Stock de artículos --------------------");
            System.out.println(Articulo.getStock());
        }
    };

    public static Operacion of(int value) {
        return Stream.of(values())
                .filter(item -> item.ordinal() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("La operación no está definida"));
    }

    public abstract void ejecutar(Scanner terminal, Ropa[] articulos);

    private static void cargar(Scanner terminal, Ropa articulo) {
        terminal.nextLine();
        System.out.print("> Ingrese el nombre: ");
        articulo.setNombre(terminal.nextLine());
        System.out.print("> Ingrese el precio: ");
        articulo.setPrecio(terminal.nextDouble());
        terminal.nextLine();
        System.out.print("> Ingrese el origen: ");
        articulo.setOrigen(terminal.nextLine());
        System.out.print("> Ingrese el modelo: ");
        articulo.setModelo(terminal.nextLine());
        System.out.print(String.format("> Ingrese el talle %s: ", Arrays.toString(Talle.values())));
        articulo.setTalle(terminal.nextLine());
        System.out.println("----------------------------------------");
    }

    private static Ropa buscar(Ropa[] articulos, long codigo) {
        int indice = busquedaBinaria(articulos, codigo);
        if (indice < 0) {
            throw new IllegalArgumentException("No se encontró un artículo con el código ingresado");
        }

        return articulos[indice];
    }

    private static int busquedaBinaria(Ropa[] articulos, long codigo) {
        int central, bajo = 0, alto = articulos.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            if (codigo == articulos[central].getCodigo()) {
                return central;
            } else if (codigo < articulos[central].getCodigo()) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

}
