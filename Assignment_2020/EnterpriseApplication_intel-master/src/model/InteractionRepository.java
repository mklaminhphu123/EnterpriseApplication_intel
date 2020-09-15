package model;

import controller.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class InteractionRepository implements Repository{

	private String filename;
	public InteractionRepository(String filename) {
		this.filename = filename;
	}

	@Override
	public Scanner connect() throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		return null;
	}

	@Override
	public void disconnect(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList read() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Interaction> result = new ArrayList<Interaction>();
		Scanner scanner = this.connect();
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] temp  = line.split(",");
			try {
				Interaction interaction = new Interaction(temp[0],new SimpleDateFormat(Utility.DATE_FORMAT).parse(temp[1]),temp[2],temp[3],temp[4],temp[5]);
				result.add(interaction);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void write(ArrayList<Interaction> interactions) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(filename);
		PrintWriter printWriter = new PrintWriter(file);
		DateFormat dateFormat = new SimpleDateFormat(Utility.DATE_FORMAT);

		for(Interaction interaction: interactions) {

			String tempToWrite = interaction.getIdIn() + "," + dateFormat.format(interaction.getDateOfInteraction()) + "," +  interaction.getLeadID() + "," + interaction.getContact() + "," + interaction.getAddress() + "\n";
			printWriter.print(tempToWrite);
		}
		printWriter.close();

	}

}
