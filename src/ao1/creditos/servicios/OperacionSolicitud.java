package ao1.creditos.servicios;

import java.util.Scanner;

import ao1.creditos.dominio.Credito;
import ao1.creditos.dominio.LineaCredito;
import ao1.creditos.excepciones.OperacionCrediticiaInvalidaExcepcion;

public class OperacionSolicitud implements Operacion {

    @Override
    public void ejecutar(Scanner terminal, Sesion sesion) {
        try {
            LineaCredito lineaCredito = sesion.getLineaCredito();
            Credito credito = new Credito(lineaCredito);
            System.out.print("Ingrese el monto solicitado: ");
            double monto = terminal.nextDouble();
            System.out.print(String.format("Ingrese la cantidad de cuotas %s: ", lineaCredito.getCuotas()));
            int cuotas = terminal.nextInt();
            credito.solicitar(monto, cuotas);
            sesion.addCredito(credito);
            Reportes.generar(credito);
        } catch (OperacionCrediticiaInvalidaExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

}
