package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<TeamMember> team;

    public static void main(String[] args)
    {
        team = new ArrayList<TeamMember>();
        Scanner input = new Scanner(System.in);

	    System.out.println("This better work.");
	    System.out.print("\n\n\n\n\n\n\n\n\n");
	    printLogo();
	    System.out.println("\n\n\t\t\t\t Press Enter to Start");
	    input.nextLine();
        printMainMenu();
        System.out.println("Loading...");
        TeamMember jim = new TeamMember("Jim Whatshisname", 1, 1);
        jim.setHeartrate(TeamMember.HEARTRATE_SUPERHIGH);
        jim.setSoundLevel(TeamMember.SOUNDLEVEL_HIGH);
        TeamMember joe = new TeamMember("Joe PleaseDon'tDieHere", 2, 2);
        joe.setHeartrate(TeamMember.HEARTRATE_NONE);
        joe.setSoundLevel(TeamMember.SOUNDLEVEL_MAX);
        TeamMember josh = new TeamMember("Josh Whatshisname", 3, 3);
        josh.setHeartrate(TeamMember.HEARTRATE_HIGH);
        josh.setSoundLevel(TeamMember.SOUNDLEVEL_MEDIUM);
        TeamMember jay = new TeamMember("Jay Whatthehellarewedoing", 4, 4);
        jay.setHeartrate(TeamMember.HEARTRATE_NORMAL);
        jay.setSoundLevel(TeamMember.SOUNDLEVEL_MIN);
        TeamMember judy = new TeamMember("Judy Wherearewegoing", 5, 5);
        judy.setSoundLevel(TeamMember.SOUNDLEVEL_LOW);

        team.add(jim);
        team.add(joe);
        team.add(josh);
        team.add(jay);
        team.add(judy);
        printAllReadouts(team);
        printRadioMessages(team);
        printMenu();

        input.close();

    }

    private static void printLogo()
    {
        System.out.println(" __    __   ______   ______   _____    _________   _____    ______   ______   _________  \n" +
                         "|  |  |  | |  ____| |  __  | |  __  \\ |___   ___| |  __  \\ |  ____| |  __  | |___   ___| \n" +
                         "|  |__|  | | |____  | |__| | | |__|_|     | |     | |__| | | |____  | |__| |     | |     \n" +
                         "|   __   | |  ____| |  __  | |  __|_      | |     |  __  | |  ____| |  __  |     | |     \n" +
                         "|  |  |  | | |____  | |  | | | |  | |     | |     | |__| | | |____  | |  | |     | |     \n" +
                         "|__|  |__| |______| |_|  |_| |_|  |_|     |_|     |_____/  |______| |_|  |_|     |_|     ");
    }

    private static void printSingleReadout(String[] in)
    {
        for (String a: in)
        {
            System.out.println(a);
        }
    }

    private static void printAllReadouts(ArrayList<TeamMember> team)
    {
        int lines = (int) Math.ceil(((double) team.size()) / 3.0);
        System.out.print(lines);

        TeamMember[][] teamTrios= new TeamMember[lines][3];
        int k = 0;
        int currentTrio = 0;
        for (TeamMember u:team)
        {
            teamTrios[currentTrio][k] = u;

            k++;
            if(k%3 == 0)
            {
                k = 0;
                currentTrio++;
            }
        }





        for(int j = 0; j < lines; j++)
        {
            String[] output = new String[10];
            output[0] = "";
            output[1] = "";
            output[2] = "";
            output[3] = "";
            output[4] = "";
            output[5] = "";
            output[6] = "";
            output[7] = "";
            output[8] = "";
            output[9] = "";

            for (TeamMember member : teamTrios[j])
            {
                if(member == null){break;}
                // ^ foreach runs through every slot in the array, regardless of whether or not any slots are null.
                // ^ This if statement catches the last trio when the last trio is not a complete trio of team member,
                // ^ e.g. 7 team members total would leave 2 complete trios and 1 trio of 1 team member.
                String[] readout = member.getReadout();
                output[0] += "\t" + readout[0];
                output[1] += "\t" + readout[1];
                output[2] += "\t" + readout[2];
                output[3] += "\t" + readout[3];
                output[4] += "\t" + readout[4];
                output[5] += "\t" + readout[5];
                output[6] += "\t" + readout[6];
                output[7] += "\t" + readout[7];
                output[8] += "\t" + readout[8];
                output[9] += "\t" + readout[9];

            }

            for (String a: output)
            {
                System.out.println(a);
            }
        }

    }

    private static void printMainMenu()
    {
        System.out.println("__________\n\n" + "MainMenu\n" + "__________");
    }

    private static void printRadioMessages(ArrayList<TeamMember> team)
    {
        System.out.println(" _________________________________________________ ");
        System.out.println("|  ");
        for (TeamMember aMember:team)
        {
            System.out.print("|  ");
            aMember.printRadio();
            System.out.println("|  ");
        }
        System.out.println("|_________________________________________________ ");
    }

    private static void printMenu()
    {
        System.out.println("1. \t ");
    }

    private static void shiftTeamMemberToBack(TeamMember memberToMove)
    {
        //TODO: move team member to back logic
    }

    private static void shiftTeamMemberToFront(TeamMember memberToMove)
    {
        //TODO: move team member to front logic
    }
}
