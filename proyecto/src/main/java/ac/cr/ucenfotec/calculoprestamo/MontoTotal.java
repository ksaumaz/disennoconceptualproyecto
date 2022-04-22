
package ac.cr.ucenfotec.calculoprestamo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class MontoTotal implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String montoMateriasCronograma = (String) execution.getVariable("montoMateriasCronograma");
        String montoMatriculaCronograma = (String) execution.getVariable("montoMatriculaCronograma");
        String montoSostenimientoCronograma = (String) execution.getVariable("montoSostenimientoCronograma");
        int montoFinanciamientoMatricula = Integer.parseInt(montoMateriasCronograma) + Integer.parseInt(montoMatriculaCronograma) + Integer.parseInt(montoSostenimientoCronograma);
        execution.setVariable("montoFinanciamientoMatricula", montoFinanciamientoMatricula);
        System.out.println("Cálculo de cuota fiduciaria total: " + montoFinanciamientoMatricula);
        String montoFinanciamientoMatricual = (String) execution.getVariable("montoFinanciamientoMatricula");
        String montoOtrosFinanciamientos = (String) execution.getVariable("montoOtrosFinanciamientos");
        int montoFinanciamientoTotal = Integer.parseInt(montoFinanciamientoMatricual) + Integer.parseInt(montoOtrosFinanciamientos);
        execution.setVariable("montoFinanciamientoTotal", montoFinanciamientoTotal);
        System.out.println("Cálculo de cuota fiduciaria total: " + montoFinanciamientoTotal);
    }
}