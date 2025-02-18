import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ghame {

    // hashmap is used to store registered user (username and password) // 
    // reference take from  ( https://www.w3schools.com/java/java_hashmap.asp )// 

    static HashMap<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Introduction PAGE/Interface that user will see // 
        // this text was made from the website (https://www.asciiart.eu/) // 

        System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\r\n" + //
        "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\r\n" + //
        "/\\    █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████            /\\\r\n" + //
        "\\/   ▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒          \\/\r\n" + //
        "/\\   ▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒          /\\\r\n" + //
        "\\/   ░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░          \\/\r\n" + //
        "/\\   ░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░          /\\\r\n" + //
        "\\/   ░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░           \\/\r\n" + //
        "/\\     ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░           /\\\r\n" + //
        "\\/     ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒            \\/\r\n" + //
        "/\\       ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░            /\\\r\n" + //
        "\\/                           ░                                                                  \\/\r\n" + //
        "/\\▄▄▄█████▓ ██░ ██ ▓█████     ▒█████  ▓█████▄▓██   ██▓  ██████   ██████ ▓█████▓██   ██▓         /\\\r\n" + //
        "\\/▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▒██▒  ██▒▒██▀ ██▌▒██  ██▒▒██    ▒ ▒██    ▒ ▓█   ▀ ▒██  ██▒         \\/\r\n" + //
        "/\\▒ ▓██░ ▒░▒██▀▀██░▒███      ▒██░  ██▒░██   █▌ ▒██ ██░░ ▓██▄   ░ ▓██▄   ▒███    ▒██ ██░         /\\\r\n" + //
        "\\/░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒██   ██░░▓█▄   ▌ ░ ▐██▓░  ▒   ██▒  ▒   ██▒▒▓█  ▄  ░ ▐██▓░         \\/\r\n" + //
        "/\\  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ░ ████▓▒░░▒████▓  ░ ██▒▓░▒██████▒▒▒██████▒▒░▒████▒ ░ ██▒▓░         /\\\r\n" + //
        "\\/  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░ ▒░▒░▒░  ▒▒▓  ▒   ██▒▒▒ ▒ ▒▓▒ ▒ ░▒ ▒▓▒ ▒ ░░░ ▒░ ░  ██▒▒▒          \\/\r\n" + //
        "/\\    ░     ▒ ░▒░ ░ ░ ░  ░     ░ ▒ ▒░  ░ ▒  ▒ ▓██ ░▒░ ░ ░▒  ░ ░░ ░▒  ░ ░ ░ ░  ░▓██ ░▒░          /\\\r\n" + //
        "\\/  ░       ░  ░░ ░   ░      ░ ░ ░ ▒   ░ ░  ░ ▒ ▒ ░░  ░  ░  ░  ░  ░  ░     ░   ▒ ▒ ░░           \\/\r\n" + //
        "/\\          ░  ░  ░   ░  ░       ░ ░     ░    ░ ░           ░        ░     ░  ░░ ░              /\\\r\n" + //
        "\\/                                     ░      ░ ░                              ░ ░              \\/\r\n" + //
        "/\\ ▒█████    █████▒   ▄▄▄█████▓ ██░ ██ ▓█████                                                   /\\\r\n" + //
        "\\/▒██▒  ██▒▓██   ▒    ▓  ██▒ ▓▒▓██░ ██▒▓█   ▀                                                   \\/\r\n" + //
        "/\\▒██░  ██▒▒████ ░    ▒ ▓██░ ▒░▒██▀▀██░▒███                                                     /\\\r\n" + //
        "\\/▒██   ██░░▓█▒  ░    ░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄                                                   \\/\r\n" + //
        "/\\░ ████▓▒░░▒█░         ▒██▒ ░ ░▓█▒░██▓░▒████▒                                                  /\\\r\n" + //
        "\\/░ ▒░▒░▒░  ▒ ░         ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░                                                  \\/\r\n" + //
        "/\\  ░ ▒ ▒░  ░             ░     ▒ ░▒░ ░ ░ ░  ░                                                  /\\\r\n" + //
        "\\/░ ░ ░ ▒   ░ ░         ░       ░  ░░ ░   ░                                                     \\/\r\n" + //
        "/\\    ░ ░                       ░  ░  ░   ░  ░                                                  /\\\r\n" + //
        "\\/                                                                                              \\/\r\n" + //
        "/\\ ▄▄▄      ▓█████▄  ██▒   █▓▓█████  ███▄    █ ▄▄▄█████▓ █    ██  ██▀███  ▓█████  ██▀███   ▐██▌ /\\\r\n" + //
        "\\/▒████▄    ▒██▀ ██▌▓██░   █▒▓█   ▀  ██ ▀█   █ ▓  ██▒ ▓▒ ██  ▓██▒▓██ ▒ ██▒▓█   ▀ ▓██ ▒ ██▒ ▐██▌ \\/\r\n" + //
        "/\\▒██  ▀█▄  ░██   █▌ ▓██  █▒░▒███   ▓██  ▀█ ██▒▒ ▓██░ ▒░▓██  ▒██░▓██ ░▄█ ▒▒███   ▓██ ░▄█ ▒ ▐██▌ /\\\r\n" + //
        "\\/░██▄▄▄▄██ ░▓█▄   ▌  ▒██ █░░▒▓█  ▄ ▓██▒  ▐▌██▒░ ▓██▓ ░ ▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄ ▒██▀▀█▄   ▓██▒ \\/\r\n" + //
        "/\\ ▓█   ▓██▒░▒████▓    ▒▀█░  ░▒████▒▒██░   ▓██░  ▒██▒ ░ ▒▒█████▓ ░██▓ ▒██▒░▒████▒░██▓ ▒██▒ ▒▄▄  /\\\r\n" + //
        "\\/ ▒▒   ▓▒█░ ▒▒▓  ▒    ░ ▐░  ░░ ▒░ ░░ ▒░   ▒ ▒   ▒ ░░   ░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░░ ▒▓ ░▒▓░ ░▀▀▒ \\/\r\n" + //
        "/\\  ▒   ▒▒ ░ ░ ▒  ▒    ░ ░░   ░ ░  ░░ ░░   ░ ▒░    ░    ░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░  ░▒ ░ ▒░ ░  ░ /\\\r\n" + //
        "\\/  ░   ▒    ░ ░  ░      ░░     ░      ░   ░ ░   ░       ░░░ ░ ░   ░░   ░    ░     ░░   ░     ░ \\/\r\n" + //
        "/\\      ░  ░   ░          ░     ░  ░         ░             ░        ░        ░  ░   ░      ░    /\\\r\n" + //
        "\\/           ░           ░                                                                      \\/\r\n" + //
        "/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\r\n" + //
        "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");


        System.out.println("In a land where myths and legends come alive, your adventure begins. ");
        System.out.println("You are about to embark on a journey through two vastly different realms:");

        System.out.println(" The Radiant Side: A paradise of lush forests, serene lakes, and majestic views.");
        System.out.println("   Here, beauty meets danger as hostile creatures and enigmatic aliens challenge your courage.");
        System.out.println(" The Dire Side: A desolate wasteland of dark forests, barren ruins, and hidden perils.");

        System.out.println("  Only the bravest can withstand the onslaught of creeps and fierce aliens that lurk in the shadows.");
        System.out.println("Your quest? To uncover the legendary treasure hidden within these lands.");
        System.out.println("Prepare to face thrilling quests, battle formidable enemies, and overcome insurmountable odds.");

        System.out.println("Will you be the hero who brings light to the darkness, or will the shadows claim your soul?");
        System.out.println("The fate of this world lies in your hands.");
        System.out.println("Are you ready to write your own legend? Register or login to begin your epic journey!");

        System.out.println("══════════════════════════════════════════════════════════════════");
        System.out.println("REGISTER THYSELF ON THIS PLATFORM IN ORDER TO PLAY GAME!");



        // Registration
        Userregistration(sc);

        // Logging in
        Loggin(sc); 

        // Game begins - selecting character
        selectCharacter(sc);

        // call the help option method to give user an option to view intructions // 
        HelpOption (sc);

        // Map Selection
        chooseMap(sc);



    }

    // Method for registration // 
    static void Userregistration(Scanner scanner) {

        System.out.println("Enter your username:");

        String username = scanner.nextLine();


        // code is used to ensure that username isnt empty // 
        // For empty command code reference is taken from ( https://medium.com/@AlexanderObregon/java-string-isempty-method-explained-a731faf082aa#:~:text=isEmpty()%20returns%20false%20.&text=Here%2C%20the%20program%20checks%20if,validation%20and%20user%20input%20checks.)
        //// this basically will give error results if user didnt input any command in registration process /////
     
        while (username.isEmpty()) {

            System.out.println("Username cannot be empty. Enter your username:");

            username = scanner.nextLine();
        }

        System.out.println("Enter your password:");

        String password = scanner.nextLine();


        // ensure password isnt empty // 
        while (password.isEmpty()) {

            System.out.println("Password cannot be empty. Enter your password:");

            password = scanner.nextLine();
        }

        // collect user age and gender information // 

        System.out.println("Enter your age:");

        int age = scanner.nextInt();

        scanner.nextLine(); // Consume newline // 

        System.out.println("Enter your gender:");

        String gender = scanner.nextLine();

        while (gender.isEmpty()) {

            System.out.println("Gender cannot be empty. Enter your gender:");

            gender = scanner.nextLine();
        }

        // to check if username already exist or not // 

        if (users.containsKey(username)) {

            System.out.println("User already exists.");

        } else {

            users.put(username, password);

            System.out.println("Registration successful");
        }
    }

    // Method for user login // //

    static void Loggin(Scanner scanner) {

        System.out.println("Logging into your account");

        System.out.println("Enter your Username");

        String username = scanner.nextLine();


    // to ensure that username is not empty // 

        while (username.isEmpty()) {  

            System.out.println("Username cannot be empty. Enter your username:");

            username = scanner.nextLine();
        }

        System.out.println("Enter your password:");

        String password = scanner.nextLine();

        while (password.isEmpty()) {

            System.out.println("Password cannot be empty. Enter your password:");

            password = scanner.nextLine();
        }

        //this code is written to validate user credentials // 

        if (!users.containsKey(username) || !users.get(username).equals(password)) {

            System.out.println("Invalid username or password.");

            System.exit(0);  // Exit if login fails // 

        } else {

            System.out.println("Login successful.");
            
        }
    }

    // Method for character selection://

    // first is Dazmon // 


    static void selectCharacter(Scanner scanner) {

        System.out.println("Select your character:");
        System.out.println("1. Dazmon (Male):");
        System.out.println("   Fighting/Combat Skills: 3/5");
        System.out.println("   Health: 10/10");
        System.out.println("   Energy: 5/10");


         //dazmon aski art // 
       try
       {
           File f2=new File("Dazmon.txt");

           Scanner sc=new Scanner(f2);

           while (sc.hasNextLine()) 
           {
               String data=sc.nextLine();

               System.out.println(data);
           }
       }catch(FileNotFoundException e)
       {
           System.out.println("An error has occured");

           e.printStackTrace();
       }
////////////////////////////////////////////////////////////////////////

        // Second is Alto // 

        System.out.println("2. Alto (Male):");
        System.out.println("   Fighting/Combat Skills: 5/5");
        System.out.println("   Health: 5/10");
        System.out.println("   Energy: 10/10");

        // altos aski art //
        
       try
       {
           File f2=new File("Alto.txt");

           Scanner sc=new Scanner(f2);

           while (sc.hasNextLine()) 
           {
               String data=sc.nextLine();
               
               System.out.println(data);
           }

       }catch(FileNotFoundException e)
       {
           System.out.println("An error has occured");

           e.printStackTrace();
       }


///////////////////////////////////////////////////////////////////////////////

        // Third is Sofia // 



        System.out.println("3. Sofia (Female):");
        System.out.println("   Fighting/Combat Skills: 4/5");
        System.out.println("   Health: 10/10");
        System.out.println("   Energy: 8/10");


        /// sofia aski art ///

        try
        {
            File f2=new File("Sofia.txt");

            Scanner sc=new Scanner(f2);

            while (sc.hasNextLine()) 
            {
                String data=sc.nextLine();
                
                System.out.println(data);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("An error has occured");

            e.printStackTrace();
        }

///////////////////////////////////////////////////////////////////////////////////

int characterChoice = 0;


        while (characterChoice < 1 || characterChoice > 3) {

            System.out.print("Enter the number of your chosen character: ");

            characterChoice = scanner.nextInt();

            scanner.nextLine(); 

            switch (characterChoice) {

                case 1:

                    System.out.println("You have selected Dazmon.");
                    break;

                case 2:

                    System.out.println("You have selected Alto.");
                    break;

                case 3:
                    System.out.println("You have selected Sofia.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid character number.");
            }
        }

        System.out.println("Character selection complete. Get ready to start your adventure!");
    }



   // Method for displaying help information // 

    static void HelpOption(Scanner scanner) {

    System.out.println("Would you like to view the help instructions? (yes/no)");

    String helpChoice = scanner.nextLine(); // user wull now input their choice // 
    
    // check if the user entered "yes" (case  insensitive) // 

    if (helpChoice.equalsIgnoreCase("yes")) {

        // create a new help object with detailed instructions for the user!! // 

        Help help = new Help("After selecting your character, you will be given the option to choose a map.",

                             "Press 'n' to proceed to the Radiant Side (North Side), which is filled with lush forests and serene lakes.",

                             "Press 's' to proceed to the Dire Side (South Side), which is a desolate wasteland with dark forests and hidden perils.",

                             "Be prepared for encounters and challenges on both sides. Make your choice wisely!");

        help.displayInstructions();

    }
}

//inner class to encapsulate help related information and behavior // 

static class Help {

    // variable to store different instruction strings // 

    String instruction1;

    String instruction2;

    String instruction3;

    String instruction4;

    // constructors for the help class, initializing the instruction variables // 


    public Help(String instr1, String instr2, String instr3, String instr4) {

        this.instruction1 = instr1;

        this.instruction2 = instr2;

        this.instruction3 = instr3;

        this.instruction4 = instr4;

    }

    // method to display the help instructions // 

    public void displayInstructions() {

        System.out.println("HELP INSTRUCTIONS:");

        // this print each instruction //

        System.out.println(this.instruction1);

        System.out.println(this.instruction2);

        System.out.println(this.instruction3);

        System.out.println(this.instruction4);
    }
}


   

  // Method for map selection //

  static void chooseMap(Scanner scanner) {

    System.out.println("You have chosen the character. Now proceed towards the map.");

    System.out.println("Press 'n' to proceed towards the RADIANT SIDE (NORTH SIDE) or press 's' to proceed towards the DIRE SIDE (SOUTH SIDE)");

    char mapChoice = scanner.nextLine().charAt(0);

    if (mapChoice == 'n') {

        radiantSide(scanner);
        
    } else if (mapChoice == 's') {

        direSide(scanner);

    } else {

        System.out.println("Invalid choice. Choose again.");

        chooseMap(scanner);  // Recursive call to choose map again
    }
}

// Radiant Side

static void radiantSide(Scanner sc) {

    System.out.println("You have entered the north (Radiant) side of the Map.");
    System.out.println("Here you are welcomed by the flora and fauna of the radiant with serene lakes.");

    System.out.println("Majestic views stretch as far as the eye can see, and a pathway leads towards a grand castle and a mysterious cave.");
    System.out.println("But beware, beauty here is intertwined with danger, as hostile creatures and enigmatic aliens may challenge your courage.");

    System.out.println("Press 'm' to move.");

    while (true) {

        char choice = sc.next().charAt(0);

        if (choice == 'm') {

            System.out.println("The character is moving...");

            handleRadiantEncounter(sc);
            break;  // Break after handling the first move to prevent infinite loop

        } else {

            System.out.println("Invalid input. Press 'm' to move.");
        }
    }
}

// Handle encounters on the Radiant side

static void handleRadiantEncounter(Scanner sc) {

    Random rd = new Random();

    int encounter = rd.nextInt(100);  // Random number between 0 and 99

    if (encounter < 100) {  // Always encounter a creep on Radiant side

        System.out.println("You have encountered a creep!");

        combatWithCreeps(sc);
    }
}

// Methods to counter creeps

static void combatWithCreeps(Scanner sc) {

    int creepHealth = 2;  // Creeps require two hits to kill


    while (creepHealth > 0) {

        System.out.println("Press 'a' to attack the creep.");

        char action = sc.next().charAt(0);

        if (action == 'a') {

            creepHealth--;

            System.out.println("You hit the creep. Remaining health: " + creepHealth);

            if (creepHealth == 0) {

                System.out.println("You have killed the creep!");
            }
        } else {

            System.out.println("Invalid input. Press 'a' to attack.");
        }
    }

    System.out.println("Now you may proceed towards your journey...");

    handleNextStep(sc);
}

// After countering the creep and finishing them off, the next process // 

static void handleNextStep(Scanner sc) {

    System.out.println("You see a dagger in front of you. Press 'p' to pick it up or 'm' to move on.");

    while (true) {
        char choice = sc.next().charAt(0);

        if (choice == 'p') {

            System.out.println("You have picked up the dagger.");

            break;
        } else if (choice == 'm') {

            System.out.println("You chose not to pick up the dagger and moved on.");

            break;

        } else {

            System.out.println("Invalid input. Press 'p' to pick up the dagger or 'm' to move on.");
        }
    }

    System.out.println("As you move further, you see a grand castle in front of you.");

    System.out.println("Press 'm' to move towards the castle.");

    while (true) {

        char choice = sc.next().charAt(0);

        if (choice == 'm') {

            System.out.println("The character is moving...");

            handleCaveEncounter(sc);

            break;

        } else {

            System.out.println("Invalid input. Press 'm' to move.");

        }
    }
}





/// ******* CODE FOR TEXUAL BASED COLOUR **** //// 

    //REF ERENCE FOUND ON  (https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/) //// **** yaaaaay, i found it :') **** /////


    
    public static final String ANSI_RESET = "\u001B[0m"; 
  
    // Declaring the color //

    // Custom declaration //

    public static final String ANSI_RED = "\u001B[31m"; 

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    /////


    // Handle the encounter in the cave with the dragon //// 

static void handleCaveEncounter(Scanner sc) {

    System.out.println("You have entered the cave. It's very dark and you feel the presence of someone or something right in front of you....");

    System.out.println("Inside the cave, you encounter a dragon!!! guarding a treasure!");

    System.out.println("           __                  __\r\n" + //
                "            ( _)                ( _)\r\n" + //
                "           / / \\\\              / /\\_\\_\r\n" + //
                "          / /   \\\\            / / | \\ \\\r\n" + //
                "         / /     \\\\          / /  |\\ \\ \\\r\n" + //
                "        /  /   ,  \\ ,       / /   /|  \\ \\\r\n" + //
                "       /  /    |\\_ /|      / /   / \\   \\_\\\r\n" + //
                "      /  /  |\\/ _ '_| \\   / /   /   \\    \\\\\r\n" + //
                "     |  /   |/  0 \\0\\    / |    |    \\    \\\\\r\n" + //
                "     |    |\\|      \\_\\_ /  /    |     \\    \\\\\r\n" + //
                "     |  | |/    \\.\\ o\\o)  /      \\     |    \\\\\r\n" + //
                "     \\    |     /\\\\`v-v  /        |    |     \\\\\r\n" + //
                "      | \\/    /_| \\\\_|  /         |    | \\    \\\\\r\n" + //
                "      | |    /__/_ `-` /   _____  |    |  \\    \\\\\r\n" + //
                "      \\|    [__]  \\_/  |_________  \\   |   \\    ()\r\n" + //
                "       /    [___] (    \\         \\  |\\ |   |   //\r\n" + //
                "      |    [___]                  |\\| \\|   /  |/\r\n" + //
                "     /|    [____]                  \\  |/\\ / / ||\r\n" + //
                "snd (  \\   [____ /     ) _\\      \\  \\    \\| | ||\r\n" + //
                "     \\  \\  [_____|    / /     __/    \\   / / //\r\n" + //
                "     |   \\ [_____/   / /        \\    |   \\/ //\r\n" + //
                "     |   /  '----|   /=\\____   _/    |   / //\r\n" + //
                "  __ /  /        |  /   ___/  _/\\    \\  | ||\r\n" + //
                " (/-(/-\\)       /   \\  (/\\/\\)/  |    /  | /\r\n" + //
                "               (/\\/\\)           /   /   //\r\n" + //
                "                      _________/   /    /\r\n" + //
                "                     \\____________/    (\n" );


    int dragonHealth = 3;  // Dragons require three hits to kill //


    while (dragonHealth > 0) {

        System.out.println("Press 'a' to attack the dragon.");

        char action = sc.next().charAt(0);


        if (action == 'a') {

            dragonHealth--;

            System.out.println("You hit the dragon. Remaining health: " + dragonHealth);

            if (dragonHealth == 0) {

                // this command / code will show text in red colour // 

                System.out.println(ANSI_RED + "You have killed the dragon!" + ANSI_RESET);
            }
        } else {
            System.out.println("Invalid input. Press 'a' to attack.");
        }
    }

    System.out.println("You see the treasure. Press 'p' to pick it up.");

    while (true) {
        char choice = sc.next().charAt(0);

        if (choice == 'p') {
            System.out.println("You have picked up the treasure.");

            System.out.println();

            // this command will declare the text back ground in green colour /// 

            System.out.println(ANSI_GREEN_BACKGROUND +"Congratulations! You have completed the adventure on the radiant side with a VICTORY!" + ANSI_RESET);

            break;

        } else {

            System.out.println("Invalid input. Press 'p' to pick up the treasure.");
        }
    }
}



//  Dire Side // 


static void direSide(Scanner sc) {

    System.out.println("You have entered the south (Dire) side of the map.");

    System.out.println("The environment is stark and desolate, with dark forests and barren ruins.");

    System.out.println("The air is thick with the sense of lurking danger, and only the bravest can withstand the creeps and fierce aliens that prowl in the shadows.");

    System.out.println("Perils are hidden behind every corner, but great rewards await those who dare to venture into the depths of this treacherous land.");

    System.out.println("Press 'm' to move.");

    while (true) {

        char choice = sc.next().charAt(0);

        if (choice == 'm') {

            System.out.println("The character is moving...");

            handleDireEncounter(sc);

            break;  // Break after handling the first move to prevent infinite loop //

        } else {

            System.out.println("Invalid input. Press 'm' to move.");
        }
    }
}



// Handle encounters on the Dire side // 

static void handleDireEncounter(Scanner sc) {

    Random rd = new Random();

    int encounter = rd.nextInt(100);  // Random number between 0 and 99

    if (encounter < 100) {  // will Always encounter an alien on Dire side NOT CREEPS // 

        System.out.println("You have encountered an alien!");

        combatWithAlien(sc);
    }
}

// Combat with Alien

static void combatWithAlien(Scanner sc) {

    int alienHealth = 2;  // Aliens require two hits to kill

    while (alienHealth > 0) {

        System.out.println("Press 'a' to attack the alien.");

        char action = sc.next().charAt(0);

        if (action == 'a') {

            alienHealth--;

            System.out.println("You hit the alien. Remaining health: " + alienHealth);

            if (alienHealth == 0) {

                System.out.println("You have killed the alien!");
            }
        } else {

            System.out.println("Invalid input. Press 'a' to attack.");
        }
    }

    System.out.println("Now you may proceed towards your journey...");

    handleVolcanoEncounter(sc);
}

// Handle the encounter in the volcano mountain with the giant anaconda snake

static void handleVolcanoEncounter(Scanner sc) {

    System.out.println("You have entered the volcano mountain.");

    System.out.println("Inside the volcano mountain, you encounter a giant anaconda snake who has captured a princess!");

    System.out.println("            __..._              \r\n" + //
                "                        ..-'      o.            \r\n" + //
                "                     .-'            :           \r\n" + //
                "                 _..'             .'__..--<     \r\n" + //
                "          ...--\"\"                 '-.           \r\n" + //
                "      ..-\"                       __.'           \r\n" + //
                "    .'                  ___...--'               \r\n" + //
                "   :        ____....---'                        \r\n" + //
                "  :       .'                                    \r\n" + //
                " :       :           _____                      \r\n" + //
                " :      :    _..--\"\"\"     \"\"\"--..__             \r\n" + //
                ":       :  .\"                      \"\"i--.       \r\n" + //
                ":       '.:                         :    '.     \r\n" + //
                ":         '--...___i---\"\"\"\"--..___.'      :     \r\n" + //
                " :                 \"\"---...---\"\"          :     \r\n" + //
                "  '.                                     :      \r\n" + //
                "    '-.                                 :       \r\n" + //
                "       '--...                         .'        \r\n" + //
                "         :   \"\"---....._____.....---\"\"          \r\n" + //
                "         '.    '.                               \r\n" + //
                "           '-..  '.                             \r\n" + //
                "               '.  :                            \r\n" + //
                "          fsc   : .'                            \r\n" + //
                "               /  :                             \r\n" + //
                "             .'   :                             \r\n" + //
                "           .' .--'                              \r\n" + //
                "          '--' \n");

    int snakeHealth = 3;  // The giant anaconda snake requires three hits to kill

    while (snakeHealth > 0) {

        System.out.println("Press 'a' to attack the giant anaconda snake.");

        char action = sc.next().charAt(0);

        if (action == 'a') {

            snakeHealth--;

            System.out.println("You hit the giant anaconda snake. Remaining health: " + snakeHealth);

            if (snakeHealth == 0) {

                // command will show the given text in red text colour // 

                
                System.out.println(ANSI_RED + "You have killed the giant anaconda snake!" + ANSI_RESET);

            }

        } else {

            System.out.println("Invalid input. Press 'a' to attack.");
        }
    }

    System.out.println("You see the princess. Press 'p' to rescue/Protect her.");

    while (true) {

        char choice = sc.next().charAt(0);

        if (choice == 'p') {

            System.out.println("You have rescued the princess.");

            // command will print the text with green background colour // 

            System.out.println(ANSI_GREEN_BACKGROUND + "Congratulations! You have completed the adventure on the dire side with a VICTORY!"+ ANSI_RESET);

            

            break;

        } else {
            System.out.println("Invalid input. Press 'p' to rescue the princess.");
        }
    }
}
}