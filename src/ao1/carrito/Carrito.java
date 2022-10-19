package ao1.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private static final double PRIMER_DESCUENTO = 0.1;
    private static final double SEGUNDO_DESCUENTO = 0.12;
    private static final double TERCER_DESCUENTO = 0.15;

    private List<Articulo> articulos;

    public Carrito() {
        this.articulos = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo) {
        articulo.setDescuento(calcularDescuento(articulo.getPrecio()));
        this.articulos.add(articulo);
    }

    public List<Articulo> finalizarCompra() {
        return this.articulos;
    }

    private double calcularDescuento(double precio) {
        double descuento = SEGUNDO_DESCUENTO;
        if (precio >= 200) {
            descuento = TERCER_DESCUENTO;
        } else if (precio <= 100) {
            descuento = PRIMER_DESCUENTO;
        }

        return precio * descuento;
    }

}
