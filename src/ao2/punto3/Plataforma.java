package ao2.punto3;

import java.util.Scanner;

import ao2.punto3.servicios.Empresa;
import ao2.punto3.servicios.Operacion;

public class Plataforma {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            Empresa empresa = new Empresa(terminal);
            Operacion operacion = empresa.obtener();
            while (!operacion.equals(Operacion.FINALIZAR)) {
                empresa.ejecutar(operacion);
                operacion = empresa.obtener();
            }
        } catch (Exception e) {
            System.out.println("\nHa ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

}
