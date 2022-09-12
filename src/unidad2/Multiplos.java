package unidad2;

import commons.Impresora;

public class Multiplos {

    public static void main(String[] args) {
        Impresora.imprimir("Determinar los múltiplos mediante el ciclo for");
        int suma = 0;
        int numero;
        for (numero = 1; numero <= 100; numero++) {
            if (esMultiploDe5(numero)) {
                suma += numero;
                Impresora.imprimir("Múltiplo: %d", numero);
            }
        }
        Impresora.imprimir("La suma de los múltiplos de 5 es %d", suma);
        Impresora.imprimir("Determinar los múltiplos mediante el ciclo do-while");
        suma = 0;
        numero = 1;
        do {
            if (esMultiploDe5(numero)) {
                suma += numero;
                Impresora.imprimir("Múltiplo: %d", numero);
            }
            numero++;
        } while (numero <= 100);
        Impresora.imprimir("La suma de los múltiplos de 5 es %d", suma);
    }

    private static boolean esMultiploDe5(int valor) {
        return valor % 5 == 0;
    }

}
