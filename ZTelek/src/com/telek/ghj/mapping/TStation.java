package com.telek.ghj.mapping;

import java.util.HashSet;
import java.util.Set;

/**
 * TStation entity. @author MyEclipse Persistence Tools
 */

public class TStation implements java.io.Serializable {

	// Fields

	private Long stationid;
	private String stationname;
	private String type;
	private String address;
	private Long pnumber;
	private String responsibility;
	private String require;
	private Set TDeliveries = new HashSet(0);

	// Constructors

	/** default constructor */
	public TStation() {
	}

	/** minimal constructor */
	public TStation(Long stationid) {
		this.stationid = stationid;
	}

	/** full constructor */
	public TStation(Long stationid, String stationname, String type,
			String address, Long pnumber, String responsibility,
			String require, Set TDeliveries) {
		this.stationid = stationid;
		this.stationname = stationname;
		this.type = type;
		this.address = address;
		this.pnumber = pnumber;
		this.responsibility = responsibility;
		this.require = require;
		this.TDeliveries = TDeliveries;
	}

	// Property accessors

	public Long getStationid() {
		return this.stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}

	public String getStationname() {
		return this.stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Long pnumber) {
		this.pnumber = pnumber;
	}

	public String getResponsibility() {
		return this.responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getRequire() {
		return this.require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public Set getTDeliveries() {
		return this.TDeliveries;
	}

	public void setTDeliveries(Set TDeliveries) {
		this.TDeliveries = TDeliveries;
	}

}