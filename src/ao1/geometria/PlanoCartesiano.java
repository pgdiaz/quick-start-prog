package ao1.geometria;

import java.util.Scanner;

import ao1.geometria.implementaciones.Circulo;
import ao1.geometria.implementaciones.Cuadrado;
import ao1.geometria.implementaciones.Hexagono;
import ao1.geometria.interfaces.FiguraGeometrica;

public class PlanoCartesiano {

    class Coordenada {
        private double x;
        private double y;

        Coordenada(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getAbscisa() {
            return this.x;
        }

        double getOrdenada() {
            return this.y;
        }
    }

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = terminal.nextInt();
            ejecutarOpcion(terminal, opcion);
        } while (opcion != 0);
        terminal.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n------------------------------");
        System.out.println("|       Menu de Opciones       |");
        System.out.println("------------------------------");
        System.out.println("    1) Cuadrado");
        System.out.println("    2) Círculo");
        System.out.println("    3) Hexágono");
        System.out.print("> Seleccione una figura geométrica o 0 (cero) para finalizar: ");
    }

    private static void ejecutarOpcion(Scanner terminal, int opcion) {
        switch (opcion) {
            case 0:
                System.out.println("Adios!");
                break;
            case 1:
                contruirCuadrado(terminal);
                break;
            case 2:
                contruirCirculo(terminal);
                break;
            case 3:
                contruirHexagono(terminal);
                break;
            default:
                System.out.println("Selección inválida!");
        }
    }

    private static void contruirCuadrado(Scanner terminal) {
        System.out.println("> Ingrese los siguientes valores para contruir el cuadrado");
        Coordenada coordenada = obtenerCoordenadas(terminal);
        System.out.print("  Lado: ");
        Cuadrado cuadrado = new Cuadrado(coordenada.getAbscisa(), coordenada.getOrdenada(), terminal.nextDouble());
        imprimirCalculos(cuadrado);
    }

    private static void contruirCirculo(Scanner terminal) {
        System.out.println("> Ingrese los siguientes valores para contruir el círculo");
        Coordenada coordenada = obtenerCoordenadas(terminal);
        System.out.print("  Radio: ");
        Circulo circulo = new Circulo(coordenada.getAbscisa(), coordenada.getOrdenada(), terminal.nextDouble());
        imprimirCalculos(circulo);
    }

    private static void contruirHexagono(Scanner terminal) {
        System.out.println("> Ingrese los siguientes valores para contruir el cuadrado");
        Coordenada coordenada = obtenerCoordenadas(terminal);
        System.out.print("  Lado: ");
        Hexagono hexagono = new Hexagono(coordenada.getAbscisa(), coordenada.getOrdenada(), terminal.nextDouble());
        imprimirCalculos(hexagono);
    }

    private static Coordenada obtenerCoordenadas(Scanner terminal) {
        System.out.print("  Abscisa (x): ");
        double x = terminal.nextDouble();
        System.out.print("  Ordenada (y): ");
        double y = terminal.nextDouble();
        PlanoCartesiano plano = new PlanoCartesiano();

        return plano.new Coordenada(x, y);
    }

    private static void imprimirCalculos(FiguraGeometrica figura) {
        System.out.println("########### Cálculos ###########");
        System.out.println(String.format(
                "Distancia del centro al origen: %.2f",
                figura.calcularDistanciaCentroAlOrigen()));
        System.out.println(String.format("Perímetro: %.2f", figura.calcularPerimetro()));
        System.out.println(String.format("Superficie: %.2f", figura.calcularSuperficie()));
    }

}
