package com.example.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ProjectDetail")
public class ProjectDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
       private long id;
		@Enumerated(EnumType.STRING)
		private Domaine domaine;
		@OneToMany(mappedBy="ProjectDetail")
	    private List<Media> financialplan ;
		@Column(columnDefinition = "integer",name="Max",nullable=false,unique=false)
		private long MaxdemandedAmount;
		@Column(columnDefinition = "integer",name="Min",nullable=false,unique=false)
		private Long MinDemandedAmount;
		@Column(columnDefinition = "varchar(255)",name="Location",nullable=false,unique=false)
		private String Location;
		@Column(columnDefinition = "varchar(30)",name="Object",nullable=false,unique=false)
		private String Object;
		@Column(columnDefinition = "varchar(255)",name="Description",nullable=false,unique=false)
		private String Description;	
	    @Column(name="WishedBegindate")
	    @Temporal(value=TemporalType.TIMESTAMP)
		private Date WishedBegindate;
		public ProjectDetail() {
			super();
		}
		public ProjectDetail(long id, Domaine domaine, List<Media> financialplan, long maxdemandedAmount,
				Long minDemandedAmount, String location, String object, String description, Date wishedBegindate) {
			super();
			this.id = id;
			this.domaine = domaine;
			this.financialplan = financialplan;
			MaxdemandedAmount = maxdemandedAmount;
			MinDemandedAmount = minDemandedAmount;
			Location = location;
			Object = object;
			Description = description;
			WishedBegindate = wishedBegindate;
		}
		
		public long getId() {
		return id;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public List<Media> getFinancialplan() {
		return financialplan;
	}
	public void setFinancialplan(List<Media> financialplan) {
		this.financialplan = financialplan;
	}
	public long getMaxdemandedAmount() {
		return MaxdemandedAmount;
	}
	public void setMaxdemandedAmount(long maxdemandedAmount) {
		MaxdemandedAmount = maxdemandedAmount;
	}
	public Long getMinDemandedAmount() {
		return MinDemandedAmount;
	}
	public void setMinDemandedAmount(Long minDemandedAmount) {
		MinDemandedAmount = minDemandedAmount;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getObject() {
		return Object;
	}
	public void setObject(String object) {
		Object = object;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getWishedBegindate() {
		return WishedBegindate;
	}
	public void setWishedBegindate(Date wishedBegindate) {
		WishedBegindate = wishedBegindate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProjectDetail [id=" + id + ", domaine=" + domaine + ", financialplan=" + financialplan
				+ ", MaxdemandedAmount=" + MaxdemandedAmount + ", MinDemandedAmount=" + MinDemandedAmount
				+ ", Location=" + Location + ", Object=" + Object + ", Description=" + Description
				+ ", WishedBegindate=" + WishedBegindate + "]";
	}
		
	

}
