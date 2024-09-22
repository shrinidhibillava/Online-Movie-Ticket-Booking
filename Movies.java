package com.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Movies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int mId;
	
	private String mName;
	private int mPrice;
	private String Languge;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public String getLanguge() {
		return Languge;
	}
	public void setLanguge(String languge) {
		Languge = languge;
	}
	
	@Override
	public String toString() {
		return "Select " + mId + ", for " + mName + ", Rs=" + mPrice ;
	}
	

}
