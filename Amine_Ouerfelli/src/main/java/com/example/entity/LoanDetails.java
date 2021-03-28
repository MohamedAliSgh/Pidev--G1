package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LoanDetails")
public class LoanDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
       private long id;
	   @Column(columnDefinition = "integer",name="MaxAmount",nullable=false,unique=false)
	   private Long MaxAmonut;
	   @Column(columnDefinition = "integer",name="MinAmount",nullable=false,unique=false)
	   private Long MinAmount;
	   @Column(columnDefinition = "varchar(255)",name="PaymentsDetails",nullable=false,unique=false)
	   private String PaymentDetails;
	   @Column(columnDefinition = "varchar(255)",name="Location",nullable=false,unique=false)
	   private String Location;
	   @Enumerated(EnumType.STRING)
	   private Domaine domaines;
	   @Column(columnDefinition = "varchar(255)",name="Criteres",nullable=false,unique=false)
	   private String criteres;
	    

}
