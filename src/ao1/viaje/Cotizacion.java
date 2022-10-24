package ao1.viaje;

public class Cotizacion {

    private static final double COSTO_BASE = 4000.00;

    private double cantidadPasajeros;
    private double costoPorPasajero;
    private double costoTotal;

    public void setCantidadPasajeros(double cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
        this.costoPorPasajero = 0;
        this.costoTotal = 0;
        cotizar();
    }

    public double getCostoPorPasajero() {
        return costoPorPasajero;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    private void cotizar() {
        if (this.cantidadPasajeros < 30) {
            this.costoTotal = COSTO_BASE;
            this.costoPorPasajero = this.costoTotal / this.cantidadPasajeros;
        } else if (this.cantidadPasajeros < 50) {
            this.costoPorPasajero = 95.00;
        } else if (this.cantidadPasajeros < 100) {
            this.costoPorPasajero = 70.00;
        } else {
            this.costoPorPasajero = 65.00;
        }
        if (this.costoTotal == 0) {
            this.costoTotal = this.cantidadPasajeros * this.costoPorPasajero;
        }
    }

}
