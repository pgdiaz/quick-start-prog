package ao1.carrito;

public class Articulo {

    private double precio;
    private double descuento;
    private double costo;

    public Articulo(double precio) {
        this.precio = precio;
        this.costo = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
        this.costo = this.precio - descuento;
    }

    public double getCosto() {
        return costo;
    }

}
