package ao2.punto2.dominio;

public class Ropa extends Articulo {

    private String modelo;
    private Talle talle;

    public Ropa() {
        super();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = Talle.of(talle);
    }

}
