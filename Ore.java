import java.util.ArrayList;

public class Ore {
    
    private String name;
    private String rarity;
    String defaultTextColor = "\u001b[0m";
    private boolean inWorldOne;
    private boolean inWorldTwo;
    private boolean discoveredLegendary;
    private boolean discoveredGodly;
    private boolean discoveredMythic;
    private boolean onlyRollQuestionMarks;
    private boolean onlyRollMythics;
    private boolean onlyRollGodlies;
    private boolean onlyRollLegendaries;
    private int numCommonsFound;
    private int numUncommonsFound;
    private int numRaresFound;
    private int numEpicsFound;
    private int numLegendariesFound;
    private int numGodliesFound;
    private int numMythicsFound;
    private int numQuestionMarksFound;
    private int inventorySize;
    private long maxInventorySize;
    private int amount;
    private int luckAmount;
    private int moneyMultiplier;
    private int autoRollLevel;
    private int inventoryLevel;
    private long tempMoney;
    private long displayMoney;
    
    // Collection of all ores possible to obtain
    String[] commonList;
    String[] uncommonList;
    String[] rareList;
    String[] epicList;
    String[] legendaryList;
    String[] godlyList;
    String[] mythicList;
    String[] questionMarkList;
    
    ArrayList<String> tempInventory = new ArrayList<String>();
    ArrayList<String> displayInventory = new ArrayList<String>();
    
    public Ore(int luck, int moneyMult, int auto, int invLevel, boolean onlyQuestionMarks, boolean onlyGodlies, boolean onlyMythics, boolean onlyLegendaries, boolean inFirstWorld, boolean inSecondWorld, int invSize, long maxInvSize, boolean disLegendary, boolean disGodly, boolean disMythic, int numComFound, int numUncomFound, int numRareFound, int numEpicFound, int numLegendaryFound, int numGodlyFound, int numMythicFound, int numQuestionMarkFound, long tempMon, long displayMon, ArrayList<String> tempInv, ArrayList<String> displayInv){
        name = "Unknown Ore Name";
        rarity = "Unknown Rarity";
        inventorySize = 0;
        amount = 1;
        luckAmount = luck;
        moneyMultiplier = moneyMult;
        autoRollLevel = auto;
        inventoryLevel = invLevel;
        onlyRollQuestionMarks = onlyQuestionMarks;
        onlyRollGodlies = onlyGodlies;
        onlyRollMythics = onlyMythics;
        onlyRollLegendaries = onlyLegendaries;
        inWorldOne = inFirstWorld;
        inWorldTwo = inSecondWorld;
        inventorySize = invSize;
        maxInventorySize = maxInvSize;
        discoveredLegendary = disLegendary;
        discoveredGodly = disGodly;
        discoveredMythic = disMythic;
        numCommonsFound = numComFound;
        numUncommonsFound = numUncomFound;
        numRaresFound = numRareFound;
        numEpicsFound = numEpicFound;
        numLegendariesFound = numLegendaryFound;
        numGodliesFound = numGodlyFound;
        numMythicsFound = numMythicFound;
        numQuestionMarksFound = numQuestionMarkFound;
        tempMoney = tempMon;
        displayMoney = displayMon;
        
        for (int i = 0; i < tempInv.size(); i++){
            tempInventory.add(tempInv.get(i));
        }
        
        for (int i = 0; i < displayInv.size(); i++){
            displayInventory.add(displayInv.get(i));
        }
    }

