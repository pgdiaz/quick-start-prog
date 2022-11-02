package unidad3.autoevaluacion;

public class Ropa extends Articulo {

    private enum Talle {
        S, M, L, XL, XXL;
    }

    private Talle talle;
    private String modelo;

    public Ropa(long codigo, String nombre, double precio, String talle, String modelo) {
        super(codigo, nombre, precio);
        this.talle = Talle.valueOf(talle.toUpperCase());
        this.modelo = modelo;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("------------ Información Ropa ------------");
        System.out.println(String.format("  Talle: %s", this.talle.name()));
        System.out.println(String.format("  Modelo: %s", this.modelo));
    }

}
