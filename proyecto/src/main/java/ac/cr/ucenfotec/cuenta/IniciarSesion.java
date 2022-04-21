package ac.cr.ucenfotec.cuenta;

import ac.cr.ucenfotec.entidades.Estudiante;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class IniciarSesion implements JavaDelegate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution execution) {
        String correoElectronico = (String) execution.getVariable("correoElectronicoEstudiante");
        String contrasenna = (String) execution.getVariable("contrasennaCuentaLogin");

        System.out.println("Correo: " + correoElectronico + " contraseña: " + contrasenna);

        try {
            String sql = "SELECT * FROM ESTUDIANTE WHERE email = ? AND password = ?";
            Estudiante estudiante = jdbcTemplate.queryForObject(sql, new Object[]{correoElectronico, contrasenna}, (rs, rowNum) ->
                    new Estudiante(
                            rs.getString("email"),
                            rs.getString("password")
                    ));

            if(estudiante != null){
                execution.setVariable("inicioSesionExitoso", true);
                System.out.println("Inicio de sesión exitoso");
            }else{
                execution.setVariable("inicioSesionExitoso", false);
                System.out.println("Inicio de sesión falló");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("e.getMessage(): " + e.getMessage());
            execution.setVariable("inicioSesionExitoso", false);
        }

    }
}