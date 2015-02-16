package org.invoice.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "INVOICES")
public class Invoices {


	@Id
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="invoice_date")
	private Date InvoiceDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Seller seller;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private Buyer buyer;

	@OneToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;
	
	@Column(name="price_brutto")
	private double priceBrutto;

	
	public double getPriceBrutto() {
		return priceBrutto;
	}
	public void setPriceBrutto(double priceBrutto) {
		this.priceBrutto = priceBrutto;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
		
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
