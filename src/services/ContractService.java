package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract (Contract contract, Integer months) {
		double instValue = contract.getTotalValue() / months;
		
		for (int i = 1 ; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(instValue, i);
			double fee =  onlinePaymentService.paymentFee(instValue + interest); 
			double value = instValue + fee + interest;
			
			contract.getInstallments().add(new Installment(dueDate, value));
		}
	}
	
}
