package com.example.demo.entities;
import javax.persistence.*;
import java.io.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Entity
@Table(name="accounts")
@ManagedBean
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private float balance;
    private int editId;

    public Account() {}
    public Account(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account["+id+"]: "+ firstname + " " + lastname;
    }

    public void setEditId(int id) {
        editId = id;
    }
    
    public int getEditId() {
        return editId;
    }

    public String updateDetails() {
        editId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("editId"));
        return "editAccount.xhtml";
    }


    public void update(Account account) {
        firstname = account.getFirstname();
        lastname = account.getLastname();
        balance = account.getBalance();
    }
}
