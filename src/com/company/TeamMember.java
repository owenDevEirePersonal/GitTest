package com.company;

/**
 * Created by owenryan on 21/03/2017.
 */
public class TeamMember
{
    private int id;
    private String name;
    private int health;
    private int heartrate;
    private int soundLevel;
    private int fireMode;
    private int weapon;
    private int ammo;
    private String nextOrder;

    protected final static int FIREMODE_CLOSE = 1;
    protected final static int FIREMODE_MEDIUM = 2;
    protected final static int FIREMODE_LONG = 3;

    protected final static int HEARTRATE_SUPERHIGH = 200;
    protected final static int HEARTRATE_HIGH = 120;
    protected final static int HEARTRATE_NORMAL = 60;
    protected final static int HEARTRATE_NONE = 0;

    protected final static int WEAPON_RIFLE = 3;
    protected final static int WEAPON_CARBINE = 2;
    protected final static int WEAPON_SHOTGUN = 1;

    protected final static int WEAPON_RIFLE_MAXAMMO = 8;
    protected final static int WEAPON_CARBINE_MAXAMMO = 8;
    protected final static int WEAPON_SHOTGUN_MAXAMMO = 6;

    //[Constructors]
    public TeamMember(String inName, int inId)
    {
        id = inId;
        name = inName;
        health = 3;
        heartrate = HEARTRATE_NORMAL;
        soundLevel = 0;
        fireMode = FIREMODE_MEDIUM;
        weapon = WEAPON_CARBINE;
        ammo = WEAPON_CARBINE_MAXAMMO;
        nextOrder = "HOLD POSITION";
    }

    public TeamMember(String inName, int inId, int weaponIn)
    {
        id = inId;
        name = inName;
        health = 3;
        heartrate = HEARTRATE_NORMAL;
        soundLevel = 0;
        fireMode = FIREMODE_MEDIUM;
        switch(weaponIn)
        {
            case WEAPON_SHOTGUN: weapon = WEAPON_SHOTGUN; ammo = WEAPON_SHOTGUN_MAXAMMO; break;
            case WEAPON_CARBINE: weapon = WEAPON_CARBINE; ammo = WEAPON_CARBINE_MAXAMMO; break;
            case WEAPON_RIFLE: weapon = WEAPON_RIFLE; ammo = WEAPON_RIFLE_MAXAMMO; break;
            default: System.out.println("ERROR: unable to create TeamMember " + inName + " with ID: " + inId + " . Reason: Invalid Weapon."); break;
        }
        nextOrder = "HOLD POSITION";
    }

    public TeamMember(String inName, int inId, int inHealth, int inHeartrate, int inSoundLevel, int inFireMode, int weaponIn, String inNextOrder)
    {
        id = inId;
        name = inName;
        health = inHealth;
        heartrate = inHeartrate;
        soundLevel = inSoundLevel;
        fireMode = inFireMode;
        switch(weaponIn)
        {
            case WEAPON_SHOTGUN: weapon = WEAPON_SHOTGUN; ammo = WEAPON_SHOTGUN_MAXAMMO; break;
            case WEAPON_CARBINE: weapon = WEAPON_CARBINE; ammo = WEAPON_CARBINE_MAXAMMO; break;
            case WEAPON_RIFLE: weapon = WEAPON_RIFLE; ammo = WEAPON_RIFLE_MAXAMMO; break;
            default: System.out.println("ERROR: unable to create TeamMember " + inName + " with ID: " + inId + " . Reason: Invalid Weapon."); break;
        }
        nextOrder = inNextOrder;
    }
    //[/Constructors]

