public class Propietario extends Persona {
    // Atrubutos
    private int idPropietario;

    // Metodo del Padre y del Hijo
    public Propietario(int documento, String nombre, String apellido, int edad, int idPropietario) {
        super(documento, nombre, apellido, edad);
        this.idPropietario = idPropietario;
    }

    // Metodo
    public Propietario() {
    }

    // Set y Get
    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
