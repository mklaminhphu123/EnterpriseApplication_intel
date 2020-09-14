package controller;

import java.time.LocalDateTime;

public class Utility {
	public static final String LEAD_FILE = "E:\\Programing\\Java\\Assignment_2020\\TestData\\leads.csv";
	public static final String DATE_FORMAT = "yyyy-mm-dd";
	public static String generateID(int size)
	{
		return "lead_" + String.format("%03d", size+1);
	}
	public static final String INTERACTION_FILE = "E:\\Programing\\Java\\Assignment_2020\\TestData\\interactions.csv";
	public static final LocalDateTime NOW = LocalDateTime.now();
	public static String generateID2(int size)
	{
		return "inter_" + String.format("%03d", size+1);
	}
}