    public String[] getReadout()
    {
        String[] readoutLines = new String[10];


        readoutLines[0] = " ____________________________________________";
        readoutLines[1] = "|                          | |               |";
        readoutLines[2] = "|               /|         | |               |";
        readoutLines[3] = "|    /|        / |        /| |               |";
        readoutLines[4] = "|   / |       /  |       / | |  ___          |";
        readoutLines[5] = "|__/  |______/   | _____/  | | |___|___ ___  |";//bpm counter = [1] to [26], volume meter = [31] to [45]
        readoutLines[6] = "| Bpm            |/        | |_|___|___|___|_|";
        readoutLines[7] = "|__________________________|_|_______________|";
        readoutLines[8] = "| placeholderName                            |"; //43 characters
        readoutLines[9] = "|____________________________________________|";


        readoutLines[8] = "| " + name;
        for(int i = name.length(); i < 43; i++)
        {
            readoutLines[8] += " ";
        }
        readoutLines[8] += "|";


        //[BPM Display Modifier]

        /* Normal
          "|                          |
          "|               /|         |
          "|    /|        / |        /|
          "|   / |       /  |       / |
          "|__/  |______/   | _____/  |
          "| Bpm            |/        |

          High
          "|             /|        /| |
          "|     /|     / |       / | |
          "|    / |    /  |      /  | |
          "|___/  | __/   |   __/   | |
          "|      |/      | _/      | |
          "| Bpm          |/        |/|

          Super High
          "|   /|    /|    |          |
          "|  / |   / |   /|    /|    |
          "| /  |  /  |  | |   / |   /|
          "|/   | /   | /  |  /  |  / |
          "|    |/    ||   | /   | /  |
          "| Bpm      |/   |/    |/   |

          None
          "|                          |
          "|                          |
          "|                          |
          "|                          |
          "|_______________________/\_|
          "| Bpm                      |

         */

        if(heartrate >= HEARTRATE_SUPERHIGH)
        {
            readoutLines[1] = readoutLines[1].replace("|                          ", "|   /|    /|    |          ");
            readoutLines[2] = readoutLines[2].replace("|               /|         ", "|  / |   / |   /|    /|    ");
            readoutLines[3] = readoutLines[3].replace("|    /|        / |        /", "| /  |  /  |  | |   / |   /");
            readoutLines[4] = readoutLines[4].replace("|   / |       /  |       / ", "|/   | /   | /  |  /  |  / ");
            readoutLines[5] = readoutLines[5].replace("|__/  |______/   | _____/  ", "|    |/    ||   | /   | /  ");
            readoutLines[6] = readoutLines[6].replace("| Bpm            |/        ", "| Bpm      |/   |/    |/   ");
        }
        else if(heartrate >= HEARTRATE_HIGH)
        {
            readoutLines[1] = readoutLines[1].replace("|                          ", "|             /|        /| ");
            readoutLines[2] = readoutLines[2].replace("|               /|         ", "|     /|     / |       / | ");
            readoutLines[3] = readoutLines[3].replace("|    /|        / |        /", "|    / |    /  |      /  | ");
            readoutLines[4] = readoutLines[4].replace("|   / |       /  |       / ", "|___/  | __/   |   __/   | ");
            readoutLines[5] = readoutLines[5].replace("|__/  |______/   | _____/  ", "|      |/      | _/      | ");
            readoutLines[6] = readoutLines[6].replace("| Bpm            |/        ", "| Bpm          |/        |/");
        }
        else if(heartrate >= HEARTRATE_NORMAL)
        {
            //readout deaults to normal heartrate.
        }
        else if(heartrate <= HEARTRATE_NONE)
        {
            readoutLines[1] = readoutLines[1].replace("|                          ", "|                          ");
            readoutLines[2] = readoutLines[2].replace("|               /|         ", "|                          ");
            readoutLines[3] = readoutLines[3].replace("|    /|        / |        /", "|                          ");
            readoutLines[4] = readoutLines[4].replace("|   / |       /  |       / ", "|                          ");
            readoutLines[5] = readoutLines[5].replace("|__/  |______/   | _____/  ", "|_______________________/\\_");
            readoutLines[6] = readoutLines[6].replace("| Bpm            |/        ", "| Bpm                      ");
        }

        //[/BPM Display Modifier]


        return readoutLines;
    }


    //[Getters and Setters]
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int newHealth)
    {
        health = newHealth;
    }

    public int getHeartrate()
    {
        return heartrate;
    }

    public void setHeartrate(int newRate)
    {
        heartrate = newRate;
    }

    public int getSoundLevel()
    {
        return soundLevel;
    }

    public void setSoundLevel(int newSoundLevel)
    {
        soundLevel = newSoundLevel;
    }

    public int getFireMode()
    {
        return fireMode;
    }

    public void setFireMode(int newMode)
    {
        if(newMode == FIREMODE_CLOSE || newMode == FIREMODE_MEDIUM || newMode == FIREMODE_LONG)
        {
            fireMode = newMode;
        }
        else
        {
            System.out.println("ERROR: Unable to change FireMode for team Member " + name + " because " + newMode + " is not a firemode.");
        }
    }

    public int getWeapon()
    {
        return weapon;
    }

    public void setWeapon(int newMode)
    {
        if(newMode == WEAPON_SHOTGUN || newMode == WEAPON_CARBINE || newMode == WEAPON_RIFLE)
        {
            weapon = newMode;
        }
        else
        {
            System.out.println("ERROR: Unable to change weapon for team Member " + name + " because " + newMode + " is not a weapon.");
        }
    }

    public int getCurrentAmmo()
    {
        return ammo;
    }

    public void setCurrentAmmo(int newAmmo)
    {
        switch(weapon)
        {
            case WEAPON_SHOTGUN: if(newAmmo > WEAPON_SHOTGUN_MAXAMMO) { ammo = newAmmo; }
                                 else {System.out.println("ERROR: Unable to update ammo for team Member " + name + " because the entered ammount exceeds the max ammo");}
                break;
            case WEAPON_CARBINE: if(newAmmo > WEAPON_CARBINE_MAXAMMO) { ammo = newAmmo; }
                                 else {System.out.println("ERROR: Unable to update ammo for team Member " + name + " because the entered ammount exceeds the max ammo");}
                break;
            case WEAPON_RIFLE: if(newAmmo > WEAPON_RIFLE_MAXAMMO) { ammo = newAmmo; }
                                 else {System.out.println("ERROR: Unable to update ammo for team Member " + name + " because the entered ammount exceeds the max ammo");}
                break;
        }
    }

    public String getNextOrder()
    {
        return nextOrder;
    }

    public void setNextOrder(String newOrder)
    {
        if(newOrder.matches("HOLD POSITION")
                || newOrder.matches("HOLD FIRE")
                || newOrder.matches("ADVANCE")
                || newOrder.matches("RETREAT")
                || newOrder.matches("MOVE TO FRONT")
                || newOrder.matches("MOVE TO BACK")
                || newOrder.matches("CHECK POSITIONING")
                || newOrder.matches("CHECK TEAM")
                || newOrder.matches("CHECK SELF")
                || newOrder.matches("CHECK AREA")
                || newOrder.matches("LISTEN")
                || newOrder.matches("CALM SELF")
                || newOrder.matches("SWAP TO SINGLE SHOT")
                || newOrder.matches("SWAP TO CONTROLLED BURSTS")
                || newOrder.matches("SWAP TO FREE FIRE")
                || newOrder.matches("ENGAGE")
                || newOrder.matches("RELOAD")
                || newOrder.matches("NO ORDER"))
        {
            nextOrder = newOrder;
        }
        else
        {
            System.out.println("ERROR: Unable to issue order to team member " + name + ", " + newOrder + " does not match any known order.");
        }
    }
    //[/Getters and Setters]



}
