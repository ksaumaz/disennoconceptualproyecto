package ac.cr.ucenfotec.materia;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class CrearMateria implements JavaDelegate {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution execution) {

        String cedula = (String) execution.getVariable("cedulaEstudiante");
        String nombreMateria = (String) execution.getVariable("nombreMateria");
        String tipoMateria = (String) execution.getVariable("tipoMateria");
        String montoProtoforma = (String) execution.getVariable("montoProtoformaMateria");
        String montoSolicitado = (String) execution.getVariable("montoSolicitudMateria");

        System.out.println("Materia: " + nombreMateria + " " + tipoMateria);

        try {

            jdbcTemplate.execute("DROP TABLE MATERIAS");

            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS MATERIAS (id SERIAL, idEstudiante varchar(255), nombre varchar(255)," +
                    "tipo varchar(255), montoProtoforma NUMBER, montoSolicitado NUMBER)");
            jdbcTemplate.update("Insert into MATERIAS (idEstudiante, nombre, tipo, montoProtoforma, montoSolicitado) " +
                    " values (?,?,?,?,?)", cedula, nombreMateria, tipoMateria, Double.parseDouble(montoProtoforma), Double.parseDouble(montoSolicitado));


            System.out.println("Materia creada");
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("e.getMessage(): " + e.getMessage());
        }



    }
}
