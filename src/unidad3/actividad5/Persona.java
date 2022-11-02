package unidad3.actividad5;

public class Persona {

    private String nombre;
    private long dni;
    private int edad;

    public void asignarDatos(String nombre, long dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public void imprimirInformacion() {
        System.out.println("------------ Información Personal ------------");
        System.out.println(String.format("  Nombre: %s", this.nombre));
        System.out.println(String.format("  DNI: %d", this.dni));
        System.out.println(String.format("  Edad: %d", this.edad));
    }

}
