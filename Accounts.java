package com.movies.model;



import javax.persistence.Entity;

@Entity
public class Accounts {
	 int Id;
	private String name;
	private long accno;
	private double bal=5000;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public void deposit(double amt) {
		if (amt>0) {
			double bal=getBal()+(amt);
			setBal(bal);
			System.out.println(amt+" depositted.");
		}
		else 
		{
			System.out.println("Invalid ");
		}
	}
	public void withdraw(double amt) {
		
		

		if(getBal()>amt && amt>0 ) {
			 bal=getBal()-(amt);
			setBal(bal);
			System.out.println(amt+" withdrawn.");
		}
		else 
		{

			System.out.println("Insufficient balance");
		}
	}

}
