package unidad3;

public class Relojero {

    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        System.out.println("Hora por defecto: " + reloj.obtenerHora());
        reloj.cambiarHora(10);
        System.out.println("Actualización de hora: " + reloj.obtenerHora());
        reloj.cambiarHora(12, 30, 55);
        System.out.println("Actualización completa: " + reloj.obtenerHora());
    }

}
