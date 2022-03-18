//Add Phidgets and doodlepad Library 
// Class to paly tug of war game, better graphic
import doodlepad.*;
import com.phidget22.*;
public class TugOfWarBetter {

	private Rectangle red;
	private Rectangle green;
	private int red_size;
	private int green_size;

	public TugOfWarBetter() { // The Constructor: Graphically sets the scence
		// Default the red and green
		red_size = 10;
		green_size = 10;
		red = new Rectangle(0, 0, red_size, 300);
		green = new Rectangle(0, 300, green_size, 300);
		red.setFillColor(255, 0, 0);
		green.setFillColor(0, 128, 0);
	} // end of the Consturctor
    
    public void update_status(String player) { // update status of the player, player move right graphically
		// check update Red or Green
		// redraw shap, set color
		if (player.equals("Red")) {
			red_size += 20;
			red = new Rectangle(0, 0, red_size, 300);
			red.setFillColor(255, 0, 0);
		} else {
			green_size += 20;
			green = new Rectangle(0, 300, green_size, 300);
			green.setFillColor(0, 128, 0);
		}
	} // end of update status method
	
	public int getRedSize() { // accessor
		return red_size;
	} // end of accessor
	
	public int greenRedSize() { // accessor
		return green_size;
	} // end of accessor
	
    public static void main(String[] args) throws Exception{ // main method
        //Create 
        DigitalInput redButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput greenLED = new DigitalOutput();

        //Address 
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        //Open 
        redButton.open(1000);
        redLED.open(1000);
        greenButton.open(1000);
        greenLED.open(1000);
        
        // create the graphic
        TugOfWarBetter graphic = new TugOfWarBetter();
        
        int num_red = 0;
        int num_green = 0;
        //Use your Phidgets, playing tug of war
        while(graphic.getRedSize() < 600 && graphic.greenRedSize() < 600){ // condition when competition stops
			if (redButton.getState()) { // if red button pressed, update red graphic
				num_red ++;
				graphic.update_status("Red");
			}
			if (greenButton.getState()) { // if red button pressed, update green graphic
				num_green ++;
				graphic.update_status("Green");
			}
			Thread.sleep(75);
        } // end of while loop
    } // end of main method
} // end of the class
