package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Lead;
import model.LeadRepository;

public class LeadManagement {
	private LeadRepository leadRepository = new LeadRepository(Utility.LEAD_FILE);
	private ArrayList<Lead> leads = new ArrayList<Lead>();
	
	
	public void read() throws FileNotFoundException {
		setLeads(this.leadRepository.read());
	}
	
	
	public void add() throws ParseException, FileNotFoundException {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Please enter your date of birth(yyyy-mm-dd): ");
		String dobstr = scanner.nextLine();
		Date dob = new SimpleDateFormat(Utility.DATE_FORMAT).parse(dobstr);
		System.out.println("Please enter your gender: ");
		String gender = scanner.nextLine();
		boolean valueGender = false;
		if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("true")){
			valueGender = true;
		}
		System.out.println("Please enter your phone number: ");
		String phone = scanner.nextLine();
		System.out.println("Please enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Please enter your address: ");
		String address = scanner.nextLine();
		Lead lead = new Lead(name, dob, valueGender, phone, email, address);
		//lead_003
		int lastId = Integer.parseInt(leads.get(leads.size() - 1).getId().substring(4,7)) +1;

		lead.setId(Utility.generateID(lastId));
		this.getLeads().add(lead);
		leadRepository.write(getLeads());
	}
	
	public void update() throws ParseException, FileNotFoundException{
		System.out.println("Select input ID you want to update: ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		boolean updated = false;		

		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Please enter your date of birth(yyyy-mm-dd): ");
		String dobstr = scanner.nextLine();
		Date dob = new SimpleDateFormat(Utility.DATE_FORMAT).parse(dobstr);
		System.out.println("Please enter your gender: ");
		String gender = scanner.nextLine();
		boolean valueGender = Boolean.parseBoolean(gender);
		System.out.println("Please enter your phone number: ");
		String phone = scanner.nextLine();
		System.out.println("Please enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Please enter your address: ");
		String address = scanner.nextLine();
		
		for(Lead lead: leads) {
			if(lead.getId().equals(id)) {
				lead.setName(name);
				lead.setDob(dob);
				lead.setGender(valueGender);
				lead.setPhone(phone);
				lead.setEmail(email);
				lead.setAddress(address);
				
				updated = true;
				break;
			}
		}
					
		leadRepository.write(getLeads());
	}
	
	public void delete() throws FileNotFoundException {
		System.out.println("Select input ID you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		boolean deleted = false;
		//delete in the memory
		for(Lead lead: leads) {
			if(lead.getId().equals(id)) {
				leads.remove(lead);
				deleted = true;
				break;
			}
		}
		
		
		leadRepository.write(getLeads());
		System.out.println(deleted? "Id " + id + " has been deleted." : "Id " + id  + " not found.");
	}
	
	public ArrayList<Lead> getLeads() {
		return leads;
	}
	public void setLeads(ArrayList<Lead> leads) {
		this.leads = leads;
	}

}
