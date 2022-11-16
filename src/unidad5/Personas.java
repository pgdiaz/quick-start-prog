package unidad5;

public class Personas {

    private long[] documentos;
    private String[] nombres;
    private int tope;
    private int puntero;

    public Personas(int cantidad) {
        this.documentos = new long[cantidad];
        this.nombres = new String[cantidad];
        this.tope = cantidad - 1;
        this.puntero = 0;
    }

    public void agregar(long dni, String nombre) {
        if (this.puntero == 0) {
            this.documentos[puntero] = dni;
            this.nombres[puntero] = nombre;
            this.puntero++;
        } else if (this.puntero > this.tope) {
            throw new IndexOutOfBoundsException("Ha superado la capacidad");
        } else {
            int indice = this.puntero;
            while (indice > 0 && dni < this.documentos[indice - 1]) {
                this.documentos[indice] = this.documentos[indice - 1];
                this.nombres[indice] = this.nombres[indice - 1];
                indice--;
            }
            this.documentos[indice] = dni;
            this.nombres[indice] = nombre;
            this.puntero++;
        }
    }

    public void mostrar(long dni) {
        int indice = buscar(dni);
        if (indice < 0) {
            System.out.println(String.format("No se encontró registro con el DNI %d", dni));
        } else {
            System.out.println("Resultado: " + this.nombres[indice]);
        }
    }

    private int buscar(long dni) {
        int central, bajo = 0, alto = this.puntero;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            if (dni == this.documentos[central]) {
                return central;
            } else if (dni < this.documentos[central]) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }

        return -1;
    }

}
