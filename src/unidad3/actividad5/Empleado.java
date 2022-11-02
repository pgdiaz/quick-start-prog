package unidad3.actividad5;

public class Empleado extends Persona {

    private long legajo;
    private String cargo;

    public void asignarDatos(String nombre, long dni, int edad, long legajo, String cargo) {
        super.asignarDatos(nombre, dni, edad);
        this.legajo = legajo;
        this.cargo = cargo;
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("------------ Información Empleado ------------");
        System.out.println(String.format("  Legajo: %d", this.legajo));
        System.out.println(String.format("  Cargo: %s", this.cargo));
    }

}
