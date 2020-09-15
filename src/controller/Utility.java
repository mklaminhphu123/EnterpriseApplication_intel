package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utility {
	public static final String LEAD_FILE = "TestData\\leads.csv";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String INTERACTION_FILE = "TestData\\interactions.csv";
	public static final LocalDateTime NOW = LocalDateTime.now();
	public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

}
