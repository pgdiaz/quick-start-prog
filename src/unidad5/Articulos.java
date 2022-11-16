package unidad5;

public class Articulos {

    private String[] descripciones;
    private double[] precios;
    private int tope;
    private int puntero;

    public Articulos(int cantidad) {
        this.descripciones = new String[cantidad];
        this.precios = new double[cantidad];
        this.tope = cantidad - 1;
        this.puntero = 0;
    }

    public void agregar(String descripcion, double precio) {
        if (this.puntero == 0) {
            this.descripciones[puntero] = descripcion;
            this.precios[puntero] = precio;
            this.puntero++;
        } else if (this.puntero > this.tope) {
            throw new IndexOutOfBoundsException("Ha superado la capacidad de articulos");
        } else {
            int indice = this.puntero;
            while (indice > 0 && precio < this.precios[indice - 1]) {
                this.precios[indice] = this.precios[indice - 1];
                this.descripciones[indice] = this.descripciones[indice - 1];
                indice--;
            }
            this.precios[indice] = precio;
            this.descripciones[indice] = descripcion;
            this.puntero++;
        }
    }

    public void imprimir() {
        System.out.println("----------- Informe de artículos -----------");
        System.out.println(String.format("Cantidad: %d", this.precios.length));
        for (int i = 0; i < this.puntero; i++) {
            System.out.println(String.format(
                    "Artículo %s de precio $ %.2f",
                    this.descripciones[i],
                    this.precios[i]));
        }
    }

}
