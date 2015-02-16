package org.invoice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(mappedBy = "item", optional = false)
	private Invoices invoices;
	@Column(name="item_name", nullable = false, length=255)
	private String itemName;
	@Column(name="item_quantity", nullable = false)
	int itemQuantity; 
	@Column(name="item_price", nullable = false)
	double itemPrice;
	@Column(name="item_vat", nullable = false)
	int itemVat;
		

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemVat() {
		return itemVat;
	}
	public void setItemVat(int itemVat) {
		this.itemVat = itemVat;
	}
	public Invoices getInvoices() {
		return invoices;
	}
	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}
	

}
