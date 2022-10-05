package unidad3;

public class Reloj {

    private int horas;
    private int minutos;
    private int segundos;

    public void cambiarHora(int horas) {
        this.horas = horas;
        this.minutos = 0;
        this.segundos = 0;
    }

    public void cambiarHora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String obtenerHora() {
        return String.format("%s:%s:%s", horas, minutos, segundos);
    }

}
