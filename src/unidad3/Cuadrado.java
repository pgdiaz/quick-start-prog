package unidad3;

public class Cuadrado {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return this.lado * this.lado;
    }

}
