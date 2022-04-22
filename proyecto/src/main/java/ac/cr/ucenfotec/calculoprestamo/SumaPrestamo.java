
package ac.cr.ucenfotec.calculoprestamo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class SumaPrestamo implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int montoFinanciamientoMatricula = (int) execution.getVariable("montoFinanciamientoMatricula");
        String montoOtrosFinanciamientos = (String) execution.getVariable("montoOtrosFinanciamientos");
        int montoFinanciamientoTotal = montoFinanciamientoMatricula + Integer.parseInt(montoOtrosFinanciamientos);
        execution.setVariable("montoFinanciamientoTotal", montoFinanciamientoTotal);
        System.out.println("Cálculo total: " + montoFinanciamientoTotal);
    }
}