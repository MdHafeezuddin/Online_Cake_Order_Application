package com.onlinecakeshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//The Class Vegetable is the Entity representing Vegetables table in database
@Entity
@Table(name = "cake_details")
public class Cake {
	
	
	/**
	 * Cake default constructor
	 */

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cake_id")
	private int cakeId;
	@Column(name = "cake_name")
	private String cakeName;
	@Column(name = "cake_price")
	private int cakePrice;
	@Column(name = "cake_quantity")
	private int cakeQuantity;
	
	
	public Cake() {
		super();

	}
	
	/**
     * Cake constructor with fields as parameters
     *
     * @param id      the cake id
     * @param nameame      the  name of cake
     * @param price      the price of cake
     * @param quantity   the quantity of cake
     */
	
	public Cake(int cakeId, String cakeName, int cakePrice, int cakeQuantity) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeQuantity = cakeQuantity;
	}
	
	/**
     * gets the id of cake
     *
     * @return
     */


	public int getCakeId() {
		return cakeId;
	}
	/**
     * setters the id of cake
     *
     * @return
     */


	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}
	
	/**
     * gets the name of cake
     *
     * @return
     */


	public String getCakeName() {
		return cakeName;
	}
	
	/**
     * sets the name of cake
     *
     * @return
     */


	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	
	/**
     * gets the price of cake
     *
     * @return
     */


	public int getCakePrice() {
		return cakePrice;
	}
	
	/**
     * sets the price of cake
     *
     * @return
     */
	
	


	public void setCakePrice(int cakePrice) {
		this.cakePrice = cakePrice;
	}
	
	/**
     * gets the quantity of cake
     *
     * @return
     */


	public int getCakeQuantity() {
		return cakeQuantity;
	}
	
	/**
     * sets the quantity of cake
     *
     * @return
     */


	public void setCakeQuantity(int cakeQuantity) {
		this.cakeQuantity = cakeQuantity;
	}


	@Override
	public String toString() {
		return "Cake [cakeId=" + cakeId + ", cakeName=" + cakeName + ", cakePrice=" + cakePrice + ", cakeQuantity="
				+ cakeQuantity + "]";
	}
	
	

}
