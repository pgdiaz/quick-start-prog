package unidad5;

import java.util.Objects;

import unidad5.Productos.Ordenamiento;
import unidad5.Productos.TipoBusqueda;

public class ProductosTests {

    public static void main(String[] args) {
        ingresoDeDatosSatisfactorioTest();
        superarLimiteTest();
        superarCapacidadTest();
        ordenamientoAscendentePorCodigoTest();
        ordenamientoDescendentePorCodigoTest();
        busquedaLineaPorCodigoTest();
        busquedaBinariaPorCodigoTest();
        busquedaCodigoNoEncontradoTest();
        obtenerProductoDeMayorPrecioTest();
        cambiarOrdenAgregacionTest();
    }

    private static void ingresoDeDatosSatisfactorioTest() {
        String testName = "IngresoDeDatosSatisfactorioTest";
        Productos productos = new Productos(100);
        long expectedCodigo = 123456;
        String expectedNombre = "Test";
        double expectedPrecio = 25.50;
        productos.agregar(expectedCodigo, expectedNombre, expectedPrecio);
        assertTest(testName, "Código", productos.getCodigo(0) == expectedCodigo);
        assertTest(testName, "Nombre", productos.getNombre(0).equals(expectedNombre));
        assertTest(testName, "Precio", productos.getPrecio(0) == expectedPrecio);
    }

    private static void superarLimiteTest() {
        String testName = "SuperarLimiteTest";
        Exception expected = null;
        try {
            new Productos(101);
        } catch (Exception e) {
            expected = e;
        }
        assertTest(testName, "Excepción", expected instanceof IndexOutOfBoundsException);
        assertTest(
                testName,
                "Mensaje",
                Objects.isNull(expected) ? false : expected.getMessage().equals("Ha superado el limite de productos"));
    }

    private static void superarCapacidadTest() {
        String testName = "SuperarCapacidadTest";
        Exception expected = null;
        try {
            int cantidad = 3;
            Productos productos = new Productos(cantidad);
            for (int i = 0; i <= cantidad; i++) {
                productos.agregar(i, testName, 10.56);
            }
        } catch (Exception e) {
            expected = e;
        }
        assertTest(testName, "Excepción", expected instanceof IndexOutOfBoundsException);
        assertTest(
                testName,
                "Mensaje",
                Objects.isNull(expected) ? false
                        : expected.getMessage().equals("Ha superado la capacidad de productos"));
    }

    private static void ordenamientoAscendentePorCodigoTest() {
        String testName = "OrdenamientoAscendentePorCodigoTest";
        int cantidad = 5;
        Productos productos = new Productos(cantidad);
        for (int i = cantidad; i > 0; i--) {
            productos.agregar(i * 10, Integer.toString(i), i * 3.5);
        }
        assertTest(testName, "Mayor Código", productos.getCodigo(cantidad - 1) == 50);
        assertTest(testName, "Nombre", productos.getNombre(cantidad - 1).equals("5"));
        assertTest(testName, "Precio", productos.getPrecio(cantidad - 1) == 17.5);
    }

    private static void ordenamientoDescendentePorCodigoTest() {
        String testName = "OrdenamientoDescendentePorCodigoTest";
        int cantidad = 5;
        Productos productos = new Productos(cantidad);
        for (int i = cantidad; i > 0; i--) {
            productos.agregar(i * 10, Integer.toString(i), i * 3.5);
        }
        productos.ordenar(Ordenamiento.DESC);
        assertTest(testName, "Mayor Código", productos.getCodigo(0) == 50);
        assertTest(testName, "Nombre", productos.getNombre(0).equals("5"));
        assertTest(testName, "Precio", productos.getPrecio(0) == 17.5);
    }

    private static void busquedaLineaPorCodigoTest() {
        String testName = "BusquedaLineaPorCodigoTest";
        int cantidad = 10;
        Productos productos = new Productos(cantidad);
        long codigoBuscado = 0;
        for (int i = 1; i <= cantidad; i++) {
            long codigo = (long) (Math.random() * cantidad + 1);
            productos.agregar(codigo, Integer.toString(i), (i + 1) * 3.5);
            if (i == 5) {
                codigoBuscado = codigo;
            }
        }
        assertTest(testName, productos.buscar(TipoBusqueda.LINEAL, codigoBuscado) > -1);
    }

    private static void busquedaBinariaPorCodigoTest() {
        String testName = "BusquedaBinariaPorCodigoTest";
        int cantidad = 10;
        Productos productos = new Productos(cantidad);
        long codigoBuscado = 0;
        for (int i = 1; i <= cantidad; i++) {
            long codigo = (long) (Math.random() * cantidad + 1);
            productos.agregar(codigo, Integer.toString(i), i * 3.5);
            if (i == 5) {
                codigoBuscado = codigo;
            }
        }
        assertTest(testName, productos.buscar(TipoBusqueda.BINARIA, codigoBuscado) > -1);
    }

    private static void busquedaCodigoNoEncontradoTest() {
        String testName = "BusquedaCodigoNoEncontradoTest";
        int cantidad = 5;
        Productos productos = new Productos(cantidad);
        for (int i = 1; i <= cantidad; i++) {
            long codigo = (long) (Math.random() * cantidad + 1);
            productos.agregar(codigo, Integer.toString(i), i * 3.5);
        }
        assertTest(testName, productos.buscar(TipoBusqueda.BINARIA, 50) == -1);
    }

    private static void obtenerProductoDeMayorPrecioTest() {
        String testName = "ObtenerProductoDeMayorPrecioTest";
        int cantidad = 10;
        Productos productos = new Productos(cantidad);
        double expectedPrecio = 0;
        for (int i = 1; i <= cantidad; i++) {
            double precio = Math.random() * 55 + 1;
            productos.agregar(i * 10, Integer.toString(i), precio);
            if (precio > expectedPrecio) {
                expectedPrecio = precio;
            }
        }
        int indice = productos.mayorPrecio();
        assertTest(testName, productos.getPrecio(indice) == expectedPrecio);
    }

    private static void cambiarOrdenAgregacionTest() {
        String testName = "CambiarOrdenAgregacionTest";
        int cantidad = 20;
        Productos productos = new Productos(cantidad);
        long mayorCodigo = Long.MIN_VALUE;
        for (int i = 1; i <= cantidad; i++) {
            long codigo = (long) (Math.random() * 100 + 1);
            productos.agregar(codigo, Integer.toString(i), Math.random() * 55 + 1);
            if (i == 10) {
                productos.ordenar(Ordenamiento.DESC);
            }
            if (codigo > mayorCodigo) {
                mayorCodigo = codigo;
            }
        }
        assertTest(testName, productos.getCodigo(0) == mayorCodigo);
    }

    private static void assertTest(String testName, String fieldName, boolean eval) {
        System.out.println(String.format("%s: %s %s", testName, fieldName, eval ? "OK" : "FAIL"));
    }

    private static void assertTest(String testName, boolean eval) {
        System.out.println(String.format("%s: %s", testName, eval ? "OK" : "FAIL"));
    }

}
