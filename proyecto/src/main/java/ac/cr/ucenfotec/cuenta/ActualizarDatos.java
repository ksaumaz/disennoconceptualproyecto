package ac.cr.ucenfotec.cuenta;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
public class ActualizarDatos implements JavaDelegate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution execution) throws ParseException {
        String cedula = (String) execution.getVariable("cedulaEstudiante");
        String estadoCivil = (String) execution.getVariable("estadoCivilEstudiante");
        String fechaNacimiento = (String) execution.getVariable("fechaEstudiante");
        String provincia = (String) execution.getVariable("provinciaEstudiante");
        String canton = (String) execution.getVariable("cantonEstudiante");
        String distrito = (String) execution.getVariable("distritoEstudiante");
        String telefono = (String) execution.getVariable("telefonoEstudiante");
        String direccion = (String) execution.getVariable("direccionEstudiante");

        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);

        try {
            String updateQuery = "UPDATE ESTUDIANTE set dateBirth = ?, status = ?, provincia = ?," +
                    "canton = ?, distrito = ?, telephone = ?, address = ? where cedula = ?";

            jdbcTemplate.update(updateQuery, date, estadoCivil, provincia, canton, distrito, telefono, direccion, cedula);

            System.out.println("Datos del estudiante completados");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("e.getMessage(): " + e.getMessage());
        }


    }
}
