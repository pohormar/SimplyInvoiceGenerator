package org.invoice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "SELLERS")
public class Seller {

	@Id
	@GeneratedValue
	private long id;
	@OneToOne(mappedBy = "seller", optional = false)
	private Invoices invoices;
	@Column(name="seller_company_name", nullable = false, length=255)
	private String sellerCompanyName;
	@Column(name="seller_adress", nullable = false)
	private String sellerAdress;
	@Column(name="seller_nip", length=10, nullable = false)
	long sellerNip;
	
			
	public Invoices getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSellerCompanyName() {
		return sellerCompanyName;
	}

	public void setSellerCompanyName(String sellerCompanyName) {
		this.sellerCompanyName = sellerCompanyName;
	}

	public String getSellerAdress() {
		return sellerAdress;
	}

	public void setSellerAdress(String sellerAdress) {
		this.sellerAdress = sellerAdress;
	}

	public long getSellerNip() {
		return sellerNip;
	}

	public void setSellerNip(long sellerNip) {
		this.sellerNip = sellerNip;
	}

	
}
