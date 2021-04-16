package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Critere")
public class Critere  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	private String critere;
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Critere [id=" + id + ", critere=" + critere + "]";
	}
	public String getCritere() {
		return critere;
	}
	public void setCritere(String critere) {
		this.critere = critere;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Critere() {
		super();
	}
	public Critere(long id, String critere) {
		this.id = id;
		this.critere = critere;
	}
	
	
   
}
