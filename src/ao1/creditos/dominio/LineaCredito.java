package ao1.creditos.dominio;

import ao1.creditos.excepciones.OperacionCrediticiaInvalidaExcepcion;

public class LineaCredito {

    private double monto;
    private double balance;
    private String cuotas;

    public LineaCredito(double monto) {
        this.monto = monto;
        this.balance = monto;
        this.cuotas = "[1, 3, 6, 9, 12, 18]";
    }

    public double getMonto() {
        return monto;
    }

    public double getBalance() {
        return balance;
    }

    public String getCuotas() {
        return cuotas;
    }

    public void acreditar(double monto) {
        this.balance -= monto;
    }

    public double getInteres(double montoCredito, int cuotas) {
        if (cuotas > 6 && montoCredito < (0.5 * this.balance)) {
            throw new OperacionCrediticiaInvalidaExcepcion(
                    "No se admite la cantidad de cuotas para el monto seleccionado.");
        }

        double interes;
        switch (cuotas) {
            case 1:
                interes = 60.00;
                break;
            case 3:
            case 6:
                interes = 80.00;
                break;
            case 9:
            case 12:
                interes = 100.00;
                break;
            case 18:
                interes = 120.00;
                break;
            default:
                throw new OperacionCrediticiaInvalidaExcepcion("La cantidad de cuotas no se admite.");
        }

        return interes;
    }

}
