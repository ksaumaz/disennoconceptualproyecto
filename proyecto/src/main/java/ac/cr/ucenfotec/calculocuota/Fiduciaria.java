package ac.cr.ucenfotec.calculocuota;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Fiduciaria implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int montoSolicitado = (int) execution.getVariable("montoSolicitado");
        double interesAnual = (4.5/100)+1;
        int annos = 5;
        int cantidadCuotas = 60;
        double montoTotal = montoSolicitado * Math.pow(interesAnual, annos);
        double montoCuota = montoTotal/cantidadCuotas;

        execution.setVariable("montoTotal", montoTotal);
        execution.setVariable("montoCuota", montoCuota);
        System.out.println("Cálculo de cuota fiduciaria total: " + montoTotal);
    }
}
