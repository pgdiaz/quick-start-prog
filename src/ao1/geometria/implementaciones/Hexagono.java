package ao1.geometria.implementaciones;

import ao1.geometria.interfaces.FiguraGeometrica;

public class Hexagono extends FiguraGeometrica {

    private double lado;

    public Hexagono(double x, double y) {
        super(x, y);
    }

    public Hexagono(double x, double y, double lado) {
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
        return 6 * this.lado;
    }

    @Override
    public double calcularSuperficie() {
        return Math.pow(this.lado, 2) * Math.sqrt(3) * (3d/2d);
    }

}
