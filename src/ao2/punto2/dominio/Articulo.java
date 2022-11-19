package ao2.punto2.dominio;

public class Articulo {

    private static int stock = 0;

    private long codigo;
    private String nombre;
    private double precio;
    private String origen;

    public Articulo() {
        stock++;
    }

    public static int getStock() {
        return stock;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
