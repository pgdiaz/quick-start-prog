package unidad3.autoevaluacion;

public class Articulo {

    private long codigo;
    private String nombre;
    private double precio;

    public Articulo(long codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void imprimir() {
        System.out.println("------------ Información Articulo ------------");
        System.out.println(String.format("  Código: %d", this.codigo));
        System.out.println(String.format("  Nombre: %s", this.nombre));
        System.out.println(String.format("  Precio: %.2f", this.precio));
    }

}
