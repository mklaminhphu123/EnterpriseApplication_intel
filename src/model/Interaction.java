package model;

import java.util.Date;

public class Interaction
{
	//Data Field
	private String id;
	private Date dateOfInteraction;
	private String leadID;
	private ContactMethod contact;
	private Potential potential;
	
	//Constructor
	public Interaction(String id, Date dateOfInteraction, String leadID, ContactMethod contact, Potential potential) {
		this.id = id;
		this.dateOfInteraction = dateOfInteraction;
		this.leadID = leadID;
		this.contact = contact;
		this.potential = potential;
	}

	public Interaction(Date dateOfInteraction, String leadID, ContactMethod contact, Potential potential) {
		this.dateOfInteraction = dateOfInteraction;
		this.leadID = leadID;
		this.contact = contact;
		this.potential = potential;
	}

	//Get 'n' Set
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}

	public Date getDateOfInteraction()
	{
		return dateOfInteraction;
	}
	public void setDateOfInteraction(Date dateOfInteraction)
	{
		this.dateOfInteraction = dateOfInteraction;
	}

	public String getLeadID()
	{
		return leadID;
	}
	public void setLeadID(String leadID)
	{
		this.leadID = leadID;
	}

	public ContactMethod getContact()
	{
		return contact;
	}
	public void setContact(ContactMethod contact)
	{
		this.contact = contact;
	}

	public Potential getPotential() { return potential; }
	public void setPotential(Potential potential) { this.potential = potential; }

	@Override
	public String toString()
	{
		return "Interaction ID: " + getId() + "\n"
				+ "Date of Interaction: " + getDateOfInteraction() + "\n"
				+ "Lead ID: " + getLeadID() + "\n"
				+ "Contact by: " + getContact() + "\n"
				+ "Potential: " + getPotential() + "\n";
	}
}

