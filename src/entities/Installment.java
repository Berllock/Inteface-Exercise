package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate dueDate;
	private Double amount;
	
	public Installment() {
		
	}

	public Installment(LocalDate duedate, Double amount) {
		super();
		this.dueDate = duedate;
		this.amount = amount;
	}

	public LocalDate getDuedate() {
		return dueDate;
	}

	public void setDuedate(LocalDate duedate) {
		this.dueDate = duedate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return dueDate.format(dtf) + " - " + String.format("%.2f", amount);
	}
	
	
	
}
