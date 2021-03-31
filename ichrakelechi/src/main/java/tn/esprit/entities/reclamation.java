package tn.esprit.entities;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;




@Entity
@Table(name="Reclamation")
public class reclamation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int IdClaim ;
	private int IdUser;
	private String FirstName;
	private String LastName;
	private int TelNum;
	private String Email;
	private String Object;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date CreationDate;
    @Enumerated(EnumType.STRING)
    private Priorities Priorities;
   
    
    
    public int getIdClaim() {
		return this.IdClaim ;
	}
    
    public void setIdClaim ( int IdClaim) {
		this.IdClaim = IdClaim;
		
	}
    
    public int getIdUser() {
		return this.IdUser ;
	}
    
    public void setIdUser( int IdUser) {
		this.IdUser = IdUser;
		
	}
    
    public String getFirstName() {
		return this.FirstName ;
	}
    
    public void setFirstName ( String FirstName) {
		this.FirstName = FirstName;
		
	}
    
    public String getLastName() {
		return this.LastName ;
	}
    
    public void setLastName ( String LastName) {
		this.LastName = LastName;
		
	}
    
    public int getTelNum() {
		return this.TelNum ;
	}
    
   
    
    public void setTelNum ( int TelNum) {
		this.TelNum = TelNum;
		
	}
    
    public String getEmail() {
		return this.Email ;
	}
    
    public void setEmail ( String Email) {
		this.Email = Email;
		
	}
    
    public String getObject() {
		return this.Object ;
	}
    
    public void setObject ( String Object) {
		this.Object = Object;
		
	}
    
    
    public String getDescription() {
		return this.Description ;
	}
    
    public void setDescription ( String Description) {
		this.Description =Description;
		
	}
  
    
    public Priorities getPriorites() {
		return this.Priorities ;
	}
    
    public Date getCreationDate() {
		return this.CreationDate ;
	}
    
    public void setCreationDate ( Date CreationDate) {
		this.CreationDate = CreationDate;
		
	}
    
    public void setPriorites ( Priorities Priorities) {
		this.Priorities = Priorities;
		
	}
    public reclamation (){}
    
    public reclamation (int IdClaim ,int IdUser,String FirstName,String LastName, int TelNum, String Email , String Object, String Description, Date CreationDate, Priorities  Priorities ) {
    	this.IdClaim = IdClaim;
    	this.IdUser = IdUser;
    	this.FirstName=FirstName;
    	this.LastName=LastName;
    	this.TelNum = TelNum;
    	this.Email = Email;
    	this.Object = Object;
    	this.Description =Description;
    	this.CreationDate=CreationDate;
    	this.Priorities =Priorities;
	}
    
    @ManyToOne
    (cascade=CascadeType.ALL)
	User user;

    @Override
	public String toString() {
		return "claim [IdClaim=" + IdClaim + ", IdUser=" + IdUser + ", FirstName=" + FirstName + ", LastName=" + LastName + ", TelNum=" + TelNum + ", Email=" + Email + ", Object=" + Object + ", Description=" + Description + ", CreationDate=" + CreationDate + ", Priorities=" + Priorities + "]";
	}
    

}