    public void roll(){
        inventorySize++;
        
        if (inWorldOne){
            commonList = new String[]{"Stone", "Coal", "Granite", "Dirt", "Limestone", "Sandstone", "Shale"};
            uncommonList = new String[]{"Iron", "Copper", "Nickel", "Tin", "Lead", "Silver", "Lithium", "Bismuth"};
            rareList = new String[]{"Cobalt", "Titanium", "Magnetite", "Krypton", "Zinc", "Tungsten", "Arsenic"};
            epicList = new String[]{"Ruby", "Diamond", "Emerald", "Adurite", "Bluesteel", "Gold"};
            legendaryList = new String[]{"Luminite", "Uranium", "Cintrium", "Plutonium", "Amethyst"};
            godlyList = new String[]{"Solarite", "Chromium", "Onyx", "Vibranium", "Seramite", "Cantium"};
            mythicList = new String[]{"Ionite", "Galvanium", "Blossium", "Dynamium"};
            questionMarkList = new String[]{"Happite", "Valkyrite", "Aethanium", "Tessarite"};
        }
        
        else if (inWorldTwo){
            commonList = new String[]{"Basalt", "Blackstone"};
            uncommonList = new String[]{"Branchite"};
            rareList = new String[]{"Magma", "Walrite", "Delightium", "Voididium", "Seborgium", "Netherite", "Hollowite"};
            epicList = new String[]{"Hastite", "Bloxite", "Kraftium", "Planetite", "Saturnite", "Bizzarium"};
            legendaryList = new String[]{"Javium", "Pythine", "Cherrium", "Yranite"};
            godlyList = new String[]{"Malakite", "Scizite", "Nyranite", "Aeromite", "Anianite", "Catianite"};
            mythicList = new String[]{"Yinium", "Yangium", "Quantium", "Galaxite"};
            questionMarkList = new String[]{"Empriium", "Skibidium", "Ultimanium", "Elixite"};
        }
        
        if (onlyRollQuestionMarks){
            int chooseQuestionMarkOre = (int)(Math.random() * (questionMarkList.length) + 0);
            name = questionMarkList[chooseQuestionMarkOre];
            rarity = "???";
            numQuestionMarksFound++;
            
            if (numQuestionMarksFound == 1){
                System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
            }

            // Money Per ???
            if (inWorldOne){
                tempMoney += 200 * moneyMultiplier;
            }
            
            else if (inWorldTwo){
                tempMoney += 210 * moneyMultiplier;
            }
        }
        
        else if (onlyRollMythics){
            int chooseMythicOre = (int)(Math.random() * (mythicList.length) + 0);
            name = mythicList[chooseMythicOre];
            rarity = "Mythic";
            numMythicsFound++;
            discoveredMythic = true;
            
            if (numMythicsFound == 1){
                System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
            }
            
            // Money Per Mythic
            if (inWorldOne){
                tempMoney += 100 * moneyMultiplier;
            }
            
            else if (inWorldTwo){
                tempMoney += 107 * moneyMultiplier;
            }
        }
        
        else if (onlyRollGodlies){
            int chooseGodlyOre = (int)(Math.random() * (godlyList.length) + 0);
            name = godlyList[chooseGodlyOre];
            rarity = "Godly";
            numGodliesFound++;
            discoveredGodly = true;
            
            if (numGodliesFound == 1){
                System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
            }
            
            // Money Per Godly
            if (inWorldOne){
                tempMoney += 50 * moneyMultiplier;
            }
            
            else if (inWorldTwo){
                tempMoney += 55 * moneyMultiplier;
            }
        }
        
        else if (onlyRollLegendaries){
            int chooseLegendaryOre = (int)(Math.random() * (legendaryList.length) + 0);
            name = legendaryList[chooseLegendaryOre];
            rarity = "Legendary";
            numLegendariesFound++;
            discoveredLegendary = true;
            
            if (numLegendariesFound == 1){
                System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
            }
            
            // Money Per Legendary
            if (inWorldOne){
                tempMoney += 20 * moneyMultiplier;
            }
            
            else if (inWorldTwo){
                tempMoney += 23 * moneyMultiplier;
            }
        }
        
        else{
            // Common Tier
            int firstRoll;
            
            if (luckAmount >= 2){
                firstRoll = (int)(Math.random() * (3) + 1);
            }
            
            else{
                firstRoll = (int)(Math.random() * (2) + 1);
            }

            if (firstRoll == 1){
                int chooseCommonOre = (int)(Math.random() * (commonList.length) + 0);
                name = commonList[chooseCommonOre];
                rarity = "Common";
                numCommonsFound++;
                
                if (numCommonsFound == 1){
                    System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                }
                
                // Money Per Common
                if (inWorldOne){
                    tempMoney += 1 * moneyMultiplier;
                }
                
                else if (inWorldTwo){
                    tempMoney += 2 * moneyMultiplier;
                }
            }
            // Uncommon Tier
            else if (firstRoll >= 2){
                int nextLevelNumber;
                int secondRoll;
                // Increases chances of progressing past uncommon tier if the luck level is 1
                if (luckAmount >= 3){
                    secondRoll = (int)(Math.random() * (2) + 1);
                    nextLevelNumber = 2;
                }
                else{
                    secondRoll = (int)(Math.random() * (3) + 1);
                    nextLevelNumber = 3;
                }
                
                if (secondRoll < nextLevelNumber){
                    int chooseUncommonOre = (int)(Math.random() * (uncommonList.length) + 0);
                    name = uncommonList[chooseUncommonOre];
                    rarity = "Uncommon";
                    numUncommonsFound++;
                    
                    if (numUncommonsFound == 1){
                        System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                    }
                    
                    // Money Per Uncommon
                    if (inWorldOne){
                        tempMoney += 2 * moneyMultiplier;
                    }
                    
                    else if (inWorldTwo){
                        tempMoney += 3 * moneyMultiplier;
                    }
                }
                // Rare Tier
                else if (secondRoll == nextLevelNumber){
                    int thirdRoll;
                    
                    if (luckAmount >= 3){
                        thirdRoll = (int)(Math.random() * (2) + 1);
                        nextLevelNumber = 2;
                    }
                    
                    else{
                        thirdRoll = (int)(Math.random() * (4 - (luckAmount / 2)) + 1);
                        nextLevelNumber = 4 - (luckAmount / 2);
                    }

                    if (thirdRoll < nextLevelNumber){
                        int chooseRareOre = (int)(Math.random() * (rareList.length) + 0);
                        name = rareList[chooseRareOre];
                        rarity = "Rare";
                        numRaresFound++;
                        
                        if (numRaresFound == 1){
                            System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                        }
                        
                        // Money Per Rare
                        if (inWorldOne){
                            tempMoney += 5 * moneyMultiplier;
                        }
                        
                        else if (inWorldTwo){
                            tempMoney += 7 * moneyMultiplier;
                        }
                    }
                    // Epic Tier
                    else if (thirdRoll == nextLevelNumber){
                        int fourthRoll = (int)(Math.random() * (6 - luckAmount) + 1);
                        
                        if (fourthRoll <= 5 - luckAmount){
                            int chooseEpicOre = (int)(Math.random() * (epicList.length) + 0);
                            name = epicList[chooseEpicOre];
                            rarity = "Epic";
                            numEpicsFound++;
                            
                            if (numEpicsFound == 1){
                                System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                            }
                            
                            // Money Per Epic
                            if (inWorldOne){
                                tempMoney += 10 * moneyMultiplier;
                            }
                            
                            else if (inWorldTwo){
                                tempMoney += 12 * moneyMultiplier;
                            }
                        }
                        // Legendary Tier
                        else if (fourthRoll == 6 - luckAmount){
                            int fifthRoll = (int)(Math.random() * (7 - luckAmount) + 1);
                            
                            if (fifthRoll <= 6 - luckAmount){
                                int chooseLegendaryOre = (int)(Math.random() * (legendaryList.length) + 0);
                                name = legendaryList[chooseLegendaryOre];
                                rarity = "Legendary";
                                numLegendariesFound++;
                                discoveredLegendary = true;
                                
                                if (numLegendariesFound == 1){
                                    System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                                }
                                
                                // Money Per Legendary
                                if (inWorldOne){
                                    tempMoney += 20 * moneyMultiplier;
                                }
                                
                                else if (inWorldTwo){
                                    tempMoney += 23 * moneyMultiplier;
                                }
                            }
                            // Godly Tier
                            else if (fifthRoll == 7 - luckAmount){
                                int sixthRoll = (int)(Math.random() * (7 - (luckAmount + (luckAmount / 3))) + 1);
                                
                                if (sixthRoll <= 6 - (luckAmount + (luckAmount / 3))){
                                    int chooseGodlyOre = (int)(Math.random() * (godlyList.length) + 0);
                                    name = godlyList[chooseGodlyOre];
                                    rarity = "Godly";
                                    numGodliesFound++;
                                    discoveredGodly = true;
                                    
                                    if (numGodliesFound == 1){
                                        System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                                    }
                                    
                                    // Money Per Godly
                                    if (inWorldOne){
                                        tempMoney += 50 * moneyMultiplier;
                                    }
                                    
                                    else if (inWorldTwo){
                                        tempMoney += 55 * moneyMultiplier;
                                    }
                                }
                                // Mythic Tier
                                else if (sixthRoll == 7 - (luckAmount + (luckAmount / 3))){
                                    int seventhRoll = (int)(Math.random() * (8 - (luckAmount + (luckAmount / 2))) + 1);
                                    
                                    if (seventhRoll <= 7 - (luckAmount + (luckAmount / 2))){
                                        int chooseMythicOre = (int)(Math.random() * (mythicList.length) + 0);
                                        name = mythicList[chooseMythicOre];
                                        rarity = "Mythic";
                                        numMythicsFound++;
                                        discoveredMythic = true;
                                        
                                        if (numMythicsFound == 1){
                                            System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                                        }
                                        
                                        // Money Per Mythic
                                        if (inWorldOne){
                                            tempMoney += 100 * moneyMultiplier;
                                        }
                                        
                                        else if (inWorldTwo){
                                            tempMoney += 107 * moneyMultiplier;
                                        }
                                    }
                                    
                                    // ??? Tier
                                    else if (seventhRoll == 8 - (luckAmount + (luckAmount / 2))){
        
                                        int chooseQuestionMarkOre = (int)(Math.random() * (questionMarkList.length) + 0);
                                        name = questionMarkList[chooseQuestionMarkOre];
                                        rarity = "???";
                                        numQuestionMarksFound++;
                                        
                                        if (numQuestionMarksFound == 1){
                                            System.out.println("\033[38;5;192m" + "** New Tier Discovery!" + defaultTextColor);
                                        }

                                        // Money Per ???
                                        if (inWorldOne){
                                            tempMoney += 200 * moneyMultiplier;
                                        }
                                        
                                        else if (inWorldTwo){
                                            tempMoney += 210 * moneyMultiplier;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Counts the amount of the ore in the inventory
        amount = 1;
        for(int i = 0; i < tempInventory.size(); i++){
            if (tempInventory.get(i) == name){
                amount += 1;
            }
        }
        tempInventory.add(name);
        
        // Prevents the inventoryLength from being 0
        if (displayInventory.size() == 0){
            displayInventory.add("1x " + name);
        }
        
        // Updates the number of each ore in the inventory
        int inventoryLength = displayInventory.size();
        boolean alreadyFoundOre = false;
        
        for(int i = 0; i < inventoryLength; i++){
            String filteredIndex = displayInventory.get(i);
            
            // Removes the "#x" in the ore name
            int indexToRemove = filteredIndex.indexOf("x");
            filteredIndex = filteredIndex.substring(indexToRemove + 2);
            

            if (filteredIndex.equals(name)){
                displayInventory.set(i, amount + "x " + name);
                alreadyFoundOre = true;
            }
            
            if ((inventoryLength - 1 == i) && (!alreadyFoundOre)){
                displayInventory.add("1x " + name);
            }
        }
        
        // Each mini-inventory will contain the grouped ore based on its rarity
        ArrayList<String> totalCommons = new ArrayList<String>();
        ArrayList<String> totalUncommons = new ArrayList<String>();
        ArrayList<String> totalRares = new ArrayList<String>();
        ArrayList<String> totalEpics = new ArrayList<String>();
        ArrayList<String> totalLegendaries = new ArrayList<String>();
        ArrayList<String> totalGodlies = new ArrayList<String>();
        ArrayList<String> totalMythics = new ArrayList<String>();
        ArrayList<String> totalQuestionMarks = new ArrayList<String>();
        
        // Checks the value of each ore in displayInventory and sorts it into its
        // correlating mini-inventory
        for(int i = 0; i < displayInventory.size(); i++){
            String unchangedIndex = displayInventory.get(i);
            String filteredIndex = displayInventory.get(i);
            
            // Removes the "#x" in the ore name so it can find its rarity
            int indexToRemove = filteredIndex.indexOf("x");
            filteredIndex = filteredIndex.substring(indexToRemove + 2);
            
            int rarityOfOre = getValue(filteredIndex);
            if (rarityOfOre == 1){
                totalCommons.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 2){
                totalUncommons.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 3){
                totalRares.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 4){
                totalEpics.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 5){
                totalLegendaries.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 6){
                totalGodlies.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 7){
                totalMythics.add(unchangedIndex);
            }
            
            else if (rarityOfOre == 8){
                totalQuestionMarks.add(unchangedIndex);
            }
        }
        
        // Clears the unsorted displayInventory for it to be sorted
        displayInventory.clear();
        
        // Adds each ore to the inventory in order of rarity
        for (int i = 0; i < totalQuestionMarks.size(); i++){
            displayInventory.add(totalQuestionMarks.get(i));
        }
        
        for (int i = 0; i < totalMythics.size(); i++){
            displayInventory.add(totalMythics.get(i));
        }
        
        for (int i = 0; i < totalGodlies.size(); i++){
            displayInventory.add(totalGodlies.get(i));
        }
        
        for (int i = 0; i < totalLegendaries.size(); i++){
            displayInventory.add(totalLegendaries.get(i));
        }
        
        for (int i = 0; i < totalEpics.size(); i++){
            displayInventory.add(totalEpics.get(i));
        }
        
        for (int i = 0; i < totalRares.size(); i++){
            displayInventory.add(totalRares.get(i));
        }
        
        for (int i = 0; i < totalUncommons.size(); i++){
            displayInventory.add(totalUncommons.get(i));
        }
        
        for (int i = 0; i < totalCommons.size(); i++){
            displayInventory.add(totalCommons.get(i));
        }
    }
    
    // Retrieves the value of the ore
    public int getValue(String oreName){
        for (int index = 0; index < commonList.length; index++){
            // If the given ore exists as a common ore names
            if (oreName.equals(commonList[index])){
                return 1;
            }
        }
        
        for (int index = 0; index < uncommonList.length; index++){
            // If the given ore exists as a uncommon ore names
            if (oreName.equals(uncommonList[index])){
                return 2;
            }
        }
        
        for (int index = 0; index < rareList.length; index++){
            // If the given ore exists as a rare ore names
            if (oreName.equals(rareList[index])){
                return 3;
            }
        }
        
        for (int index = 0; index < epicList.length; index++){
            // If the given ore exists as a epic ore names
            if (oreName.equals(epicList[index])){
                return 4;
            }
        }
        
        for (int index = 0; index < legendaryList.length; index++){
            // If the given ore exists as a legendary ore names
            if (oreName.equals(legendaryList[index])){
                return 5;
            }
        }
        
        for (int index = 0; index < godlyList.length; index++){
            // If the given ore exists as a godly ore name
            if (oreName.equals(godlyList[index])){
                return 6;
            }
        }
        
        for (int index = 0; index < mythicList.length; index++){
            // If the given ore exists as a mythic ore name
            if (oreName.equals(mythicList[index])){
                return 7;
            }
        }
        
        for (int index = 0; index < questionMarkList.length; index++){
            // If the given ore exists as a ??? ore name
            if (oreName.equals(questionMarkList[index])){
                return 8;
            }
        }
        
        // If all criteria above is somehow not met, a default value of -999 will 
        // be returned to ensure that the program does not error
        return -999;
    }
    
    public String getName(){
        String textColor = "\033[38;5;233m";
        
        if (rarity.equals("Common")){
            textColor = "\033[38;5;250m";
        }
        
        else if (rarity.equals("Uncommon")){
            textColor = "\033[0;92m";
        }
        
        else if (rarity.equals("Rare")){
            textColor = "\033[0;93m";
        }
        
        else if (rarity.equals("Epic")){
            textColor = "\033[0;94m";
        }
        
        else if (rarity.equals("Legendary")){
            textColor = "\033[38;5;196m";
        }
        
        else if (rarity.equals("Godly")){
            if (inWorldOne){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;219m[G" + "\033[38;5;213mod" + "\033[38;5;207mly" + "\033[38;5;201m]" + "\u001b[0m" + defaultTextColor;
            }
            
            else if (inWorldTwo){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;44m[G" + "\033[38;5;43mod" + "\033[38;5;42mly" + "\033[38;5;41m]" + "\u001b[0m" + defaultTextColor;
            }
        }
        
        else if (rarity.equals("Mythic")){
            if (inWorldOne){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;220m[M" + "\033[38;5;214myt" + "\033[38;5;208mhi" + "\033[38;5;202mc]" + "\u001b[0m" + defaultTextColor;
            }
            
            else if (inWorldTwo){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;208m[M" + "\033[38;5;172myt" + "\033[38;5;136mhi" + "\033[38;5;100mc]" + "\u001b[0m" + defaultTextColor;
            }
        }
        
        else if (rarity.equals("???")){
            if (inWorldOne){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;21m[" + "\033[38;5;57m?" + "\033[38;5;93m?" + "\033[38;5;129m?" + "\033[38;5;165m]" + "\u001b[0m" + defaultTextColor;
            }
            
            else if (inWorldTwo){
                return "You got: " + name + " \u001b[1m" + "\033[38;5;201m[" + "\033[38;5;200m?" + "\033[38;5;199m?" + "\033[38;5;198m?" + "\033[38;5;197m]" + "\u001b[0m" + defaultTextColor;
            }
        }
        
        return "You got: " + name + textColor + " \u001b[1m[" + rarity + "]\u001b[0m" + defaultTextColor;
    }
    
    public String checkInventory(){
        String inv = "";
        if (inventorySize == maxInventorySize){
            inv += "\u001b[1m\033[38;5;196m(" + inventorySize + "/" + maxInventorySize + ")" + defaultTextColor + ":\u001b[0m [";
        }
        
        else{
            inv += "(" + inventorySize + "/" + maxInventorySize + "): [";
        }
        
        for (int i = 0; i < displayInventory.size(); i++){
            if (i == displayInventory.size() - 1){
                inv += displayInventory.get(i);
            }
            
            else{
                inv += displayInventory.get(i) + ", ";
            }
        }
        inv += "]";
        return inv;
    }
    
    public long tempMoney(){
        return tempMoney;
    }
    
    public long displayMoney(){
        return displayMoney;
    }
    
    public int inventorySize(){
        return inventorySize;
    }
    
    public long maxInventorySize(){
        return maxInventorySize;
    }
    
    public void clearInventory(){
        displayInventory.clear();
        tempInventory.clear();
        inventorySize = 0;
    }
    
    public void setLuck(int number){
        luckAmount = number;
    }
    
    public int luckLevel(){
        return luckAmount;
    }
    
    public int inventoryLevel(){
        return inventoryLevel;
    }
    
    public void setInventoryLevel(int level){
        inventoryLevel = level;
    }
    
    public void setMaxInventorySize(long size){
        maxInventorySize = size;
    }
    
    // Checks if the player meets the requirements to upgrade luck
    public boolean firstUpgradeRequirement(){
        return discoveredLegendary && luckAmount == 1;
    }
    
    public boolean secondUpgradeRequirement(){
        return discoveredGodly && luckAmount == 2;
    }
    
    public boolean thirdUpgradeRequirement(){
        return discoveredMythic && luckAmount == 3;
    }
    
    public int getMoneyMultiplier(){
        return moneyMultiplier;
    }
    
    public void setMoneyMultiplier(int setAmount){
        moneyMultiplier = setAmount;
    }
    
    public long getMoney(){
        return displayMoney;
    }
    
    public void addMoney(long amountToAdd){
        displayMoney += amountToAdd;
        tempMoney = displayMoney;
    }
    
    public void setMoney(long setAmount){
        tempMoney = setAmount;
        displayMoney = setAmount;
    }
    
    public void sellAll(){
        displayMoney = tempMoney;
        displayInventory.clear();
        tempInventory.clear();
        inventorySize = 0;
    }
    
    public int getAutoRollLevel(){
        return autoRollLevel;
    }
    
    public void setAutoRollLevel(int level){
        autoRollLevel = level;
    }
    
    public void undiscoverAll(){
        numCommonsFound = 0;
        numUncommonsFound = 0;
        numRaresFound = 0;
        numEpicsFound = 0;
        numLegendariesFound = 0;
        numGodliesFound = 0;
        numMythicsFound = 0;
        numQuestionMarksFound = 0;
        discoveredLegendary = false;
        discoveredGodly = false;
        discoveredMythic = false;
    }
    
    public void onlyRollQuestionMarkTier(boolean status){
        onlyRollQuestionMarks = status;
        if (status == true){
            onlyRollMythics = false;
            onlyRollGodlies = false;
            onlyRollLegendaries = false;
        }
    }
    
    public void onlyRollMythicTier(boolean status){
        onlyRollMythics = status;
        if (status == true){
            onlyRollQuestionMarks = false;
            onlyRollGodlies = false;
            onlyRollLegendaries = false;
        }
    }
    
    public void onlyRollGodlyTier(boolean status){
        onlyRollGodlies = status;
        if (status == true){
            onlyRollQuestionMarks = false;
            onlyRollMythics = false;
            onlyRollLegendaries = false;
        }
    }
    
    public void onlyRollLegendaryTier(boolean status){
        onlyRollLegendaries = status;
        if (status == true){
            onlyRollGodlies = false;
            onlyRollMythics = false;
            onlyRollQuestionMarks = false;
        }
    }
    
    public boolean onlyRollLegendaries(){
        return onlyRollLegendaries;
    }
    
    public boolean onlyRollGodlies(){
        return onlyRollGodlies;
    }
    
    public boolean onlyRollMythics(){
        return onlyRollMythics;
    }
    
    public boolean onlyRollQuestionMarks(){
        return onlyRollQuestionMarks;
    }
    
    public boolean isInWorldOne(){
        return inWorldOne;
    }
    
    public boolean isInWorldTwo(){
        return inWorldTwo;
    }
    
    public void goToWorldOne(){
        inWorldOne = true;
        inWorldTwo = false;
    }
    
    public void goToWorldTwo(){
        inWorldOne = false;
        inWorldTwo = true;
    }
    
    public boolean hasDiscoveredLegendary(){
        return discoveredLegendary;
    }
    
    public boolean hasDiscoveredGodly(){
        return discoveredGodly;
    }
    
    public boolean hasDiscoveredMythic(){
        return discoveredMythic;
    }
    
    public int numCommonsFound(){
        return numCommonsFound;
    }
    
    public int numUncommonsFound(){
        return numUncommonsFound;
    }
    
    public int numRaresFound(){
        return numRaresFound;
    }
    
    public int numEpicsFound(){
        return numEpicsFound;
    }
    
    public int numLegendariesFound(){
        return numLegendariesFound;
    }
    
    public int numGodliesFound(){
        return numGodliesFound;
    }
    
    public int numMythicsFound(){
        return numMythicsFound;
    }
    
    public int numQuestionMarksFound(){
        return numQuestionMarksFound;
    }
    
    public ArrayList<String> getTempInventory(){
        return tempInventory;
    }
    
    public ArrayList<String> getDisplayInventory(){
        return displayInventory;
    }
}