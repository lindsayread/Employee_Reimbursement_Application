package com.revature.beans;

import java.io.Serializable;

public class Roles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1785270871732871990L;

	public static enum RoleType {
		FINANCEMANANGER, EMPLOYEE
	}
	private Integer roleid;
	private RoleType roletype;
	
	public Roles() {
		
	}
	
	public Roles(Integer roleid, RoleType roletype) {
		super();
		this.roleid = roleid;
		this.roletype = roletype;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public RoleType getRoletype() {
		return roletype;
	}

	public void setRoletype(RoleType roletype) {
		this.roletype = roletype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		result = prime * result + ((roletype == null) ? 0 : roletype.hashCode());
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
		Roles other = (Roles) obj;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		if (roletype != other.roletype)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", roletype=" + roletype + "]";
	}
	
	
}
