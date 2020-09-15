package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Lead
{
    //Data Field
	private String id;
	private String name;
	private Date dob;
	private boolean gender;
	private String phone;
	private String email;
	private String address;
    
    



    //Constructor
    public Lead(String id, String name, Date dob, boolean gender, String phone, String email, String address)
    {
    	this.setId(id);
        this.setName(name);
        this.setDob(dob);
        this.setGender(gender);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
    }
    
    public Lead(String name, Date dob, boolean gender, String phone, String email, String address)
    {
    	//TODO: generate new id
    	//this.id = generate ID
        this.setName(name);
        this.setDob(dob);
        this.setGender(gender);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
    }
    
    @Override
    public String toString() {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
    	
    	// TODO Auto-generated method stub
    	return "Name: " + getName() + "\n" 
    			+ "ID: "+ getId() + "\n"
    			+ "Date of Birth: " + dateFormat.format(getDob()) + "\n"
    			+ "Gender: " + isGender() + "\n"
    			+ "Phone number: "+ getPhone()  + "\n"
    			+ "Email "+ getEmail() + "\n"
    			+ "Address: " +  getAddress() + "\n"
    			;
    }
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}