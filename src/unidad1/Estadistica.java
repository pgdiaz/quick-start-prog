package unidad1;

/**
 * Desarrollar un programa en Java, que desde el método main( ) invoque a un
 * método que permita conocer el porcentaje de personas solteras, teniendo como
 * dato la cantidad de personas solteras y el total de personas.
 */
public class Estadistica {

    public static void main(String[] args) throws Exception {
        double cantidadPersonas = 500;
        double cantidadPersonasSolteras = 200;
        System.out.println(String.format(
                "El porcentaje de personas solteras es: %.2f",
                calcularPorcentaje(cantidadPersonas, cantidadPersonasSolteras)));
    }

    private static double calcularPorcentaje(double total, double parcial) {
        return parcial * 100 / total;
    }

}
