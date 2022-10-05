package unidad1;

public class App {

    public static void main(String[] args) throws Exception {
        Automovil miAuto = new Automovil("Fiat", 2018, "rojo");
        miAuto.mostrarInfo();
        miAuto.establecerPrecio(800000);
        miAuto.mostrarInfo();
    }

}
