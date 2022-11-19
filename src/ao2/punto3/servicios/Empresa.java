package ao2.punto3.servicios;

import java.util.Scanner;

import ao2.punto3.dominio.Empleado;

public class Empresa {

    private static final int MAX_REINTENTOS = 3;

    private Scanner terminal;
    private Empleado[] empleados;

    public Empresa(Scanner terminal) {
        this.terminal = terminal;
        System.out.print("> Ingrese la cantidad de empelados: ");
        int stack = terminal.nextInt();
        this.empleados = new Empleado[stack];
    }

    public Operacion obtener() {
        terminal.nextLine();
        System.out.print("\n> Presione enter para continuar");
        terminal.nextLine();
        System.out.println("-------------------- Operaciones --------------------");
        System.out.println("    1) Cargar empleados");
        System.out.println("    2) Calcular sueldo semanal de un empleado");
        System.out.println("    3) Calcular liquidación semanal");
        System.out.println("    4) Buscar empleado");
        System.out.println("    5) Buscar empleado con mayor carga horaria");
        System.out.println("    0) Salir del programa");
        System.out.print("\n> Selecciones una opción: ");

        return Operacion.of(this.terminal.nextInt());
    }

    public void ejecutar(Operacion operacion) {
        boolean reintentar = false;
        int reintentos = 0;
        do {
            try {
                operacion.ejecutar(terminal, empleados);
                reintentar = false;
            } catch (IllegalArgumentException input) {
                reintentar = true;
                System.out.println("ERROR: " + input.getMessage());
            } catch (IndexOutOfBoundsException limit) {
                reintentar = false;
                System.out.println("ERROR: " + limit.getMessage());
            }
        } while (reintentar && reintentos < MAX_REINTENTOS);
    }

}
