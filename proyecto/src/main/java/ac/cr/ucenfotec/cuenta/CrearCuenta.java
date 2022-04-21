package ac.cr.ucenfotec.cuenta;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class CrearCuenta implements JavaDelegate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution execution) {
        String cedula = (String) execution.getVariable("cedulaEstudiante");
        String nombre = (String) execution.getVariable("nombreEstudiante");
        String apellido1 = (String) execution.getVariable("apellido1Estudiante");
        String apellido2 = (String) execution.getVariable("apellido2Estudiante");
        String correoElectronico = (String) execution.getVariable("correoElectronicoEstudiante");

        System.out.println("Nombre: " + nombre + " " + apellido1 + " " + apellido2);

       try {
           jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ESTUDIANTE (id SERIAL, cedula varchar(255) unique, firstName varchar(255)," +
                   "lastName1 varchar(255), lastName2 varchar(255), email varchar(255), password varchar(255))");
           jdbcTemplate.update("Insert into ESTUDIANTE (cedula, firstName, LastName1, lastName2, email) " +
                   " values (?,?,?,?,?)", cedula, nombre, apellido1, apellido2, correoElectronico);
           execution.setVariable("creacionDeCuentaExito", true);
           System.out.println("Cuenta creada");
       }catch(Exception e){
           e.printStackTrace();
           System.err.println("e.getMessage(): " + e.getMessage());
           execution.setVariable("creacionDeCuentaExito", false);
       }

    }
}