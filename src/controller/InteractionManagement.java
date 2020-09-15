package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.*;

public class InteractionManagement
{
    private InteractionRepository interactionRepository = new InteractionRepository(Utility.INTERACTION_FILE);
    private ArrayList<Interaction> interactions = new ArrayList<Interaction>();

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public void read() throws FileNotFoundException {
        this.interactions = interactionRepository.read();
    }
    public void add() throws ParseException, FileNotFoundException
    {
        LocalDateTime dateOfInteraction = Utility.NOW;
        Scanner target = new Scanner(System.in);

        System.out.println("Please enter your lead id: ");
        String targetLead = target.nextLine();

        System.out.println("Please select contact method: ");
        int conMeth = -1;

        System.out.println("1. Email");
        System.out.println("2. Phone");
        System.out.println("3. Face to Face");
        System.out.println("4. Social Media");
        conMeth = target.nextInt();
        ContactMethod contactMethodValue = ContactMethod.values()[conMeth];

        System.out.println("Which type of Potential is this Lead: ");
        int targetPotential = -1;
        System.out.println("1. Positive");
        System.out.println("2. Neutral");
        System.out.println("3. Negative");
        targetPotential =  target.nextInt();
        Potential interactPotential = Potential.values()[targetPotential];
        int lastId = Integer.parseInt(interactions.get(interactions.size() - 1).getId().substring(4,7)) +1;
        ZonedDateTime zdt = dateOfInteraction.atZone(ZoneId.systemDefault());
        Interaction interaction = new Interaction( Date.from(zdt.toInstant()),
                targetLead + "",contactMethodValue,
                interactPotential);
        interaction.setId(generateId(lastId));
        this.interactions.add(interaction);
        interactionRepository.write(getInteractions());
    }

    private String generateId(int size)
    {
        return "inter_" + String.format("%03d", size);
    }

    public void delete() throws FileNotFoundException {
        System.out.println("Select input ID you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        boolean deleted = false;
        //delete in the memory
        for (Interaction interaction : interactions) {
            if (interaction.getId().equals(id)) {
                interactions.remove(interaction);
                deleted = true;
                break;
            }
        }
    }
    public void update() throws ParseException, FileNotFoundException {
        System.out.println("Select input ID you want to update: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        boolean update = false;

        Scanner target = new Scanner(System.in);

        System.out.println("Please enter your lead id: ");
        String targetLead = target.nextLine();

        System.out.println("Please select contact method: ");
        int conMeth = -1;

        System.out.println("1. Email");
        System.out.println("2. Phone");
        System.out.println("3. Face to Face");
        System.out.println("4. Social Media");
        conMeth = target.nextInt();
        ContactMethod contactMethodValue = ContactMethod.values()[conMeth];
        System.out.println("Which type of Potential is this Lead: ");
        int targetPotential = -1;
        System.out.println("1. Positive");
        System.out.println("2. Neutral");
        System.out.println("3. Negative");
        targetPotential =  target.nextInt();
        Potential interactPotential = Potential.values()[targetPotential];
        for (Interaction interaction:interactions){
            if(interaction.getId().equals(id)){
                interaction.setContact(contactMethodValue);
                interaction.setLeadID(targetLead);
                interaction.setPotential(interactPotential);
                update = true;
                break;
            }
        }
        interactionRepository.write(getInteractions());
    }
}