package ac.cr.ucenfotec.entidades;

import java.time.LocalDate;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private String correoElectronico;
    private EstadoCivil estadoCivil;
    private boolean cuentaBCR;
    private Direccion direccion;
    private CondicionLaboral condicionLaboral;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Genero genero, String correoElectronico, EstadoCivil estadoCivil, boolean cuentaBCR, Direccion direccion, CondicionLaboral condicionLaboral) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correoElectronico = correoElectronico;
        this.estadoCivil = estadoCivil;
        this.cuentaBCR = cuentaBCR;
        this.direccion = direccion;
        this.condicionLaboral = condicionLaboral;
    }
}
