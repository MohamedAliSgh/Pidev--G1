package com.example.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Embeddable
public class LoanDetails implements Serializable {
	//private static final long serialVersionUID = 1L;
	  // @Column(columnDefinition = "integer",name="MaxAmount",nullable=false,unique=false)
	   private Long MaxAmonut;
	   //@Column(columnDefinition = "integer",name="MinAmount",nullable=false,unique=false)
	   private Long MinAmount;
	   //@Column(columnDefinition = "varchar(255)",name="PaymentsDetails",nullable=false,unique=false)
	   private String PaymentDetails;
	   //@Column(columnDefinition = "varchar(255)",name="Location",nullable=false,unique=false)
	   private String Location;
	public Long getMaxAmonut() {
		return MaxAmonut;
	}
	public void setMaxAmonut(Long maxAmonut) {
		MaxAmonut = maxAmonut;
	}
	public Long getMinAmount() {
		return MinAmount;
	}
	public void setMinAmount(Long minAmount) {
		MinAmount = minAmount;
	}
	public String getPaymentDetails() {
		return PaymentDetails;
	}
	public void setPaymentDetails(String paymentDetails) {
		PaymentDetails = paymentDetails;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	/*public static long getSerialversionuid() {
		return serialVersionUID;
	}*/


	    

}
