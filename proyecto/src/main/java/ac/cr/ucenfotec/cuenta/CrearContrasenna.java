package ac.cr.ucenfotec.cuenta;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class CrearContrasenna implements JavaDelegate {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution execution) {
        String cedula = (String) execution.getVariable("cedulaEstudiante");
        String contrasenna1 = (String) execution.getVariable("contrasennaCuenta1");
        String contrasenna2 = (String) execution.getVariable("contrasennaCuenta2");

        execution.setVariable("contrasennaValida", contrasenna1.equals(contrasenna2));

        if(contrasenna1.equals(contrasenna2)){
           try {
               String updateQuery = "UPDATE ESTUDIANTE set password = ? where cedula = ?";
               jdbcTemplate.update(updateQuery, contrasenna1, cedula);
           }catch (Exception e){
               execution.setVariable("contrasennaValida", false);
               e.printStackTrace();
               System.err.println("e.getMessage(): " + e.getMessage());
           }
        }

    }
}
