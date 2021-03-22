package com.revature.beans;

import java.io.Serializable;

//import com.revature.beans.Roles.RoleType;

public class ReimType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9083016078425149030L;

	public static enum ReimbType {
		TRAVEL, FOOD, LODGING, OTHER
	}
	private Integer reimid;
	private ReimbType reimbtype;
	
	public ReimType() {
		
	}
	
	public ReimType(Integer reimid, ReimbType reimbtype) {
		super();
		this.reimid = reimid;
		this.reimbtype = reimbtype;
	}

	public Integer getReimid() {
		return reimid;
	}

	public void setReimid(Integer reimid) {
		this.reimid = reimid;
	}

	public ReimbType getReimbtype() {
		return reimbtype;
	}

	public void setReimbtype(ReimbType reimbtype) {
		this.reimbtype = reimbtype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbtype == null) ? 0 : reimbtype.hashCode());
		result = prime * result + ((reimid == null) ? 0 : reimid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimType other = (ReimType) obj;
		if (reimbtype != other.reimbtype)
			return false;
		if (reimid == null) {
			if (other.reimid != null)
				return false;
		} else if (!reimid.equals(other.reimid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimType [reimid=" + reimid + ", reimbtype=" + reimbtype + "]";
	}
	
	
	
}