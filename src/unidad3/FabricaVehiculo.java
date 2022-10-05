package unidad3;

/*
 * Crear dos objetos de la clase auto.
 * Inicializar sus datos utilizando los constructores programados.
 * Modularizar el Proyecto para que quede mejor organizado dividirlo en unidades funcionales separadas.
 */
public class FabricaVehiculo {

    public static void main(String[] args) {
        Vehiculo auto = new Vehiculo("Fiat", 2015, "Blanco", 2014);
        auto.mostrarVehículo();
        Vehiculo camioneta = new Vehiculo();
        camioneta.cargarVehiculo("Toyota", 2019, "Gris", 2018);
        camioneta.mostrarVehículo();
    }

}
