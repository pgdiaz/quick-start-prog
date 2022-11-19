package ao2.punto3.servicios;

import java.util.Scanner;
import java.util.stream.Stream;

import ao2.punto3.dominio.Empleado;

public enum Operacion {

    FINALIZAR {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("Hasta pronto!");
        }
    },
    CARGAR {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("-------------------- Carga de empleados --------------------");
            for (int i = 0; i < empleados.length; i++) {
                Empleado empleado = new Empleado();
                System.out.print("> Ingrese el legajo: ");
                empleado.setLegajo(terminal.nextLong());
                terminal.nextLine();
                System.out.print("> Ingrese el nombre: ");
                empleado.setNombre(terminal.nextLine());
                System.out.print("> Ingrese las horas semanales: ");
                empleado.setHorasSemanales(terminal.nextInt());
                terminal.nextLine();
                System.out.print("> Ingrese el sueldo por hora: ");
                empleado.setSueldoHora(terminal.nextDouble());
                System.out.println("--------------------------------------------------------");
                empleados[i] = empleado;
            }
        }
    },
    SUELDO {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("-------------------- Sueldo semanal --------------------");
            System.out.print("> Ingrese el legajo del empleado: ");
            Empleado empleado = buscar(empleados, terminal.nextLong());
            System.out.println(String.format("Sueldo semanal: %.2f", empleado.Sueldo()));
        }
    },
    LIQUIDACION {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("-------------------- Gasto semana de la empresa --------------------");
            double gasto = 0;
            for (int i = 0; i < empleados.length; i++) {
                gasto += empleados[i].Sueldo();
            }
            System.out.println(String.format("Gasto semanal: %.2f", gasto));
        }
    },
    BUSCAR {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("-------------------- Buscar empleado --------------------");
            System.out.print("> Ingrese el legajo del empleado: ");
            Empleado empleado = buscar(empleados, terminal.nextLong());
            System.out.println("Legajo: " + empleado.getLegajo());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Horas semanales: " + empleado.getHorasSemanales());
            System.out.println("Sueldo por hora: " + empleado.getSueldoHora());
        }
    },
    MAYOR_HORAS {
        @Override
        public void ejecutar(Scanner terminal, Empleado[] empleados) {
            System.out.println("--------- Buscar empleado con mayor horas trabajadas ---------");
            int indice = -1;
            int mayorHoras = Integer.MIN_VALUE;
            for (int i = 0; i < empleados.length; i++) {
                if (empleados[i].getHorasSemanales() > mayorHoras) {
                    mayorHoras = empleados[i].getHorasSemanales();
                    indice = i;
                }
            }
            Empleado empleado = empleados[indice];
            System.out.println("Legajo: " + empleado.getLegajo());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Horas semanales: " + empleado.getHorasSemanales());
            System.out.println("Sueldo por hora: " + empleado.getSueldoHora());
        }
    };

    public abstract void ejecutar(Scanner terminal, Empleado[] empleados);

    public static Operacion of(int value) {
        return Stream.of(values())
                .filter(item -> item.ordinal() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("La operación no está definida"));
    }

    private static Empleado buscar(Empleado[] empleados, long legajo) {
        int indice = busquedaBinaria(empleados, legajo);
        if (indice < 0) {
            throw new IllegalArgumentException("No se encontró un empleado con el legajo ingresado");
        }

        return empleados[indice];
    }

    private static int busquedaBinaria(Empleado[] empleados, long legajo) {
        int central, bajo = 0, alto = empleados.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            if (legajo == empleados[central].getLegajo()) {
                return central;
            } else if (legajo < empleados[central].getLegajo()) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

}
