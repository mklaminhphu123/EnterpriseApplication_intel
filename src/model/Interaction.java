package model;

import java.util.Date;

public class Interaction
{
	//Data Field
	private String idIn;
	private Date dateOfInteraction;
	private String leadID;
	private String contact;
	private String address;
	private Potential potential;
	
	//Constructor
	public Interaction(String idIn, Date dateOfInteraction, String leadID, String contact, String address, Potential potential) {
		this.idIn = idIn;
		this.dateOfInteraction = dateOfInteraction;
		this.leadID = leadID;
		this.contact = contact;
		this.address = address;
		this.potential = potential;
	}

	public Interaction(Date dateOfInteraction, String leadID, String contact, String address, Potential potential) {
		this.dateOfInteraction = dateOfInteraction;
		this.leadID = leadID;
		this.contact = contact;
		this.address = address;
		this.potential = potential;
	}

	//Get 'n' Set
	public String getIdIn()
	{
		return idIn;
	}
	public void setIdIn(String idIn)
	{
		this.idIn = idIn;
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

	public String getContact()
	{
		return contact;
	}
	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public Potential getPotential() { return potential; }
	public void setPotential(Potential potential) { this.potential = potential; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	@Override
	public String toString()
	{
		return "ID: " + getIdIn() + "\n"
				+ "Date of Interaction" + getDateOfInteraction() + "\n"
				+ "Lead ID: " + getLeadID() + "\n"
				+ "Contact: " + getContact() + "\n"
				+ "Potential" + getPotential() + "\n";
	}
}

