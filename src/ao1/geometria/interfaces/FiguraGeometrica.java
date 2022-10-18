package ao1.geometria.interfaces;

public abstract class FiguraGeometrica {

    private double x;
    private double y;

    public FiguraGeometrica(double x, double y) {
        this.setCoordenadaCentro(x, y);
    }

    public void setCoordenadaCentro(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcularDistanciaCentroAlOrigen() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public abstract double calcularPerimetro();

    public abstract double calcularSuperficie();

}
