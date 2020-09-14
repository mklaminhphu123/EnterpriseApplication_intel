package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Utility;

public class LeadRepository implements Repository{
	private String filename;
	public LeadRepository(String filename) {
		this.filename = filename;
	}
	
	public Scanner connect() throws FileNotFoundException {
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

		File file = new File(path + "\\" + filename);
		Scanner scanner = new Scanner(file);
		return scanner;
	}
	
	public void disconnect(Scanner scanner) {
		
	}
	
	public ArrayList<Lead> read() throws FileNotFoundException {
		ArrayList<Lead> result = new ArrayList<Lead>();
		Scanner scanner = this.connect();
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] temp  = line.split(",");
			try {
				Lead lead = new Lead(temp[0], temp[1],new SimpleDateFormat(Utility.DATE_FORMAT).parse(temp[2]),
						Boolean.parseBoolean(temp[3]), temp[4], temp[5], temp[6]);
				result.add(lead);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}

	
	public void write(ArrayList<Lead> leads) throws FileNotFoundException {
		File file = new File(filename);
		PrintWriter printWriter = new PrintWriter(file);
		DateFormat dateFormat = new SimpleDateFormat(Utility.DATE_FORMAT);  
          
		for(Lead lead: leads) {
			
			String tempToWrite = lead.getId() + "," +lead.getName() + "," +  dateFormat.format(lead.getDob()) + "," + lead.isGender() + "," + lead.getPhone() +
					"," + lead.getEmail() + "," + lead.getAddress() + "\n";
			printWriter.print(tempToWrite);
		}
		printWriter.close();
	}

	
}
