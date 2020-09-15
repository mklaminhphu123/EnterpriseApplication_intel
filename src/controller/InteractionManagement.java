package controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Interaction;
import model.InteractionRepository;

import controller.Utility;

import java.io.FileNotFoundException;

public class InteractionManagement
{
    public void add() throws ParseException, FileNotFoundException
    {
        LocalDateTime doi = Utility.NOW;
        Scanner target = new Scanner(System.in);

        System.out.println("Please select your target lead id: ");
        int targetLead = target.nextInt();

        System.out.println("Please select contact method: ");
        int conMeth = -1;
        while(conMeth != 1 || conMeth != 2)
        {
            System.out.println("Press 1 for Email or 2 for Phone");
            conMeth = target.nextInt();
            if(conMeth == 1)
            {
                //Choose email as contact
                break;
            }
            else if(conMeth == 2)
            {
                //Choose phone as contact
                break;
            }
            else
            {
                System.out.println("Please choice 1 or 2");
            }
        }

        System.out.println("What type of Potential is this Lead: ");
        int targetPotential = -1;
        while(targetPotential != 1 || targetPotential !=2 || targetPotential != 3)
        {
            System.out.println("Press 1 for Positive, 2 for Neutral and 3 for Negative ");
            targetPotential = target.nextInt();
            if(targetPotential == 1)
            {
                //Set as Positive
                break;
            }
            else if(targetPotential == 2)
            {
                //Set as Neutral
                break;
            }
            else if(targetPotential == 3)
            {
                //Set as Negative
                break;
            }
            else
            {
                System.out.println("Please try again");
            }
        }


    }
}