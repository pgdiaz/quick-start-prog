package ao1.creditos.servicios;

import java.util.Scanner;

public class OperacionInformeCrediticio implements Operacion {

    @Override
    public void ejecutar(Scanner terminal, Sesion sesion) {
        Reportes.generar(sesion.getLineaCredito());
        sesion.getCreditos().forEach(credito -> {
            Reportes.generar(credito);
            for (int i = 1; i <= credito.getCantidadCuotas(); i++) {
                Reportes.generar(credito.getCuota(i), i);
            }
        });
    }

}
