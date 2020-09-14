package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import model.Lead;

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
}
