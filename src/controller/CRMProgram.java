package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Lead;
import model.LeadRepository;

public class CRMProgram {
	private static Scanner scanner = new Scanner(System.in);
	private static LeadManagement leadManagement = new LeadManagement();
	private static ReportingManagement reportingManagement = new ReportingManagement();
	//main function
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		String cont = "Y";
		System.out.println("***Welcome to our Customer Relationship Management***");
		leadManagement.read();
		
		do {
			System.out.println("What do you want to do" + "\n"
								+ "1. Managing Leads" + "\n"
								+ "2. Managing Interactions" + "\n"
								+ "3. Reporting and statistics");
			int choose = scanner.nextInt();
			
			switch (choose) {
				case 1: {
					manageLead();
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{	reportDisplay();
					break;
				}
			}
			 scanner.nextLine();
			System.out.println("Do you want to continue? Y/N");
			cont = scanner.nextLine();
			
		}while(cont.equalsIgnoreCase("Y"));
		
		//leadManagement.add();
	}
	
	public static void manageLead() throws FileNotFoundException, ParseException {
		System.out.println("1. View list of Leads" + "\n"+ 
							"2. Add new lead information" + "\n" +
							"3. Delete a lead" + "\n"
							+ "4. Update a lead");
		int choose = scanner.nextInt();
		switch (choose) {
			case 1: {				
				for(Lead lead:leadManagement.getLeads()) {
					System.out.println(lead);
				}
				break;
			}
			case 2:
			{
				addLead();
				break;
			}
			case 3:
			{
				leadManagement.delete();
				break;
			}
			case 4:{
				leadManagement.update();
				break;
			}
		}
		
	}
	public static void addLead() throws ParseException, FileNotFoundException {
		leadManagement.add();
	}
	public static void reportDisplay() {
		System.out.println("1. Display a summary report that contains all number of leads by ages" + "\n"+ 
				"2. Display a summary report that contains all number of interactions by potential" + "\n" +
				"3. Display a summary report that contains all number of interactions by month" );
		int choose = scanner.nextInt();
		switch (choose) {
			case 1: {				
				Map<String, String> maps = reportingManagement.reportLeadByAge(leadManagement.getLeads());

				String leftAlignFormat = "| %-18s | %-4s |%n";

				System.out.format("+--------------------+------+%n");
				System.out.format("| Age range          | Total|%n");
				System.out.format("+--------------------+------+%n");
				for(Entry<String, String> map : maps.entrySet()) {
					System.out.format(leftAlignFormat, map.getKey(), map.getValue().toString());
				}

				System.out.format("+--------------------+------+%n");

//				String head = "";
//				String row = "";
//				for(Entry<String, String> map : maps.entrySet()) {
//					head += "\t" + map.getKey();
//					row += "\t" + map.getValue();
//				}
//
//				System.out.println(head);
//				System.out.println(row);
				break;
			}
			case 2:
			{
				break;
			}
			case 3:
			{
				break;
			}
			
		}
	}
}
