package com.revature.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reimbs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6325530814965144704L;
	
	private Integer idreimb;
	private Double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Integer author;
	private Integer resolver;
	private Integer statusid;
	private Integer rtypeid;
	
	//no args constructor:
	public Reimbs() {
		//super();
	}
	//all args constructor (except auto-generated id)
	public Reimbs(Double amount, Timestamp submitted, Timestamp resolved, String description, Integer author, Integer resolver,
			Integer statusid, Integer rtypeid) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.rtypeid = rtypeid;
	}
	//all args constructor (including auto-generated id)
	public Reimbs(Integer idreimb, Double amount, Timestamp submitted, Timestamp resolved, String description, Integer author,
			Integer resolver, Integer statusid, Integer rtypeid) {
		super();
		this.idreimb = idreimb;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.rtypeid = rtypeid;
	}
	
	
	//private List<Status> status;
	//private List<Type> rtype;
	public Integer getIdreimb() {
		return idreimb;
	}
	public void setIdreimb(Integer idreimb) {
		this.idreimb = idreimb;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp timestamp) {
		this.resolved = timestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public Integer getResolver() {
		return resolver;
	}
	public void setResolver(Integer resolver) {
		this.resolver = resolver;
	}
	public Integer getStatusid() {
		return statusid;
	}
	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}
	public Integer getRtypeid() {
		return rtypeid;
	}
	public void setRtypeid(Integer rtypeid) {
		this.rtypeid = rtypeid;
	}
	@Override
	public String toString() {
		return "Reimbs [idreimb=" + idreimb + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", statusid=" + statusid + ", rtypeid=" + rtypeid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idreimb == null) ? 0 : idreimb.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((rtypeid == null) ? 0 : rtypeid.hashCode());
		result = prime * result + ((statusid == null) ? 0 : statusid.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
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
		Reimbs other = (Reimbs) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idreimb == null) {
			if (other.idreimb != null)
				return false;
		} else if (!idreimb.equals(other.idreimb))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (rtypeid == null) {
			if (other.rtypeid != null)
				return false;
		} else if (!rtypeid.equals(other.rtypeid))
			return false;
		if (statusid == null) {
			if (other.statusid != null)
				return false;
		} else if (!statusid.equals(other.statusid))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		return true;
	}
	
	
}
