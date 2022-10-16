package com.simplilearn.mapping;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="A_CUSTOMER_DATA_BI")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="cemail")
	private String cemail;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="phone")
	private Long phone;
	
	/*Many to Many - Many Customer have Many ACCOUNT*/
	@ManyToMany()
	@JoinTable(
				name="A_CUSTOMER_ACCOUNT_PK", 
				joinColumns = @JoinColumn(name="cid",referencedColumnName = "cid"),
				inverseJoinColumns = @JoinColumn(name="accountno",referencedColumnName = "accountno")
				
			)
	Set<Account> account;/*1*/

	public Customer() {
		
	}
	public Customer(String cname, String cemail, Date dob, Long phone, Set<Account> account) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.dob = dob;
		this.phone = phone;
		this.account = account;
	}
	public Customer(String cname, String cemail, Date dob, Long phone) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.dob = dob;
		this.phone = phone;
	}
	public Customer(int cid, String cname, String cemail, Date dob, Long phone, Set<Account> account) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.dob = dob;
		this.phone = phone;
		this.account = account;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", dob=" + dob + ", phone=" + phone
				+ ", account=" + account + "]";
	}
	
	
}
