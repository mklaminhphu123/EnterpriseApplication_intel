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
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

		File file = new File(path + "\\" + filename);
		Scanner scanner = new Scanner(file);
		return scanner;
	}

	@Override
	public void disconnect(Scanner scanner) {
		// TODO Auto-generated method stub
		scanner.close();
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
				Interaction interaction = new Interaction(temp[0],
						new SimpleDateFormat(Utility.DATE_FORMAT).parse(temp[1]),
						temp[2],ContactMethod.valueOf(temp[3]),Potential.valueOf(temp[4]));
				result.add(interaction);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.disconnect(scanner);
		return result;
	}
	
	public void write(ArrayList<Interaction> interactions) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

		File file = new File(path + "\\" + filename);
		PrintWriter printWriter = new PrintWriter(file);
		DateFormat dateFormat = new SimpleDateFormat(Utility.DATE_FORMAT);

		for(Interaction interaction: interactions) {
			String tempToWrite = interaction.getId() + "," +
					dateFormat.format(interaction.getDateOfInteraction()) + "," +
					interaction.getLeadID() + "," + interaction.getContact() + ","
					+ interaction.getPotential();
			printWriter.println(tempToWrite);
		}
		printWriter.close();

	}

}
