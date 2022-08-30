package unidad1;

/**
 * Escriba un programa en el que se defina la clase coordenada con el método
 * CalcularDistancia(); que calcule la distancia de un punto del plano al
 * origen; con las coordenadas x e y como dato. Desde una aplicación principal
 * definir un objeto de la clase coordenada y convocar al método
 * CalcularDistancia.
 */
public class Coordenada {

    private double _x;
    private double _y;

    public Coordenada(double x, double y) {
        this._x = x;
        this._y = y;
    }

    public double calcularDistancia() {
        return Math.sqrt(_x*_x+_y*_y);
    }

}
