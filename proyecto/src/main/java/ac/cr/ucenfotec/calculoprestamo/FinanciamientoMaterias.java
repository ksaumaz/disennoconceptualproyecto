package ac.cr.ucenfotec.calculoprestamo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class FinanciamientoMaterias implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String montoMateriasCronograma = (String) execution.getVariable("montoMateriasCronograma");
        String montoMatriculaCronograma = (String) execution.getVariable("montoMatriculaCronograma");
        String montoSostenimientoCronograma = (String) execution.getVariable("montoSostenimientoCronograma");
        int montoFinanciamientoMatricula = Integer.parseInt(montoMateriasCronograma) + Integer.parseInt(montoMatriculaCronograma) + Integer.parseInt(montoSostenimientoCronograma);
        execution.setVariable("montoFinanciamientoMatricula", montoFinanciamientoMatricula);
        System.out.println("Cálculo de matrícula: " + montoFinanciamientoMatricula);
    }
}
