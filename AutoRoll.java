public class AutoRoll implements Runnable 
{
    private Ore ore;
    private int rollSpeed;
    private boolean keepRunning = true;
    
    public AutoRoll(Ore oreToRoll){
        ore = oreToRoll;
        rollSpeed = 150;
    }
    
    public void setRollSpeed(int speed){
        rollSpeed = speed;
    }
    
    public void turnOffKeepRunning(){
        keepRunning = false;
    }
    
    public void run(){
        while (keepRunning){
            if (ore.inventorySize() < ore.maxInventorySize()){
                ore.roll();
                System.out.println(ore.getName() + "\n");
            }
            
            else{
                System.out.println("\u001b[1m\033[38;5;196m⚠︎  Inventory full\u001b[0m\n");
            }
            try {
                Thread.sleep(rollSpeed);
            } 
            catch (InterruptedException e){
            }
        }
    }
}