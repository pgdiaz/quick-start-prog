package unidad5;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Productos {

    public enum Ordenamiento {
        DESC, ASC;

        static Ordenamiento of(String code) {
            if (code.toUpperCase().equals("D")) {
                return DESC;
            }
            if (code.toUpperCase().equals("A")) {
                return ASC;
            }

            throw new InvalidParameterException("El tipo de ordenamiento es inválido");
        }
    }

    public enum TipoBusqueda {
        LINEAL, BINARIA;

        static TipoBusqueda of(String code) {
            if (code.toUpperCase().equals("L")) {
                return LINEAL;
            }
            if (code.toUpperCase().equals("B")) {
                return BINARIA;
            }

            throw new InvalidParameterException("El tipo de búsqueda es inválido");
        }
    }

    private static final int LIMITE = 100;

    private long[] codigos;
    private String[] nombres;
    private double[] precios;
    private int tope;
    private int puntero;
    private Ordenamiento orden;

    public Productos(int cantidad) {
        if (cantidad > LIMITE) {
            throw new IndexOutOfBoundsException("Ha superado el limite de productos");
        }
        this.codigos = new long[cantidad];
        this.nombres = new String[cantidad];
        this.precios = new double[cantidad];
        this.tope = cantidad - 1;
        this.puntero = -1;
        this.orden = Ordenamiento.ASC;
    }

    public long getCodigo(int indice) {
        validar(indice);

        return this.codigos[indice];
    }

    public String getNombre(int indice) {
        validar(indice);

        return this.nombres[indice];
    }

    public double getPrecio(int indice) {
        validar(indice);

        return this.precios[indice];
    }

    public int getCantidad() {
        return this.codigos.length;
    }

    public void agregar(long codigo, String nombre, double precio) {
        this.puntero++;
        if (this.puntero == 0) {
            this.codigos[this.puntero] = codigo;
            this.nombres[this.puntero] = nombre;
            this.precios[this.puntero] = precio;
        } else if (this.puntero > this.tope) {
            throw new IndexOutOfBoundsException("Ha superado la capacidad de productos");
        } else {
            int indice = this.puntero;
            while (indice > 0 && (this.orden == Ordenamiento.ASC ? codigo < this.codigos[indice - 1]
                    : codigo > this.codigos[indice - 1])) {
                this.codigos[indice] = this.codigos[indice - 1];
                this.nombres[indice] = this.nombres[indice - 1];
                this.precios[indice] = this.precios[indice - 1];
                indice--;
            }
            this.codigos[indice] = codigo;
            this.nombres[indice] = nombre;
            this.precios[indice] = precio;
        }
    }

    public void ordenar(Ordenamiento ordenamiento) {
        if (ordenamiento != this.orden) {
            int medio = (this.puntero + 1) / 2;
            for (int i = 0; i < medio; i++) {
                long codigo = this.codigos[i];
                this.codigos[i] = this.codigos[this.puntero];
                this.codigos[this.puntero] = codigo;
                String nombre = this.nombres[i];
                this.nombres[i] = this.nombres[this.puntero];
                this.nombres[this.puntero] = nombre;
                double precio = this.precios[i];
                this.precios[i] = this.precios[this.puntero];
                this.precios[this.puntero] = precio;
            }
            this.orden = ordenamiento;
        }
    }

    public int buscar(TipoBusqueda tipo, long codigo) {
        return tipo == TipoBusqueda.BINARIA ? busquedaBinaria(codigo) : busquedaLineal(codigo);
    }

    public int mayorPrecio() {
        int indice = -1;
        double mayorPrecio = Double.MIN_VALUE;
        for (int i = 0; i <= this.tope; i++) {
            if (this.precios[i] > mayorPrecio) {
                mayorPrecio = this.precios[i];
                indice = i;
            }
        }

        return indice;
    }

    public void imprimir() {
        System.out.println("Códigos: " + Arrays.toString(this.codigos));
        System.out.println("Nombres: " + Arrays.toString(this.nombres));
        System.out.println("Precios: " + Arrays.toString(this.precios));
    }

    public void imprimir( int indice) {
        System.out.println(String.format("Código: %d", this.codigos[indice]));
        System.out.println(String.format("Nombre: %s", this.nombres[indice]));
        System.out.println(String.format("Precio: %.2f", this.precios[indice]));
    }

    private int busquedaBinaria(long codigo) {
        int central, bajo = 0, alto = this.puntero;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            if (codigo == this.codigos[central]) {
                return central;
            } else if (codigo < this.codigos[central]) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

    private int busquedaLineal(long codigo) {
        for (int i = 0; i < this.codigos.length; i++) {
            if (this.codigos[i] == codigo) {
                return i;
            }
        }

        return -1;
    }

    private void validar(int indice) {
        if (indice < 0 || indice > this.puntero) {
            throw new InvalidParameterException("El índice se encuentra fuera del rango admisible");
        }
    }

}
