package ao1.geometria.implementaciones;

import ao1.geometria.interfaces.FiguraGeometrica;

public class Cuadrado extends FiguraGeometrica {

    private double lado;

    public Cuadrado(double x, double y) {
        super(x, y);
    }

    public Cuadrado(double x, double y, double lado) {
        super(x, y);
        this.setLado(lado);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado * 4;
    }

    @Override
    public double calcularSuperficie() {
        return Math.pow(this.lado, 2);
    }

}
