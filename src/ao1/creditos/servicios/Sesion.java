package ao1.creditos.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ao1.creditos.dominio.Credito;
import ao1.creditos.dominio.LineaCredito;

public class Sesion {

    private long dni;
    private String usuario;
    private LineaCredito lineaCredito;
    private List<Credito> creditos;

    public Sesion(Scanner terminal) {
        System.out.println("> Inicio de sesión");
        System.out.print("\nIngrese su nombre y apellido: ");
        this.usuario = terminal.nextLine();
        System.out.print("Ingrese su DNI: ");
        this.dni = terminal.nextLong();
        this.lineaCredito = new LineaCredito(700500.00);
        this.creditos = new ArrayList<>();
    }

    public long getDni() {
        return dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public LineaCredito getLineaCredito() {
        return lineaCredito;
    }

    public void addCredito(Credito credito) {
        this.creditos.add(credito);
    }

    public List<Credito> getCreditos() {
        return creditos;
    }

}
