package ac.cr.ucenfotec.entidades;

public class Materia {
    private Estudiante estudiante;
    private String nombreMateria;
    private String tipoMateria;
    private Double montoProtoforma;
    private Double montoSolicitado;

    public Materia() {
    }

    public Materia(Estudiante estudiante, String nombreMateria, String tipoMateria, Double montoProtoforma, Double montoSolicitado) {
        this.estudiante = estudiante;
        this.nombreMateria = nombreMateria;
        this.tipoMateria = tipoMateria;
        this.montoProtoforma = montoProtoforma;
        this.montoSolicitado = montoSolicitado;
    }
}
