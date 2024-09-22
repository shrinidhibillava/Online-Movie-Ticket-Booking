package com.movies.model.bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		 int Id;
	   
		private String BankName="State bank of India";
		private String name;
		private long accno;
		private String IFSCCODE="SBIN0005040";
		private double bal=5000;
        private int pin;
		 public int getPin() {
			return pin;
		}
		public void setPin(int pin) {
			this.pin = pin;
		}
		public String getBankName() {
				return BankName;
			}
			public void setBankName(String bankName) {
				BankName = bankName;
			}
			public String getIFSCCODE() {
				return IFSCCODE;
			}
			public void setIFSCCODE(String iFSCCODE) {
				IFSCCODE = iFSCCODE;
			}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
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
			bal = bal;
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



