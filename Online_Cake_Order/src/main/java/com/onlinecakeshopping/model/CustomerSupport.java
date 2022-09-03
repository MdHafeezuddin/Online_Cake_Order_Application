package com.onlinecakeshopping.model;

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


//The Class CustomerSupport is the Entity representing CustomerSupport table in database
@Entity
@Table(name = "customersupport_details")
public class CustomerSupport {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerSupport_id")
	private int customerSupportId;
	@Column(name = "solve_complaint")
	private String solveComplaint;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(targetEntity = RaiseComplaint.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "complaint_id")
	private RaiseComplaint raiseComplaint;
	
	/**
	 * CustomerSupport default constructors
	 */

	
	public CustomerSupport() {
		super();

	}
	
	/**
     * CustomerSupport constructor with fields as parameters
     *
     * @param customerSupportId      the customerSupportId Id
     * @param solve complaint     the solve complaint
     * @param raisecomplaint    the raisecomplaint

     */

	
	public CustomerSupport(int customerSupportId, String solveComplaint, RaiseComplaint raiseComplaint) {
		super();
		this.customerSupportId = customerSupportId;
		this.solveComplaint = solveComplaint;
		this.raiseComplaint = raiseComplaint;
	}
	
	/**
	* gets the CustomerSupport Id
	*
	* @return
	*/

	public int getCustomerSupportId() {
		return customerSupportId;
	}
	
	/**
	* sets the CustomerSupport Id
	*
	* @return
	*/

	public void setCustomerSupportId(int customerSupportId) {
		this.customerSupportId = customerSupportId;
	}
	
	/**
	* gets the SolveComplaint Id
	*
	* @return
	*/

	public String getSolveComplaint() {
		return solveComplaint;
	}
	
	/**
	* sets the SolveComplaint Id
	*
	* @return
	*/

	public void setSolveComplaint(String solveComplaint) {
		this.solveComplaint = solveComplaint;
	}
	
	/**
	* gets the raiseComplaint Id
	*
	* @return
	*/

	public RaiseComplaint getRaiseComplaint() {
		return raiseComplaint;
	}
	/**
	* sets the Complaint Id
	*
	* @return
	*/

	public void setRaiseComplaint(RaiseComplaint raiseComplaint) {
		this.raiseComplaint = raiseComplaint;
	}

	@Override
	public String toString() {
		return "CustomerSupport [customerSupportId=" + customerSupportId + ", solveComplaint=" + solveComplaint
				+ ", raiseComplaint=" + raiseComplaint + "]";
	}

}

