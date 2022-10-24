package ao1.financiera;

public class Financiacion {

    public static void main(String[] args) {
        System.out.println("\n---------------------------------");
        System.out.println("|           Financiación           |");
        System.out.println("----------------------------------");
        double monto = 5.00;
        double total = 0.00;
        for (int cuota = 1; cuota <= 20; cuota++) {
            monto *= 2;
            total += monto;
            System.out.println(String.format("El monto a pagar de la cuota %d es $ %.2f", cuota, monto));
        }
        System.out.println(String.format("El monto total de la financiación a 20 meses es $ %.2f", total));
    }

}
