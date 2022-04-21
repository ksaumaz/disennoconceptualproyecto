package ac.cr.ucenfotec.entidades;

import java.time.LocalDate;

public class Estudiante extends Persona {

    private String email;
    private String contrasenna;

    public Estudiante(String email, String contrasenna) {
        super();
        this.email = email;
        this.contrasenna = contrasenna;
    }

    public Estudiante(String cedula, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Genero genero, String correoElectronico, EstadoCivil estadoCivil, boolean cuentaBCR, Direccion direccion, CondicionLaboral condicionLaboral, String email, String contrasenna) {
        super(cedula, nombre, apellido1, apellido2, fechaNacimiento, genero, correoElectronico, estadoCivil, cuentaBCR, direccion, condicionLaboral);
        this.email = email;
        this.contrasenna = contrasenna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
}
