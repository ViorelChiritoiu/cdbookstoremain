package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 30)
	private String creditCardNumber;
	
	@NotNull
	private CreditCardType creditCardType;
	
	@NotNull
    @Size(min = 1, max = 5)
    private String creditCardExpDate;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardExpDate() {
		return creditCardExpDate;
	}

	public void setCreditCardExpDate(String creditCardExpDate) {
		this.creditCardExpDate = creditCardExpDate;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", creditCardType=" + creditCardType
				+ ", creditCardExpDate=" + creditCardExpDate + "]";
	}
}