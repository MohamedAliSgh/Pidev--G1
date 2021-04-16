package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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

@Embeddable
public class ProjectDetail implements Serializable{

		@Enumerated(EnumType.STRING)
		private Domaine domaine;
		@OneToMany
	    private List<Media> financialplan ;
		
		private long MaxdemandedAmount;
		
		private Long MinDemandedAmount;
	
		private String Location;
		
		private String Object;

		private String Description;	
	    @Column(name="WishedBegindate")
	    @Temporal(value=TemporalType.TIMESTAMP)
		private Date WishedBegindate;
		public ProjectDetail() {
			super();
		}
		public ProjectDetail( Domaine domaine, List<Media> financialplan, long maxdemandedAmount,
				Long minDemandedAmount, String location, String object, String description, Date wishedBegindate) {
			super();
	
			this.domaine = domaine;
			this.financialplan = financialplan;
			MaxdemandedAmount = maxdemandedAmount;
			MinDemandedAmount = minDemandedAmount;
			Location = location;
			Object = object;
			Description = description;
			WishedBegindate = wishedBegindate;
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

	@Override
	public String toString() {
		return "ProjectDetail [ domaine=" + domaine + ", financialplan=" + financialplan
				+ ", MaxdemandedAmount=" + MaxdemandedAmount + ", MinDemandedAmount=" + MinDemandedAmount
				+ ", Location=" + Location + ", Object=" + Object + ", Description=" + Description
				+ ", WishedBegindate=" + WishedBegindate + "]";
	}
		
	

}
