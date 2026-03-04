import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class MyProgram
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Create account or log in: ");
        String userChoice = input.nextLine();
        
        BufferedWriter accountFile;
        String playerUsername = "";
        String playerPassword = "";
        
        boolean inWorldOne = true;
        boolean inWorldTwo = false;
        boolean discoveredLegendary = false;
        boolean discoveredGodly = false;
        boolean discoveredMythic = false;
        boolean onlyRollQuestionMark = false;
        boolean onlyRollMythic = false;
        boolean onlyRollGodly = false;
        boolean onlyRollLegendary = false;
        ArrayList<String> tempInventory = new ArrayList<String>();
        ArrayList<String> displayInventory = new ArrayList<String>();
        int numCommonsFound = 0;
        int numUncommonsFound = 0;
        int numRaresFound = 0;
        int numEpicsFound = 0;
        int numLegendariesFound = 0;
        int numGodliesFound = 0;
        int numMythicsFound = 0;
        int numQuestionMarksFound = 0;
        int inventorySize = 0;
        long maxInventorySize = 50;
        int luckLevel = 1;
        int moneyMultiplierLevel = 1;
        int autoRollLevel = 0;
        int inventoryLevel = 1;
        long tempMoney = 0;
        long displayMoney = 0;
        
        boolean proceed = false;
        

        while (proceed == false){
            if (userChoice.equalsIgnoreCase("Create Account") || userChoice.equalsIgnoreCase("Create")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.print("Create account name: ");
                String newUsername = input.nextLine();
                File check = new File(newUsername + ".txt");
                
                if (check.exists()){
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\033[38;5;196m" + "Account already exists" + "\u001b[0m\n");
                    System.out.print("Create account or log in: ");
                    userChoice = input.nextLine();
                }
                
                else{
                    System.out.print("Create account password: ");
                    String newPassword = input.nextLine();
                    System.out.print("Retype password to confirm: ");
                    String confirmation = input.nextLine();
                    
                    if (newPassword.equals(confirmation)){
                        try{
                            playerUsername = newUsername;
                            playerPassword = newPassword;
                            
                            accountFile = new BufferedWriter(new FileWriter(newUsername + ".txt"));
                            accountFile.write("PW:" + newPassword + "\n");
                            accountFile.write("IW1:t\n");
                            accountFile.write("IW2:f\n");
                            accountFile.write("DL:f\n");
                            accountFile.write("DG:f\n");
                            accountFile.write("DM:f\n");
                            accountFile.write("CF:0\n");
                            accountFile.write("UF:0\n");
                            accountFile.write("RF:0\n");
                            accountFile.write("EF:0\n");
                            accountFile.write("LF:0\n");
                            accountFile.write("GF:0\n");
                            accountFile.write("MF:0\n");
                            accountFile.write("QF:0\n");
                            accountFile.write("OR?:f\n");
                            accountFile.write("ORM:f\n");
                            accountFile.write("ORG:f\n");
                            accountFile.write("ORL:f\n");
                            accountFile.write("IS:0\n");
                            accountFile.write("MIS:50\n");
                            accountFile.write("L:1\n");
                            accountFile.write("MM:1\n");
                            accountFile.write("AR:0\n");
                            accountFile.write("IL:1\n");
                            accountFile.write("TM:0\n");
                            accountFile.write("DM:0\n");
                            accountFile.write("TI:\n");
                            accountFile.write("\nDI:\n");
                            accountFile.write("\n");
                            accountFile.close();
                            
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("Welcome " + newUsername + "!\n");
                            proceed = true;
                            break;
                        }
                        catch (Exception e){
                        }
                    }
                    
                    else{
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.println("\033[38;5;196m" + "Passwords do not match" + "\u001b[0m\n");
                        System.out.print("Create account or log in: ");
                        userChoice = input.nextLine();
                    }
                }
            }
            
            else if (userChoice.equalsIgnoreCase("Log In") || userChoice.equalsIgnoreCase("Login") || userChoice.equalsIgnoreCase("Log")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.print("Enter username: ");
                String username = input.nextLine();
                
                File file = new File(username + ".txt");
                
                if (file.exists()){
                    System.out.print("Enter account password: ");
                    String password = input.nextLine();
                    
                    try{
                        Scanner sc = new Scanner(file);
                        String correctPassword = sc.nextLine();
                        correctPassword = correctPassword.substring(3);
                        
                        if (password.equals(correctPassword)){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("Hello " + username + "!\n");
                            playerUsername = username;
                            playerPassword = password;
                            
                            if (sc.nextLine().substring(4).equals("t")){
                                inWorldOne = true;
                            }
                            
                            else{
                                inWorldOne = false;
                            }
                            
                            if (sc.nextLine().substring(4).equals("t")){
                                inWorldTwo = true;
                            }
                            
                            else{
                                inWorldTwo = false;
                            }
                            
                            if (sc.nextLine().substring(3).equals("t")){
                                discoveredLegendary = true;
                            }
                            
                            if (sc.nextLine().substring(3).equals("t")){
                                discoveredGodly = true;
                            }
                            
                            if (sc.nextLine().substring(3).equals("t")){
                                discoveredMythic = true;
                            }
                            
                            numCommonsFound = Integer.valueOf(sc.nextLine().substring(3));
                            numUncommonsFound = Integer.valueOf(sc.nextLine().substring(3));
                            numRaresFound = Integer.valueOf(sc.nextLine().substring(3));
                            numEpicsFound = Integer.valueOf(sc.nextLine().substring(3));
                            numLegendariesFound = Integer.valueOf(sc.nextLine().substring(3));
                            numGodliesFound = Integer.valueOf(sc.nextLine().substring(3));
                            numMythicsFound = Integer.valueOf(sc.nextLine().substring(3));
                            numQuestionMarksFound = Integer.valueOf(sc.nextLine().substring(3));

                            if (sc.nextLine().substring(4).equals("t")){
                                onlyRollQuestionMark = true;
                            }
                            
                            if (sc.nextLine().substring(4).equals("t")){
                                onlyRollMythic = true;
                            }

                            if (sc.nextLine().substring(4).equals("t")){
                                onlyRollGodly = true;
                            }
                            
                            if (sc.nextLine().substring(4).equals("t")){
                                onlyRollLegendary = true;
                            }
                            
                            inventorySize = Integer.valueOf(sc.nextLine().substring(3));
                            maxInventorySize = Integer.valueOf(sc.nextLine().substring(4));
                            luckLevel = Integer.valueOf(sc.nextLine().substring(2));
                            moneyMultiplierLevel = Integer.valueOf(sc.nextLine().substring(3));
                            autoRollLevel = Integer.valueOf(sc.nextLine().substring(3));
                            inventoryLevel = Integer.valueOf(sc.nextLine().substring(3));
                            tempMoney = Long.valueOf(sc.nextLine().substring(3));
                            displayMoney = Long.valueOf(sc.nextLine().substring(3));
                            
                            sc.nextLine();
                            String line = sc.nextLine();
                            while (line.length() != 0){
                                tempInventory.add(line);
                                line = sc.nextLine();
                            }
                            
                            sc.nextLine();
                            line = sc.nextLine();
                            while (line.length() != 0){
                                displayInventory.add(line);
                                line = sc.nextLine();
                            }
                            
                            proceed = true;
                        }
                        
                        else{
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Password is incorrect\n" + "\u001b[0m");
                            System.out.print("Create account or log in: ");
                            userChoice = input.nextLine();
                        }
                    }
                    catch (Exception e){
                    }
                }
                
                else{
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\033[38;5;196m" + "Account does not exist" + "\u001b[0m\n");
                    System.out.print("Create account or log in: ");
                    userChoice = input.nextLine();
                }
            }
            
            else{
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.println("\033[38;5;196m" + "Invalid input" + "\u001b[0m\n");
                System.out.print("Create account or log in: ");
                userChoice = input.nextLine();
            }
        }
        
        Ore newOre = new Ore(luckLevel, moneyMultiplierLevel, autoRollLevel, inventoryLevel, onlyRollQuestionMark, onlyRollMythic, onlyRollGodly, onlyRollLegendary, inWorldOne, inWorldTwo, inventorySize, maxInventorySize, discoveredLegendary, discoveredGodly, discoveredMythic, numCommonsFound, numUncommonsFound, numRaresFound, numEpicsFound, numLegendariesFound, numGodliesFound, numMythicsFound, numQuestionMarksFound, tempMoney, displayMoney, tempInventory, displayInventory);
        
        System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
        userChoice = input.nextLine();
        
        while (userChoice.equalsIgnoreCase("STOP") == false){
            if (userChoice.equalsIgnoreCase("Roll Ore") || userChoice.equalsIgnoreCase("Roll")){
                if (newOre.inventorySize() < newOre.maxInventorySize()){
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.print("Press Enter to roll or type \"r\" to return: ");
                    userChoice = input.nextLine();
                    while (userChoice.equalsIgnoreCase("r") == false){
                        if (newOre.inventorySize() >= newOre.maxInventorySize()){
                            System.out.println("\u001b[1m\033[38;5;196m⚠︎  Inventory full\u001b[0m\n");
                            System.out.print("\nPress Enter to roll or type \"r\" to return: ");
                            userChoice = input.nextLine();
                        }
                        
                        else{
                            newOre.roll();
                            System.out.println(newOre.getName());
                            System.out.println();
                            System.out.print("\nPress Enter to roll or type \"r\" to return: ");
                            userChoice = input.nextLine();
                        }
                    }
                    if (userChoice.equalsIgnoreCase("r")){
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                        userChoice = input.nextLine();
                    }
                }
                
                else{
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\u001b[1m\033[38;5;196m⚠︎  Inventory full\u001b[0m\n");
                    System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                    userChoice = input.nextLine();
                }
            }
        
            else if (userChoice.equalsIgnoreCase("Check Inventory") || userChoice.equalsIgnoreCase("Inventory")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.println(newOre.checkInventory());
                System.out.print("\nWhat do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                userChoice = input.nextLine();
            }
            
            else if (userChoice.equalsIgnoreCase("Upgrades") || userChoice.equalsIgnoreCase("Upgrade")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.print("Select an upgrade (\"r\" to return):\n- Boost Luck\n- Coin Multiplier\n- Autoroll Speed\n- Inventory Size\n- Next World\n --> ");
                userChoice = input.nextLine();
                
                while (userChoice.equalsIgnoreCase("r") == false){
                    if (userChoice.equalsIgnoreCase("Boost Luck") || userChoice.equalsIgnoreCase("Luck")){
                        // Checks if the luck upgrade is already maxed
                        if (newOre.luckLevel() == 4){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Luck is already fully upgraded\n" + "\u001b[0m");
                        }
                        
                        else{
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            if (newOre.firstUpgradeRequirement() == true){
                                System.out.println("\033[38;5;46m" + "Upgraded luck to level 1! (1/3)\n" + "\u001b[0m");
                                newOre.setLuck(2);
                            }
                            
                            else if (newOre.luckLevel() == 1){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: Legendary tier not discovered\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.secondUpgradeRequirement() == true){
                                System.out.println("\033[38;5;46m" + "Upgraded luck to level 2! (2/3)\n" + "\u001b[0m");
                                newOre.setLuck(3);
                            }
                            
                            else if (newOre.luckLevel() == 2){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: Godly tier not discovered\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.thirdUpgradeRequirement() == true){
                                System.out.println("\033[38;5;46m" + "Upgraded luck to level 3! (3/3)\n" + "\u001b[0m");
                                newOre.setLuck(4);
                            }
                            
                            else if (newOre.luckLevel() == 3){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: Mythic tier not discovered\n" + "\u001b[0m");
                            }
                        }
                    }
                    
                    else if (userChoice.equalsIgnoreCase("Coin Multiplier") || userChoice.equalsIgnoreCase("Coin")){
                        if (newOre.getMoneyMultiplier() == 5){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Coin multiplier is already fully upgraded\n" + "\u001b[0m");
                        }
                        
                        else{
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            if (newOre.getMoney() >= 1000 && newOre.getMoneyMultiplier() < 2){
                                System.out.println("\033[38;5;46m" + "Upgraded coin multiplier! (1/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 1000);
                                newOre.setMoneyMultiplier(2);
                            }
                            
                            else if (newOre.getMoneyMultiplier() == 1){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (1000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 2500 && newOre.getMoneyMultiplier() < 3){
                                System.out.println("\033[38;5;46m" + "Upgraded coin multiplier! (2/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 2500);
                                newOre.setMoneyMultiplier(3);
                            }
                            
                            else if (newOre.getMoneyMultiplier() == 2){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (2500 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 7500 && newOre.getMoneyMultiplier() < 4){
                                System.out.println("\033[38;5;46m" + "Upgraded coin multiplier! (3/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 7500);
                                newOre.setMoneyMultiplier(4);
                            }
                            
                            else if (newOre.getMoneyMultiplier() == 3){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (7500 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 25000 && newOre.getMoneyMultiplier() < 5){
                                System.out.println("\033[38;5;46m" + "Upgraded coin multiplier! (4/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 25000);
                                newOre.setMoneyMultiplier(5);
                            }
                            
                            else if (newOre.getMoneyMultiplier() == 4){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (25000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                        }
                    }
                    
                    else if (userChoice.equalsIgnoreCase("Autoroll Speed") || userChoice.equalsIgnoreCase("Autoroll") || userChoice.equalsIgnoreCase("Auto") || userChoice.equalsIgnoreCase("Speed")){
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        if (newOre.getAutoRollLevel() == 4){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Autoroll speed is already fully upgraded\n" + "\u001b[0m");
                        }
                        
                        else{
                            if (newOre.getMoney() >= 2500 && newOre.getAutoRollLevel() < 1){
                                System.out.println("\033[38;5;46m" + "Upgraded autoroll speed! (1/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 2500);
                                newOre.setAutoRollLevel(1);
                            }
                            
                            else if (newOre.getAutoRollLevel() == 0){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (2500 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 5000 && newOre.getAutoRollLevel() < 2){
                                System.out.println("\033[38;5;46m" + "Upgraded autoroll speed! (2/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 5000);
                                newOre.setAutoRollLevel(2);
                            }
                            
                            else if (newOre.getAutoRollLevel() == 1){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (5000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 10000 && newOre.getAutoRollLevel() < 3){
                                System.out.println("\033[38;5;46m" + "Upgraded autoroll speed! (3/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 10000);
                                newOre.setAutoRollLevel(3);
                            }
                            
                            else if (newOre.getAutoRollLevel() == 2){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (10000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 25000 && newOre.getAutoRollLevel() < 4){
                                System.out.println("\033[38;5;46m" + "Upgraded autoroll speed! (4/4)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 25000);
                                newOre.setAutoRollLevel(4);
                            }
                            
                            else if (newOre.getAutoRollLevel() == 3){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (25000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                        }
                    }
                    
                    else if (userChoice.equalsIgnoreCase("Inventory Size") || userChoice.equalsIgnoreCase("Inventory") || userChoice.equalsIgnoreCase("Size")){
                        if (newOre.inventoryLevel() == 6){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Inventory size is already fully upgraded\n" + "\u001b[0m");
                        }
                        
                        else{
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            if (newOre.getMoney() >= 500 && newOre.inventoryLevel() < 2){
                                System.out.println("\033[38;5;46m" + "Upgraded inventory size! (1/6)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 500);
                                newOre.setInventoryLevel(2);
                                newOre.setMaxInventorySize(75);
                            }
                            
                            else if (newOre.inventoryLevel() == 1){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (500 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 2500 && newOre.inventoryLevel() < 3){
                                System.out.println("\033[38;5;46m" + "Upgraded inventory size! (2/6)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 2500);
                                newOre.setInventoryLevel(3);
                                newOre.setMaxInventorySize(125);
                            }
                            
                            else if (newOre.inventoryLevel() == 2){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (2500 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 5000 && newOre.inventoryLevel() < 4){
                                System.out.println("\033[38;5;46m" + "Upgraded inventory size! (3/6)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 5000);
                                newOre.setInventoryLevel(4);
                                newOre.setMaxInventorySize(175);
                            }
                            
                            else if (newOre.inventoryLevel() == 3){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (5000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 15000 && newOre.inventoryLevel() < 5){
                                System.out.println("\033[38;5;46m" + "Upgraded inventory size! (5/6)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 15000);
                                newOre.setInventoryLevel(5);
                                newOre.setMaxInventorySize(225);
                            }
                            
                            else if (newOre.inventoryLevel() == 4){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (15000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else if (newOre.getMoney() >= 35000 && newOre.inventoryLevel() < 6){
                                System.out.println("\033[38;5;46m" + "Upgraded inventory size! (6/6)\n" + "\u001b[0m");
                                newOre.setMoney(newOre.getMoney() - 35000);
                                newOre.setInventoryLevel(6);
                                newOre.setMaxInventorySize(400);
                            }
                            
                            else if (newOre.inventoryLevel() == 5){
                                System.out.println("\033[38;5;196m" + "Cannot upgrade: $" + (35000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                        }
                    }
                    
                    else if (userChoice.equalsIgnoreCase("Next World") || userChoice.equalsIgnoreCase("Next") || userChoice.equalsIgnoreCase("World")){
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        
                        if (newOre.isInWorldOne()){
                            if (newOre.getMoney() < 100000){
                                System.out.println("\033[38;5;196m" + "Cannot purchase: $" + (100000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else{
                                System.out.println("Welcome to World 2!\n");
                                newOre.goToWorldTwo();
                                newOre.setMoney(0);
                                newOre.setAutoRollLevel(0);
                                newOre.setLuck(1);
                                newOre.setMoneyMultiplier(1);
                                newOre.clearInventory();
                                newOre.undiscoverAll();
                                newOre.setInventoryLevel(1);
                                newOre.setMaxInventorySize(50);
                                break;
                            }
                        }
                        
                        else if (newOre.isInWorldTwo()){
                            if (newOre.getMoney() < 500000){
                                System.out.println("\033[38;5;196m" + "Cannot purchase: $" + (100000000 - newOre.getMoney()) + " needed\n" + "\u001b[0m");
                            }
                            
                            else{
                                System.out.println("Coming Soon!\n");
                                break;
                            }
                        }
                    }
                    
                    else{
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.println("\033[38;5;196m" + "Invalid input.\n" + "\u001b[0m");
                    }
                    System.out.print("Select an upgrade (\"r\" to return):\n- Boost Luck\n- Coin Multiplier\n- Autoroll Speed\n- Inventory Size\n- Next World\n --> ");
                    userChoice = input.nextLine();
                    
                }
                
                if (userChoice.equalsIgnoreCase("r")){
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                }
                System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                userChoice = input.nextLine();
            }
            
            else if (userChoice.equalsIgnoreCase("Sell Ores") || userChoice.equalsIgnoreCase("Sell")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.print("Are you sure you want to sell " + "\u001b[3m" + "\u001b[4m" + "all" + "\u001b[0m" + " of your ores? This " + "\u001b[1m" + "\u001b[3m" + "\033[38;5;196m" + "cannot" + "\u001b[0m" + " be undone.\n --> ");
                userChoice = input.nextLine();
                
                if (userChoice.equalsIgnoreCase("Yes")){
                    String inv = newOre.checkInventory();
                    inv = inv.substring(inv.indexOf(")") + 4, inv.indexOf("]"));

                    if (inv.length() == 0){
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.println("\033[38;5;196m" + "You have no ores to sell\n" + "\u001b[0m");
                    }
                    
                    else{
                        newOre.sellAll();
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.println("\033[38;5;46m" + "Sold all ores!\n" + "\u001b[0m");
                    }
                }
                
                else if (userChoice.equalsIgnoreCase("No")){
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                }
                
                else{
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\033[38;5;196m" + "Invalid input.\n" + "\u001b[0m");
                }
                System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                userChoice = input.nextLine();
            }
            
            else if (userChoice.equalsIgnoreCase("Check Coins") || userChoice.equalsIgnoreCase("Coins") || userChoice.equalsIgnoreCase("Coin")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.println("Coins: \033[38;5;228m$" + newOre.getMoney() + "\u001b[0m");
                System.out.print("\nWhat do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                userChoice = input.nextLine();
            }
            
            else if (userChoice.equalsIgnoreCase("AutoRoll") || userChoice.equalsIgnoreCase("Auto") || userChoice.equalsIgnoreCase("Auto Roll")){
                if (newOre.inventorySize() < newOre.maxInventorySize()){
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    AutoRoll autoroll = new AutoRoll(newOre);
                    Thread autoRoll = new Thread(autoroll);
                    
                    if (newOre.getAutoRollLevel() == 1){
                        autoroll.setRollSpeed(85);
                    }
                    
                    else if (newOre.getAutoRollLevel() == 2){
                        autoroll.setRollSpeed(65);
                    }
                    
                    else if (newOre.getAutoRollLevel() == 3){
                        autoroll.setRollSpeed(45);
                    }
                    
                    else if (newOre.getAutoRollLevel() == 4){
                        autoroll.setRollSpeed(25);
                    }
                    autoRoll.start();
                    
                    System.out.println("Type anything to stop\n");
                    userChoice = input.nextLine();
            
                    autoroll.turnOffKeepRunning();
                    autoRoll.interrupt();
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                    userChoice = input.nextLine();
                }
                
                else{
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\u001b[1m\033[38;5;196m⚠︎  Inventory full\u001b[0m\n");
                    System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                    userChoice = input.nextLine();
                }
            }
            
            else if (userChoice.equalsIgnoreCase("Save")){
                try (FileWriter account = new FileWriter(playerUsername + ".txt", false)){
                    
                    account.write("PW:" + playerPassword + "\n");
                    if (newOre.isInWorldOne()){
                        account.write("IW1:t\n");
                    }
                    
                    else{
                        account.write("IW1:f\n");
                    }
                    
                    if (newOre.isInWorldTwo()){
                        account.write("IW2:t\n");
                    }
                    
                    else{
                        account.write("IW2:f\n");
                    }
                    
                    if (newOre.hasDiscoveredLegendary()){
                        account.write("DL:t\n");
                    }
                    
                    else{
                        account.write("DL:f\n");
                    }
                    
                    if (newOre.hasDiscoveredGodly()){
                        account.write("DG:t\n");
                    }
                    
                    else{
                        account.write("DG:f\n");
                    }
                    
                    if (newOre.hasDiscoveredMythic()){
                        account.write("DM:t\n");
                    }
                    
                    else{
                        account.write("DM:f\n");
                    }
                    
                    account.write("CF:" + newOre.numCommonsFound() + "\n");
                    account.write("UF:" + newOre.numUncommonsFound() + "\n");
                    account.write("RF:" + newOre.numRaresFound() + "\n");
                    account.write("EF:" + newOre.numEpicsFound() + "\n");
                    account.write("LF:" + newOre.numLegendariesFound() + "\n");
                    account.write("GF:" + newOre.numGodliesFound() + "\n");
                    account.write("MF:" + newOre.numMythicsFound() + "\n");
                    account.write("QF:" + newOre.numQuestionMarksFound() + "\n");
                    
                    if (newOre.onlyRollQuestionMarks()){
                        account.write("OR?:t\n");
                    }
                    
                    else{
                        account.write("OR?:f\n");
                    }
                    
                    if (newOre.onlyRollMythics()){
                        account.write("ORM:t\n");
                    }
                    
                    else{
                        account.write("ORM:f\n");
                    }
                    
                    if (newOre.onlyRollGodlies()){
                        account.write("ORG:t\n");
                    }
                    
                    else{
                        account.write("ORG:f\n");
                    }
                    
                    if (newOre.onlyRollLegendaries()){
                        account.write("ORL:t\n");
                    }
                    
                    else{
                        account.write("ORL:f\n");
                    }
                    
                    account.write("IS:" + newOre.inventorySize() + "\n");
                    account.write("MIS:" + newOre.maxInventorySize() + "\n");
                    account.write("L:" + newOre.luckLevel() + "\n");
                    account.write("MM:" + newOre.getMoneyMultiplier() + "\n");
                    account.write("AR:" + newOre.getAutoRollLevel() + "\n");
                    account.write("IL:" + newOre.inventoryLevel() + "\n");
                    account.write("TM:" + newOre.tempMoney() + "\n");
                    account.write("DM:" + newOre.displayMoney() + "\n");
                    account.write("TI:\n");
                    
                    ArrayList<String> temporaryInv = newOre.getTempInventory();
                    ArrayList<String> displayInv = newOre.getDisplayInventory();
                    
                    for (int i = 0; i < temporaryInv.size(); i++){
                        account.write(temporaryInv.get(i) + "\n");
                    }
                    
                    account.write("\nDI:\n");
                    
                    for (int i = 0; i < displayInv.size(); i++){
                        account.write(displayInv.get(i) + "\n");
                    }
                    account.write("\n");
                    account.close();
                    
                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\u001b[1m\033[38;5;214m⚠︎  Termination of program within 5 seconds of saving will result in data loss\n" + "\u001b[0m");
                    System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                    userChoice = input.nextLine();
                }
                
                catch (Exception e){
                }
            }
            
            else if (userChoice.equalsIgnoreCase("Admin Panel") || userChoice.equalsIgnoreCase("Console")){
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.print("\033[38;5;159m" + "Enter Password: " + "\033[38;5;45m");
                userChoice = input.nextLine();
                System.out.print("\u001b[0m");
                
                if (userChoice.equals("Galaxy3527")){
                    System.out.print("\u001b[0m" + "\u001B[2J" + "\u001B[0;0f");
                    System.out.print("Enter command (\"r\" to return): ");
                    userChoice = input.nextLine();
                    
                    while (userChoice.equalsIgnoreCase("r") == false){
                        if (userChoice.equalsIgnoreCase("Max_Upgrade_All")){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            newOre.setLuck(4);
                            System.out.println("Luck upgrade is now maxed.");
                            newOre.setMoneyMultiplier(5);
                            System.out.println("Coin multiplier is now maxed.");
                            newOre.setInventoryLevel(6);
                            newOre.setMaxInventorySize(400);
                            System.out.println("Inventory size is now maxed.");
                            newOre.setAutoRollLevel(4);
                            System.out.println("Autoroll speed is now maxed.");
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.toUpperCase().indexOf("SET_INVENTORY_SIZE_") == 0){
                            boolean containsNumber = false;
                            long amountChosen = 0;
                            for (int i = 0; i < userChoice.length(); i++){
                                char currentCharacter = userChoice.charAt(i);
                                if (Character.isDigit(currentCharacter)){
                                    amountChosen = Long.valueOf(userChoice.substring(i));
                                    containsNumber = true;
                                    break;
                                }
                                
                                else{
                                    containsNumber = false;
                                }
                            }
                            if (containsNumber == false){
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("\033[38;5;196m" + "Invalid amount" + "\u001b[0m");
                            }
                            
                            else{
                                newOre.setMaxInventorySize(amountChosen);
                                newOre.setInventoryLevel(6);
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("Inventory size is now " + amountChosen);
                            }
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.toUpperCase().indexOf("GIVE_COINS_") == 0){
                            boolean containsNumber = false;
                            long amountChosen = 0;
                            for (int i = 0; i < userChoice.length(); i++){
                                char currentCharacter = userChoice.charAt(i);
                                if (Character.isDigit(currentCharacter)){
                                    amountChosen = Long.valueOf(userChoice.substring(i));
                                    containsNumber = true;
                                    break;
                                }
                                
                                else{
                                    containsNumber = false;
                                }
                            }
                            if (containsNumber == false){
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("\033[38;5;196m" + "Invalid amount" + "\u001b[0m");
                            }
                            
                            else{
                                newOre.addMoney(amountChosen);
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("Added \033[38;5;228m$" + amountChosen + "\u001b[0m");
                            }
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.toUpperCase().indexOf("SET_LUCK_") == 0){
                            boolean containsNumber = false;
                            int amountChosen = 0;
                            for (int i = 0; i < userChoice.length(); i++){
                                char currentCharacter = userChoice.charAt(i);
                                if (Character.isDigit(currentCharacter)){
                                    amountChosen = Integer.valueOf(userChoice.substring(i));
                                    if (amountChosen <= 3 && amountChosen >= 0){
                                        containsNumber = true;
                                        break;
                                    }
                                    
                                    else{
                                        containsNumber = false;
                                        break;
                                    }
                                }
                            }
                            
                            if (containsNumber == false){
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("\033[38;5;196m" + "Invalid amount" + "\u001b[0m");
                            }
                            
                            else{
                                newOre.setLuck(amountChosen + 1);
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                if (amountChosen == 0){
                                    System.out.println("Luck level is now default");
                                }
                                else{
                                    System.out.println("Luck level is now \033[38;5;46m" + amountChosen + "\u001b[0m");
                                }
                            }
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.toUpperCase().indexOf("SET_COIN_MULTIPLIER_") == 0){
                            boolean containsNumber = false;
                            int amountChosen = 0;
                            for (int i = 0; i < userChoice.length(); i++){
                                char currentCharacter = userChoice.charAt(i);
                                if (Character.isDigit(currentCharacter)){
                                    amountChosen = Integer.valueOf(userChoice.substring(i));
                                    if (amountChosen <= 4 && amountChosen >= 0){
                                        containsNumber = true;
                                        break;
                                    }
                                    
                                    else{
                                        containsNumber = false;
                                        break;
                                    }
                                }
                            }
                            
                            if (containsNumber == false){
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("\033[38;5;196m" + "Invalid amount" + "\u001b[0m");
                            }
                            
                            else{
                                newOre.setMoneyMultiplier(amountChosen + 1);
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                if (amountChosen == 0){
                                    System.out.println("Coin multiplier is now default");
                                }
                                else{
                                    System.out.println("Coin multiplier is now \033[38;5;226m" + amountChosen + "\u001b[0m");
                                }
                            }
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.toUpperCase().indexOf("ONLY_ROLL_") == 0){
                            String tier = userChoice.substring(10);
                            boolean isTrue = tier.toUpperCase().indexOf("TRUE") != -1;
                            boolean isFalse = tier.toUpperCase().indexOf("FALSE") != -1;
                            if (isTrue){
                                tier = tier.substring(0, tier.length() - 5);
                                System.out.print(tier);
                                if (tier.equalsIgnoreCase("Legendary") || tier.equalsIgnoreCase("Legendaries")){
                                    newOre.onlyRollLegendaryTier(true);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Legendary roll activated");
                                }
                                
                                else if (tier.equalsIgnoreCase("Godly") || tier.equalsIgnoreCase("Godlies")){
                                    newOre.onlyRollGodlyTier(true);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Godly roll activated");
                                }
                                
                                else if (tier.equalsIgnoreCase("Mythic") || tier.equalsIgnoreCase("Mythics")){
                                    newOre.onlyRollMythicTier(true);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Mythic roll activated");
                                }
                                
                                else if (tier.equals("???")){
                                    newOre.onlyRollQuestionMarkTier(true);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("??? roll activated");
                                }
                                
                                else{
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("\033[38;5;196m" + "Invalid command." + "\u001b[0m");
                                }
                            }

                            else if (isFalse){
                                tier = tier.substring(0, tier.length() - 6);
                                if (tier.equalsIgnoreCase("Legendary") || tier.equalsIgnoreCase("Legendaries")){
                                    newOre.onlyRollLegendaryTier(false);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Legendary roll deactivated");
                                }
                                
                                else if (tier.equalsIgnoreCase("Godly") || tier.equalsIgnoreCase("Godlies")){
                                    newOre.onlyRollGodlyTier(false);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Godly roll deactivated");
                                }
                                
                                else if (tier.equalsIgnoreCase("Mythic") || tier.equalsIgnoreCase("Mythics")){
                                    newOre.onlyRollMythicTier(false);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("Mythic roll deactivated");
                                }
                                
                                else if (tier.equals("???")){
                                    newOre.onlyRollQuestionMarkTier(false);
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("??? roll deactivated");
                                }
                                
                                else{
                                    System.out.print("\u001B[2J" + "\u001B[0;0f");
                                    System.out.println("\033[38;5;196m" + "Invalid command." + "\u001b[0m");
                                }
                            }
                            
                            else{
                                System.out.print("\u001B[2J" + "\u001B[0;0f");
                                System.out.println("\033[38;5;196m" + "Invalid command." + "\u001b[0m");
                            }
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else if (userChoice.equalsIgnoreCase("Help")){
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("* Not case sensitive, do not include brackets\n");
                            System.out.println("- Max_Upgrade_All");
                            System.out.println("- Set_Inventory_Size_[Number]");
                            System.out.println("- Give_Coins_[Number]");
                            System.out.println("- Set_Luck_[Number 0-3]");
                            System.out.println("- Set_Coin_Multiplier_[Number 0-4]");
                            System.out.println("- Only_Roll_[Tier Name]_True");
                            System.out.println("- Only_Roll_[Tier Name]_False");
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                        
                        else{
                            System.out.print("\u001B[2J" + "\u001B[0;0f");
                            System.out.println("\033[38;5;196m" + "Invalid command." + "\u001b[0m");
                            System.out.print("\nEnter command (\"r\" to return): ");
                            userChoice = input.nextLine();
                        }
                    }
                    
                    if (userChoice.equalsIgnoreCase("r")){
                        System.out.print("\u001B[2J" + "\u001B[0;0f");
                        System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                        userChoice = input.nextLine();
                    }
                }
                // If the password for the admin panel is incorrect
                else{
                    System.out.print("\u001b[0m" + "\u001B[2J" + "\u001B[0;0f");
                    System.out.println("\033[38;5;196m" + "Incorrect password." + "\u001b[0m");
                    System.out.print("\nWhat do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                    userChoice = input.nextLine();
                }
            }
            
            else{
                System.out.print("\u001B[2J" + "\u001B[0;0f");
                System.out.println("\033[38;5;196m" + "Invalid input.\n" + "\u001b[0m");
                System.out.print("What do you want to do? (STOP to quit)\n- Roll Ore\n- Autoroll\n- Check Inventory\n- Check Coins\n- Upgrades\n- Sell Ores\n- Save\n --> ");
                userChoice = input.nextLine();
            }
        }
    }
}