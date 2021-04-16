package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="LoanOffer")
public class Loanoffer implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
    private long id;
	private String Description;
	private User editor;
	public User getEditor() {
		return editor;
	}
	public void setEditor(User editor) {
		this.editor = editor;
	}
	private Domaine domaine;
	@Embedded
	private LoanDetails Details;
	
	   @Column(name="date")
	   @Temporal(TemporalType.TIMESTAMP)
	private Date date;
	  @Column(columnDefinition = "integer",name="Duree")
	private Long duree;
	  @OneToMany
	private List<Critere> critere;
		public List<Critere> getCritere() {
		return critere;
	}
	public void setCritere(List<Critere> critere) {
		this.critere = critere;
	}
		public Loanoffer() {
			}
	public Loanoffer(long id, String description, Domaine domaine, LoanDetails details, Date date, Long duree) {
		this.id = id;
		Description = description;
		this.domaine = domaine;
		Details = details;
		this.date = date;
		this.duree = duree;
	}
	public long getId() {
		return id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public LoanDetails getDetails() {
		return Details;
	}
	public void setDetails(LoanDetails details) {
		Details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Loanoffer [id=" + id + ", Description=" + Description + ", domaine=" + domaine + ", Details=" + Details
				+ ", date=" + date + ", duree=" + duree + "]";
	}
	
	
}
