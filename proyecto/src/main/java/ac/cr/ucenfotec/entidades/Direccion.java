package ac.cr.ucenfotec.entidades;

public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;

    public Direccion(String provincia, String canton, String distrito, String direccion) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
    }
}
