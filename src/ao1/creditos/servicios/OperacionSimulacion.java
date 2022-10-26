package ao1.creditos.servicios;

import java.util.Scanner;

import ao1.creditos.dominio.Credito;
import ao1.creditos.dominio.LineaCredito;
import ao1.creditos.excepciones.OperacionCrediticiaInvalidaExcepcion;

public class OperacionSimulacion implements Operacion {

    @Override
    public void ejecutar(Scanner terminal, Sesion sesion) {
        try {
            LineaCredito lineaCredito = sesion.getLineaCredito();
            Credito credito = new Credito(lineaCredito);
            System.out.print("\nIngrese el monto solicitado: ");
            double monto = terminal.nextDouble();
            System.out.print(String.format("Ingrese la cantidad de cuotas %s: ", lineaCredito.getCuotas()));
            int cuotas = terminal.nextInt();
            credito.simular(monto, cuotas);
            imprimir(credito);
        } catch (OperacionCrediticiaInvalidaExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    private static void imprimir(Credito credito) {
        Reportes.generar(credito);
        for (int i = 1; i <= credito.getCantidadCuotas(); i++) {
            Reportes.generar(credito.getCuota(i), i);
        }
    }

}
