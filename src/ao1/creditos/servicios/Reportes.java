package ao1.creditos.servicios;

import java.time.format.DateTimeFormatter;

import ao1.creditos.dominio.Credito;
import ao1.creditos.dominio.Cuota;
import ao1.creditos.dominio.LineaCredito;

public class Reportes {

    private static final DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Reportes() {
    }

    public static void generar(LineaCredito lineaCredito) {
        System.out.println("------------------------------------------------------------");
        System.out.println(String.format("Límite de la línea de crédito: $ %.2f", lineaCredito.getMonto()));
        System.out.println(String.format("Monto disponible para créditos: $ %.2f", lineaCredito.getBalance()));
        System.out.println("------------------------------------------------------------");
    }

    public static void generar(Credito credito) {
        System.out.println("------------------------------------------------------------");
        System.out.println(String.format(
                "Crédito de %.2f en %d cuotas.",
                credito.getMontoTotal(),
                credito.getCantidadCuotas()));
        System.out.println(String.format("La tasa de interés aplicada es del %.2f %%", credito.getTasaInteres()));
        System.out.println(String.format("Acreditado: %s", credito.isAcreditado() ? "Si" : "No"));
        System.out.println("------------------------------------------------------------");
    }

    public static void generar(Cuota cuota, int numeroCuota) {
        System.out.println(String.format("--------------------------Cuota %d--------------------------", numeroCuota));
        System.out.println(String.format("Monto total: $ %.2f", cuota.getMontoTotal()));
        System.out.println(String.format("Capital: $ %.2f", cuota.getCapital()));
        System.out.println(String.format("Interés: $ %.2f", cuota.getInteres()));
        System.out.println(String.format("Vencimiento: %s", formateador.format(cuota.getFechaVencimiento())));
    }

}
