package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbs;
import com.revature.beans.User;

public interface ReimbsDao {
	
	/**
	 * Inserts a new reimbursement request into the persistence layer
	 * @param r the reimbursement to insert
	 * @return the newly added reimbursement object
	 */
	public Reimbs addReimbs(Reimbs r);
	
	/**
	 * Retrieves a reimbursement
	 * @param reimbId the id to search by
	 * @return the reimbursement object
	 */
	public Reimbs getReimbs(Integer reimbId);
	
	/**
	 * Retrieves all reimbursements
	 * @return a list of all reimbursements
	 */
	public List<Reimbs> getReimbs();
	
	/**
	 * Retrieves reimbursements by a particular user
	 * @param u the user object to search by
	 * @return a list of reimbursements that the user owns
	 */
	public List<Reimbs> getReimbsByUser(User u);
	
	/**
	 * Updates a specific reimbursement
	 * @param a the reimbursement to update
	 * @return the updated reimbursement
	 */
	public Reimbs updateReimb(Reimbs r);
	
	/**
	 * Deletes a reimbursement from the persistence layer
	 * @param r the reimbursement to delete
	 * @return true if the deletion was successful; false if not
	 */
	public boolean removeReimb(Reimbs r);
	
	/**
	 * retrieves reimbursements based on reimbursement status
	 * @param s the status requested
	 * @return a list of reimbursements of the specified status
	 */
	public List<Reimbs> getReimbsByStatus(Integer reimbStatus);
}
