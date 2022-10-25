package ao1.creditos.dominio;

import java.time.LocalDate;

public class Cuota {

    private double capital;
    private double interes;
    private LocalDate fechaVencimiento;

    public Cuota(double capital, double interes) {
        this.capital = capital;
        this.interes = interes;
    }

    public double getCapital() {
        return capital;
    }

    public double getInteres() {
        return interes;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMontoTotal() {
        return this.capital + this.interes;
    }

}
