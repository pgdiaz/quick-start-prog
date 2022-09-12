package unidad2;

import java.util.Scanner;

/*
 * Desarrollar un programa Java que permita el ingreso de tres notas correspondientes a evaluaciones de un alumno
 * y determine e imprima el promedio de las mismas. Realizar el diagrama de flujo correspondiente.
 */
public class PromedioNotas {

    public static void main(String[] args) {
        System.out.println("Registro de notas de un alumno. Rango de [0, 100] ");
        Scanner scanner = new Scanner(System.in);
        int promedio = 0;
        for (int i = 1; i <= 3; i++) {
            System.out.println(String.format("Ingrese la %dº nota: ", i));
            promedio += scanner.nextInt();
        }
        scanner.close();
        System.out.println(String.format("El promedio del alumno es %d", promedio /= 3));
    }

}
