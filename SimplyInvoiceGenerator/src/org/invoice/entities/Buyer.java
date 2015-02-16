package org.invoice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "BUYERS")
public class Buyer {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(mappedBy = "buyer", optional = false)
	private Invoices invoices;
	
	@Column(name="buyer_name", nullable = false, length=255)
	private String buyerName;
	@Column(name="buyer_adress", nullable = false)
	private String buyerAdress;
	@Column(name="buyer_nip", length=10)
	long buyerNip;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Invoices getInvoices() {
		return invoices;
	}
	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerAdress() {
		return buyerAdress;
	}
	public void setBuyerAdress(String buyerAdress) {
		this.buyerAdress = buyerAdress;
	}
	public long getBuyerNip() {
		return buyerNip;
	}
	public void setBuyerNip(long buyerNip) {
		this.buyerNip = buyerNip;
	}

	
	
}
