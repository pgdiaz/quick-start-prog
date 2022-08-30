package unidad1;

public class Automovil {

    private String marca;
    private int modelo;
    private String color;
    private double precio;

    public Automovil(String marca, int modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println(String.format("Precio: %.2f", this.precio));
    }

    public void establecerPrecio(double precio) {
        this.precio = precio;
    }

}
