package com.onlinecakeshopping.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// * The Class Cart is the Entity representing Cart table in database
@Entity
@Table(name = "cart_details")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "total_bill")
	private int totalBill;
	@Column(name = "invoice")
	private String invoice;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(targetEntity = Cake.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "cake_id")
	private Cake cake;
	
	/**
	 * Cart default constructor
	 */
	
	public Cart() {
		super();

	}
	

	/**
     * Cart constructor with fields as parameters
     *
     * @param cartuserId      the cart Id
     * @param totalBill      the  total bill of cart
     * @param invoice     the invoice of cart
     * @param cakes   the cakes of cart
     */

	public Cart(int cartId, int totalBill, String invoice, Cake cake) {
		super();
		this.cartId = cartId;
		this.totalBill = totalBill;
		this.invoice = invoice;
		this.cake = cake;
	}
	/**
	* gets the Cart Id
	*
	* @return
	*/

	public int getCartId() {
		return cartId;
	}
	/**
	* setters for the Cart Id
	*
	* @param cartuserId
	*/

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	/**
	* gets the cart totalbill
	*
	* @return
	*/

	public int getTotalBill() {
		return totalBill;
	}
	/**
	* setters for the cart totalbill
	*
	* @param totalBill
	*/

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	
	/**
	* setters for the cart invoice
	*
	* @param invoice
	*/

	public String getInvoice() {
		return invoice;
	}
	
	/**
	* gets the cart invoice
	*
	* @return
	*/

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	/**
	* gets for the cake id
	*
	* @param cakes
	*/

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalBill=" + totalBill + ", invoice=" + invoice + ", cake=" + cake + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
