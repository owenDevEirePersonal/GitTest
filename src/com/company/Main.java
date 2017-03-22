package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

	    System.out.println("This better work.");
	    System.out.print("\n\n\n\n\n\n\n\n\n");
	    printLogo();
	    System.out.println("\n\n\t\t\t\t Press Enter to Start");
	    input.nextLine();
        printMenu();
        System.out.println("Loading...");
        TeamMember jim = new TeamMember("Jim Whatshisname", 1);
        printReadout(jim.getReadout());


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

    private static void printReadout(String[] in)
    {
        for (String a: in)
        {
            System.out.println(a);
        }
    }

    private static void printMenu()
    {
        System.out.println("__________\n\n" + "MainMenu\n" + "__________");
    }
}
