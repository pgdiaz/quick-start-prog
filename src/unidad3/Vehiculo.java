package unidad3;

/*
 * Crear Una Clase Vehiculo con las siguientes propiedades: Marca, Modelo, Color y Año de fabricación
 * y los siguientes métodos: mostrarVehículo(), cargarVehiculo().
 * Crear Constructores de la clase con argumentos y sin argumentos.
 */
public class Vehiculo {

    private String marca;
    private int modelo;
    private String color;
    private int fabricado;

    public Vehiculo() {
        this.marca = "";
        this.modelo = 0;
        this.color = "";
        this.fabricado = 0;
    }

    public Vehiculo(String marca, int modelo, String color, int fabricado) {
        this.cargarVehiculo(marca, modelo, color, fabricado);
    }

    public void mostrarVehículo() {
        System.out.println("-------- Datos del vehiculo --------");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Color: " + this.color);
        System.out.println("Fabricado: " + this.fabricado);
    }

    public void cargarVehiculo(String marca, int modelo, String color, int fabricado) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fabricado = fabricado;
    }

}
