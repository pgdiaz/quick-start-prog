package ao1.creditos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import ao1.creditos.servicios.Opcion;
import ao1.creditos.servicios.Operacion;
import ao1.creditos.servicios.Operador;
import ao1.creditos.servicios.Sesion;

public class Plataforma {

    private static final Logger logger = Logger.getLogger(Plataforma.class.getName());

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        Opcion opcion;
        System.out.println("\n-------------------- Plataforma de crédito --------------------");
        try {
            Sesion sesion = new Sesion(terminal);
            do {
                terminal.nextLine();
                System.out.print("\nPresione ENTER para continuar");
                terminal.nextLine();
                opcion = Operador.getOpcion(terminal);
                if (opcion != Opcion.FINALIZAR) {
                    Operacion operacion = Operador.getOperacion(opcion);
                    operacion.ejecutar(terminal, sesion);
                }
            } while (opcion != Opcion.FINALIZAR);
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado!");
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            terminal.close();
        }
    }

}
