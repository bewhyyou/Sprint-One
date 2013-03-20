package edu.byu.isys413.rtyler1;

import java.util.LinkedList;
import java.util.List;

public class JournalEntry extends BusinessObject{

	@BusinessObjectField
	private java.util.Date jeDate = null;
	
	//list??	
	
	/** Creates the Business Object instance of this object*/
	public JournalEntry(String id) {
		super(id);
	}

	/** Gets the jeDate for the JournalEntry Object*/
	public java.util.Date getJeDate() {
		return jeDate;
	}

	/** Sets the jeDate for the JournalEntry Object*/
	public void setJeDate(java.util.Date jeDate) {
		this.jeDate = jeDate;
		setDirty();
	}
	
	
	/**
	 * Retrieves the debits/credits for this journalentry.
	 */
	public List<DebitCredit> getDebitCredits() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("DebitCredit", new SearchCriteria("jeid", id));
	}

	

}
