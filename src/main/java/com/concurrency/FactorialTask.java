package com.concurrency;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Long> {
	
	private Long number;
	
	public FactorialTask(Long number) {
		super();
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		return calculateFactorial(this.number);
	}

	private Long calculateFactorial(Long n) {
		Long fact=1L;
		while(n>0) {
			fact= fact*n;
			n--;
		}
		System.out.println(String.format("factorial of number : [%d] is : [%d]", this.number,fact));
		return fact;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	
}
