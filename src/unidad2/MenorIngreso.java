package unidad2;

/*
 * https://www.baeldung.com/java-scanner
 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 */
import java.util.Scanner;

/*
 * Desarrollar un programa Java que permita el ingreso de dos números enteros distintos desde el teclado,
 * y determine e imprima el menor. En caso de ingresar dos números iguales, mostrar un mensaje y finalizar el programa.
 * Realizar el diagrama de flujo correspondiente.
 */
public class MenorIngreso {

    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese un número entero: ");
        int num2 = scanner.nextInt();
        scanner.close();
        String resultado;
        if (num1 == num2) {
            resultado = "Los números ingresados deben ser distintos.";
        } else {
            resultado = String.format("El menor valor es %d", num1 < num2 ? num1 : num2);
        }
        System.out.println(resultado);
    }

}
