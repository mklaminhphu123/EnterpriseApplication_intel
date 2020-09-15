package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import model.Interaction;
import model.Lead;
import model.Potential;

public class ReportingManagement {
	public Map<String, String> reportLeadByAge(ArrayList<Lead> leads){
		SimpleDateFormat formatter = new SimpleDateFormat(Utility.DATE_FORMAT);  
	    Date now = new Date();
	    
	    int from0To10 = 0;
	    int from10To20 = 0;
	    int from20To60 = 0;
	    int over60 = 0;
	    
		for(Lead lead: leads) {
			int age = now.getYear() - lead.getDob().getYear();
			if(age <= 10) {
				from0To10 ++;
			}else if(age >10 && age <= 20){
				from10To20 ++;
			}else if(age >20 && age <= 60){
				from20To60 ++;
			}else{
				over60 ++;
			}
		}
		Map<String, String> map = new TreeMap<String, String>();
		map.put("0-10  (years old)", from0To10 + "");
		map.put("10-20 (yrs old)", from10To20 + "");
		map.put("20-60 (yrs old)", from20To60 + "");
		map.put("Over 60 (yrs old)", over60 + "");
		
		return map;
	}

	public void reportInterByPotential(ArrayList<Interaction> interactions) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		int positive = 0;
		int negative = 0;
		int neutral = 0;
		System.out.println("Start date(yyyy-mm-dd): ");
		String start = scanner.nextLine();
		Date startDate = new SimpleDateFormat(Utility.DATE_FORMAT).parse(start);
		System.out.println("End date(yyyy-mm-dd): ");
		String end = scanner.nextLine();
		Date endDate = new SimpleDateFormat(Utility.DATE_FORMAT).parse(end);

		ArrayList<Interaction> validInteractions = new ArrayList<>();
		for (Interaction interaction : interactions) {
			if (startDate.before(interaction.getDateOfInteraction())
					&& endDate.after(interaction.getDateOfInteraction())) {
				validInteractions.add(interaction);
				if(interaction.getPotential() == Potential.POSITIVE) {
					positive ++;
				}else if(interaction.getPotential() == Potential.NEGATIVE){
					negative ++;
				}else if(interaction.getPotential() == Potential.NEUTRAL){
					neutral ++;
				}
			}
		}
		System.out.println("Input: " + startDate + "- "+endDate);

		String leftAlignFormat = "| %-18s | %-4s |%n";

		System.out.format("+--------------------+------+%n");
		System.out.format("| Potentials         | Total|%n");
		System.out.format("+--------------------+------+%n");
		System.out.format(leftAlignFormat, "Positive", positive);
		System.out.format(leftAlignFormat, "Neutral", neutral);
		System.out.format(leftAlignFormat, "Negative", negative);
		System.out.format("+--------------------+------+%n");
	}
	public void reportInterByMonths(ArrayList<Interaction> interactions) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Start date(yyyy-mm-dd): ");
		String start = scanner.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Utility.DATE_FORMAT);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Utility.DATE_FORMAT);
		LocalDate startDate = LocalDate.parse(start, formatter);
		System.out.println("End date(yyyy-mm-dd): ");
		String end = scanner.nextLine();
		LocalDate endDate = LocalDate.parse(end, formatter);
		Map<String, Integer> map = new TreeMap<>();
		for (Interaction interaction : interactions) {
			for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusMonths(1)) {
				LocalDate startTime = LocalDate.of(date.getYear(), date.getMonth(), 1);
				LocalDate endTime = LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());

				LocalDate currentTime = Utility.convertToLocalDateViaMilisecond(interaction.getDateOfInteraction());

				if (startTime.isBefore(currentTime) && endTime.isAfter(currentTime)) {
					String key = simpleDateFormat.format(interaction.getDateOfInteraction());
					if(map.containsKey(key)){
						map.replace(key, map.get(key) + 1);
					}else{
						map.put(key, 1);
					}

				}
			}


		}
		String leftAlignFormat = "| %-18s | %-4s |%n";
		System.out.format("+--------------------+------+%n");
		System.out.format("| Month         | Total|%n");
		System.out.format("+--------------------+------+%n");
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			System.out.format(leftAlignFormat, m.getKey(), m.getValue().toString());
		}
		System.out.format("+--------------------+------+%n");


	}
}
