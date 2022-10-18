package ao1.geometria.implementaciones;

import ao1.geometria.interfaces.FiguraGeometrica;

public class Circulo extends FiguraGeometrica {

    private double radio;

    public Circulo(double x, double y) {
        super(x, y);
    }

    public Circulo(double x, double y, double radio) {
        super(x, y);
        this.setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public double calcularSuperficie() {
        return Math.PI * Math.pow(radio, 2);
    }

}
