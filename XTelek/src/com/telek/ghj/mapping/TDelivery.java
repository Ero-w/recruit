package com.telek.ghj.mapping;

/**
 * TDelivery entity. @author MyEclipse Persistence Tools
 */

public class TDelivery implements java.io.Serializable {

	// Fields

	private Long deliveryid;
	private TStation TStation;
	private TUser TUser;
	private Long state;

	// Constructors

	/** default constructor */
	public TDelivery() {
	}

	/** minimal constructor */
	public TDelivery(Long deliveryid) {
		this.deliveryid = deliveryid;
	}

	/** full constructor */
	public TDelivery(Long deliveryid, TStation TStation, TUser TUser,
			Long state) {
		this.deliveryid = deliveryid;
		this.TStation = TStation;
		this.TUser = TUser;
		this.state = state;
	}

	// Property accessors

	public Long getDeliveryid() {
		return this.deliveryid;
	}

	public void setDeliveryid(Long deliveryid) {
		this.deliveryid = deliveryid;
	}

	public TStation getTStation() {
		return this.TStation;
	}

	public void setTStation(TStation TStation) {
		this.TStation = TStation;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

}