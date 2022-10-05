package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {

    private static final DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

    private double saldo;
    private String titular;
    private long numero;
    private String fechaMovimiento;
    private boolean habilitada;

    public Cuenta(String titular, long numeroCuenta, double saldo) {
        this.titular = titular;
        this.numero = numeroCuenta;
        this.saldo = saldo;
        this.habilitada = true;
        this.fechaMovimiento = formateador.format(LocalDateTime.now());
    }

    public void depositar(double importe) {
        if (importe <= 0) {
            System.out.println("El importe debe ser superior a 0 (cero)");
        } else {
            this.saldo += importe;
            this.fechaMovimiento = formateador.format(LocalDateTime.now());
        }
    }

    public boolean extraer(double importe) {
        if (this.saldo == 0 || this.saldo < importe) {
            return false;
        }
        if (importe < 0) {
            System.out.println("El importe debe ser superior a 0 (cero)");
        } else {
            this.saldo -= importe;
            this.fechaMovimiento = formateador.format(LocalDateTime.now());
        }

        return true;
    }

    public void bloquear() {
        if (this.habilitada) {
            this.habilitada = false;
        } else {
            System.out.println("La cuenta ya está bloqueada");
        }
    }

    public void desbloquear() {
        if (this.habilitada) {
            System.out.println("La cuenta ya está habilitada");
        } else {
            this.habilitada = true;
        }
    }

    public void mostrar() {
        System.out.println("Datos de la cuenta");
        System.out.println("------------------------------");
        System.out.println("Titular: " + this.titular);
        System.out.println("Numero de cuenta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Estado: " + (this.habilitada ? "Habilitada" : "Bloqueada"));
        System.out.println("Ultimo movimiento: " + this.fechaMovimiento);
    }

}
