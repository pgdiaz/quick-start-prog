package ao1.creditos.servicios;

import java.util.Scanner;

public class OperacionBalance implements Operacion {

    @Override
    public void ejecutar(Scanner terminal, Sesion sesion) {
        Reportes.generar(sesion.getLineaCredito());
    }

}
