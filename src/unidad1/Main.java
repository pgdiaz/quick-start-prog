package unidad1;

public class Main {

    public static void main(String[] args) throws Exception {
        Coordenada p1 = new Coordenada(25.5, 12.9);
        Coordenada p2 = new Coordenada(3, 8);
        System.out.println("La distancia al origen del punto 1 es " + p1.calcularDistancia());
        System.out.println("La distancia al origen del punto 2 es " + p2.calcularDistancia());
    }

}
