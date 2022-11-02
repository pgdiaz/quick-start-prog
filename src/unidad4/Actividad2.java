package unidad4;

import java.util.Scanner;

public class Actividad2 {

    /*
     * Desarrolle un programa Java que lea los nombres de 10 personas y los imprima
     * en pantalla.
     */
    public static void main(String[] args) {
        int cantidad = 10;
        String[] arreglo = new String[cantidad];
        cargar(arreglo);
        imprimir(arreglo);
    }

    private static void cargar(String[] elementos) {
        Scanner terminal = new Scanner(System.in);
        String titulo = String.format(
                "\n------------ Cargar %d nombres ------------",
                elementos.length);
        System.out.println(titulo);
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("> Ingrese el nombre: ");
            elementos[i] = terminal.nextLine();
        }
        terminal.close();
    }

    private static void imprimir(String[] elementos) {
        System.out.println("\n------------ Nombres cargados ------------");
        for (String elemento : elementos) {
            System.out.println("    " + elemento);
        }
    }

}
