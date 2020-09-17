package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Interaction;
import model.Lead;

public class CRMProgram {
	private static Scanner scanner = new Scanner(System.in);
	private static LeadManagement leadManagement = new LeadManagement();
	private static ReportingManagement reportingManagement = new ReportingManagement();
	private static InteractionManagement interactionManagement = new InteractionManagement();
	//main function
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		String cont = "Y";
		System.out.println("***Welcome to our Customer Relationship Management***");
		leadManagement.read();
		interactionManagement.read();
		
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
					manageInteraction();
					break;
				}
				case 3:
				{	reportDisplay();
					break;
				}
			}
			 scanner.nextLine();
			System.out.println("Do you want to continue? Press Y to continue");
			cont = scanner.nextLine();
			
		}while(cont.equalsIgnoreCase("Y"));
		
		//leadManagement.add();
	}
	
	public static void manageLead() throws FileNotFoundException, ParseException {
		System.out.println("1. View Leads list" + "\n"+
							"2. Add a new lead information" + "\n" +
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
	public static void reportDisplay() throws ParseException {
		System.out.println("1. Number of leads by ages" + "\n"+
				"2. Number of interactions by potentials" + "\n" +
				"3. Number of interactions by months" );
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
				reportingManagement.reportInterByPotential(interactionManagement.getInteractions());
				break;
			}
			case 3:
			{
				reportingManagement.reportInterByMonths((interactionManagement.getInteractions()));
				break;
			}
			
		}
	}
	public static void manageInteraction() throws FileNotFoundException, ParseException {
		System.out.println("1. View Interactions list" + "\n"+
				"2. Add a new interaction information" + "\n" +
				"3. Delete an interaction" + "\n"
				+ "4. Update an interaction");
		int choose = scanner.nextInt();
		switch (choose) {
			case 1: {
				for(Interaction interaction:interactionManagement.getInteractions()) {
					System.out.println(interaction);
				}
				break;
			}
			case 2:
			{
				addInteraction();
				break;
			}
			case 3:
			{
				interactionManagement.delete();
				break;
			}
			case 4:{
				interactionManagement.update();
				break;
			}
		}

	}
	public static void addInteraction() throws ParseException, FileNotFoundException {
		interactionManagement.add();
	}
}
