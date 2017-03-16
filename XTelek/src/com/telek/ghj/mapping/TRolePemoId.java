package com.telek.ghj.mapping;

/**
 * TRolePemoId entity. @author MyEclipse Persistence Tools
 */

public class TRolePemoId implements java.io.Serializable {

	// Fields

	private TRole TRole;
	private TPemo TPemo;

	// Constructors

	/** default constructor */
	public TRolePemoId() {
	}

	/** full constructor */
	public TRolePemoId(TRole TRole, TPemo TPemo) {
		this.TRole = TRole;
		this.TPemo = TPemo;
	}

	// Property accessors

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public TPemo getTPemo() {
		return this.TPemo;
	}

	public void setTPemo(TPemo TPemo) {
		this.TPemo = TPemo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TRolePemoId))
			return false;
		TRolePemoId castOther = (TRolePemoId) other;

		return ((this.getTRole() == castOther.getTRole()) || (this.getTRole() != null
				&& castOther.getTRole() != null && this.getTRole().equals(
				castOther.getTRole())))
				&& ((this.getTPemo() == castOther.getTPemo()) || (this
						.getTPemo() != null && castOther.getTPemo() != null && this
						.getTPemo().equals(castOther.getTPemo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTRole() == null ? 0 : this.getTRole().hashCode());
		result = 37 * result
				+ (getTPemo() == null ? 0 : this.getTPemo().hashCode());
		return result;
	}

}