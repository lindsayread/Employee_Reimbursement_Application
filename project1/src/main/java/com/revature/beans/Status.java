package com.revature.beans;

import java.io.Serializable;

public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4863379096896861902L;
	//enum values:
	public static enum StatusType {
		PENDING, APPROVED, DENIED
	}
	//columns in table:
	private Integer statusid;
	private StatusType statustype;
	//no args constructor:
	public Status() {
		
	}
	//all args constructor:
	public Status(Integer statusid, StatusType statustype) {
		super();
		this.statusid = statusid;
		this.statustype = statustype;
	}
	//getters and setters:
	public Integer getStatusid() {
		return statusid;
	}
	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}
	public StatusType getStatustype() {
		return statustype;
	}
	public void setStatustype(StatusType statustype) {
		this.statustype = statustype;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusid == null) ? 0 : statusid.hashCode());
		result = prime * result + ((statustype == null) ? 0 : statustype.hashCode());
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
		Status other = (Status) obj;
		if (statusid == null) {
			if (other.statusid != null)
				return false;
		} else if (!statusid.equals(other.statusid))
			return false;
		if (statustype != other.statustype)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Status [statusid=" + statusid + ", statustype=" + statustype + "]";
	}
	
}
