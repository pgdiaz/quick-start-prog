package ao1.creditos.dominio;

import java.time.LocalDate;

import ao1.creditos.excepciones.OperacionCrediticiaInvalidaExcepcion;

public class Credito {

    private double capital;
    private double interes;
    private double tasaInteres;
    private int cantidadCuotas;
    private LocalDate fechaSolicitud;
    private LineaCredito lineaCredito;
    private boolean acreditado;

    public Credito(LineaCredito lineaCredito) {
        this.lineaCredito = lineaCredito;
        this.acreditado = false;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void simular(double monto, int cuotas) {
        if (monto > this.lineaCredito.getBalance()) {
            throw new OperacionCrediticiaInvalidaExcepcion("Balance insuficiente.");
        }
        this.tasaInteres = this.lineaCredito.getInteres(monto, cuotas);
        this.capital = monto;
        this.interes = monto * this.tasaInteres / 100.00;
        this.cantidadCuotas = cuotas;
        this.fechaSolicitud = LocalDate.now();
    }

    public void solicitar(double monto, int cuotas) {
        simular(monto, cuotas);
        this.lineaCredito.acreditar(this.capital);
        this.acreditado = true;
    }

    public double getMontoTotal() {
        return this.capital + this.interes;
    }

    public Cuota getCuota(int numeroCuota) {
        if (numeroCuota < 0) {
            throw new OperacionCrediticiaInvalidaExcepcion("Número de cuota inválido.");
        }
        if (this.cantidadCuotas < 0) {
            throw new OperacionCrediticiaInvalidaExcepcion("La cantidad de cuotas del crédito no está definida");
        }
        Cuota cuota = new Cuota(this.capital / this.cantidadCuotas, this.interes / cantidadCuotas);
        cuota.setFechaVencimiento(this.fechaSolicitud.plusDays(numeroCuota * 30));

        return cuota;
    }

    public boolean isAcreditado() {
        return acreditado;
    }

}
