package ao2.punto2;

import java.util.Scanner;

import ao2.punto2.servicios.Operacion;
import ao2.punto2.servicios.Tienda;

public class Plataforma {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            Tienda tienda = new Tienda(terminal);
            Operacion operacion = tienda.obtener();
            while (!operacion.equals(Operacion.FINALIZAR)) {
                tienda.ejecutar(operacion);
                operacion = tienda.obtener();
            }
        } catch (Exception e) {
            System.out.println("\nHa ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

}
