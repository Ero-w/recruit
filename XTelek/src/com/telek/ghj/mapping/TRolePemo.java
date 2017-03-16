package com.telek.ghj.mapping;

/**
 * TRolePemo entity. @author MyEclipse Persistence Tools
 */

public class TRolePemo implements java.io.Serializable {

	// Fields

	private TRolePemoId id;

	// Constructors

	/** default constructor */
	public TRolePemo() {
	}

	/** full constructor */
	public TRolePemo(TRolePemoId id) {
		this.id = id;
	}

	// Property accessors

	public TRolePemoId getId() {
		return this.id;
	}

	public void setId(TRolePemoId id) {
		this.id = id;
	}

}