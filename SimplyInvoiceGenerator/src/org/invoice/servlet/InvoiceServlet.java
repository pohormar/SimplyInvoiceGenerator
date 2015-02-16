package org.invoice.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.invoice.entities.Buyer;
import org.invoice.entities.Invoices;
import org.invoice.entities.Item;
import org.invoice.entities.Seller;


/**
 * Servlet implementation class InvoiceServlet
 */
@WebServlet("/InvoiceServlet")
public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String invoiceNo = request.getParameter("invoice-no");
		String invoiceDateStr = request.getParameter("invoice-date");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy");
		Date invoiceDate = null;
		
		try {
			invoiceDate = sdf.parse(invoiceDateStr);
		} catch (ParseException e) {
			System.out.println("Blad parsowania daty. Stos wywolan:");
			e.printStackTrace();
		}
		
	    String sellerCompanyName = request.getParameter("seller-company-name");
		String sellerAdress = request.getParameter("seller-adress");
		long sellerNip = Long.parseLong(request.getParameter("seller-nip")); 
		
		String buyerName = request.getParameter("buyer-name"); 
		String buyerAdress = request.getParameter("buyer-adress"); 
		long buyerNip = Long.parseLong(request.getParameter("buyer-nip")); 
		
		String itemName = request.getParameter("item-name"); 
		int itemQuantity = Integer.parseInt(request.getParameter("item-quantity")); 
		double itemPrice = Double.parseDouble(request.getParameter("item-price"));
		int itemVat = Integer.parseInt(request.getParameter("item-vat")); 
		double priceBrutto=0;
		double itemsPriceNetto = itemQuantity*itemPrice;
		
		if(itemVat!=0){
			priceBrutto=((double)itemVat/100)*itemsPriceNetto;
			priceBrutto+=itemsPriceNetto;
		} else
		{
		    priceBrutto=itemsPriceNetto;
		}
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("orm-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

        try {
		transaction.begin();
		
		Invoices invoices = new Invoices();
		invoices.setInvoiceDate(invoiceDate);
		invoices.setInvoiceNo(invoiceNo);
				
		Seller seller = new Seller();
		seller.setSellerCompanyName(sellerCompanyName);
		seller.setSellerAdress(sellerAdress);
		seller.setSellerNip(sellerNip);
		
		Buyer buyer = new Buyer();
		buyer.setBuyerAdress(buyerAdress);
		buyer.setBuyerName(buyerName);
		buyer.setBuyerNip(buyerNip);

		Item item = new Item();
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemQuantity(itemQuantity);
		item.setItemVat(itemVat);
		
		
		seller.setInvoices(invoices);
		buyer.setInvoices(invoices);
		item.setInvoices(invoices);
		invoices.setSeller(seller);
		invoices.setBuyer(buyer);	
		invoices.setItem(item);
		invoices.setPriceBrutto(priceBrutto);


		em.persist(item);
		em.persist(seller);
		em.persist(buyer);
		em.persist(invoices);
		

		transaction.commit();
		request.setAttribute("invoices", invoices);
		request.setAttribute("seller", seller);
		request.setAttribute("buyer", buyer);
		request.setAttribute("item", item);
		
		}
        finally {
                    if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
		
	
		request.getRequestDispatcher("invoice-page.jsp").forward(request, response);
	}
	
	

}
