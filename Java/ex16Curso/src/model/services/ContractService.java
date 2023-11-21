
package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    
    private final OnlinePaymentService paymentService;

    
    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    
    public void processContract(Contract contract, int months){
        double amount = contract.getTotalValue();
        LocalDate dueDate = contract.getDate();
        
        for (int i = 1; i <= months; i++) {
            double aux = amount / months;    
            
            aux = paymentService.interest(aux, i);
            aux = paymentService.paymentFee(aux);
            
            contract.addInstallment(new Installment(dueDate.plusMonths(i), aux));
        }
    }
}
