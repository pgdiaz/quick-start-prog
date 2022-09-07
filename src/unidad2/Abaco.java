package unidad2;

/*
 * Clase 06/09/2022
 * Escriba un método dentro de un programa en java que utilice una estructura repetitiva
 * para calcular mediante un procedimiento el cociente y el residuo de 2 números enteros
 * positivos ingresados por teclado. El cociente se calcula como restas sucesivas.
 * Utilizar dos estructuras repetitivas.
 */
public class Abaco {

    public static void main(String[] args) {
        chequear(1, calcularResiduo(10, 3));
        chequear(0, calcularResiduo(25, 5));
        chequear(2, calcularResiduo(20, 6));
    }

    private static void chequear(int valorEsperado, int valorRetornado) {
        if (valorEsperado != valorRetornado) {
            System.out.println(String.format(
                    "Resultado inválido: Se esperaba %d pero se obtuvo %d",
                    valorEsperado,
                    valorRetornado));
        } else {
            System.out.println("Resultado válido!");
        }
    }

    private static int calcularResiduo(int dividendo, int divisor) {
        if (dividendo < 0) {
            System.out.println("El divisor debe ser mayor o igual a cero");
        }
        if (divisor <= 0) {
            System.out.println("El dividendo debe ser mayor a cero");
        }
        int residuo = dividendo;
        int cociente = 0;
        do {
            residuo -= divisor;
            cociente++;
        } while (residuo >= divisor);
        System.out.println(String.format(
                "El cociente es %d y el residuo es %d al dividir %d en %d",
                cociente,
                residuo,
                dividendo,
                divisor));

        return residuo;
    }

}
