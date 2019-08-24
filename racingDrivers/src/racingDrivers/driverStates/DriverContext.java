package racingDrivers.driverStates;

import racingDrivers.driverStates.RaceContext;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

/**
 * @author Erwin Joshua Palani
 */

public class DriverContext implements DriverContextI{
 
	/**
	 * The DriverContext class provides implementations for computing different
	 * aspects related to the driver context instances.
	 * <p>
	 * This class contains methods that help calculate the positions of the drivers
	 * based on their distances and then compute their respective states.
	 *
	 */

	private int position;
	private double distance;
	private boolean tie;
	private Reckless reckless;
	private Calculative calculative;
	private Confident confident;
	private DriverStateI currentState;

	public DriverContext(){

		/**
		 * A default constructor that is used to instatntiate every instance 
		 * created of DriverContext with default attributes.
		 *
		 */

		position = 1; // Assigning a default position of 1 to every DriverContext instance.
		distance = 0.0; // Assigning a default distance of 0 for every DriverContext instance.
		tie = false; // A flag used to identify if there is a tie between different DriverContext instances.
		reckless = new Reckless();
		calculative = new Calculative();
		confident = new Confident();
		MyLogger.writeMessage("Reached the constructor of the DriverContext class. Used for instantiating the driver instances.",DebugLevel.CONSTRUCTOR);
	}

	/**
	 * An array of objects of DriverContext is being used to store each of the DriverContext instances.
	 */

	DriverContext driver[] = null;

	public void initDrivers(int n){

		/**
		 * The initDrivers method helps in creating/instantiating each of the DriverContext instances.
		 * <p>
		 * This method receives the number of drivers provided in the input and accordingly creates the
		 * same number of DriverContext instances to be used for further processing.
		 *
		 * @param n number of drivers
		 */

		driver = new DriverContext[n];

		for(int i = 0; i < n; i++){
			driver[i] = new DriverContext();
		}
	}

	public void insertDistance(int n, String inputDistance[]){

		/**
		 * The insertDistance method assigns/updates the distance for each of the Driver Context instances (drivers).
		 * <p>
		 * The distances are read from the input file and are stored in an array which is passed as an argument to 
		 * this method. In this method the elements of the array are read and are assigned to each of the drivers.
		 * It also checks to see if any of the provided distances is negative. If so it provides a message to the 
		 * user and exits.
		 *
		 * @param n the number of drivers
		 * @param inputDistance an array containing the distances for each driver
		 */

		for(int i = 0; i < n; i++){
			if(Double.parseDouble(inputDistance[i]) > 0){

				// As the distances read are in String format, parsing it to Double and assigning it 
				//to each respective Driver

				driver[i].distance += Double.parseDouble(inputDistance[i]);
			}
			else{
				System.out.println("The distance provided is negative. Distances cannot be negative. Please provide positive distance values.");
				System.exit(1);
			}
		}
	}

	public void calcPosition(int n){

		/**
		 * The calcPosition calculates the position/rank of a driver based on their respective distance.
		 * <p>
		 * This method compares the distance amongst all the drivers (Driver Context Instances) and 
		 * assigns them a position based on their disatnce. It also checks to see if any of the 
		 * Driver Context Instances have any ties. If ties exist, it sets the tie flag to true.
		 *
		 * @param n the number of Drivers
		 */

		for(int j = 0; j < n; j++){
			driver[j].position = 1;
			driver[j].tie = false;
		}


		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(driver[i].distance < driver[j].distance)
					driver[i].position++;
				else if(driver[i].distance > driver[j].distance)
					driver[j].position++;
			}
		}

		for(int k = 0; k < n; k++){
			for(int l = k+1; l < n; l++){
				if(driver[k].position == driver[l].position){
					driver[l].tie = true;
					driver[k].tie = true;
				}
			}
		}
	}

	public void calcState(int n){

		/**
		 * The calcState method decides the state of mind for a Driver.
		 * <p>
		 * The calcState method uses the position of each Driver (Driver Context Instance) and
		 * based on computations identifies the state of mind for a particular instance. On 
		 * identifying the state of mind, it uses that respective state's object to invoke
		 * a method whose definition/implementation is provided in that state's class.
		 *
		 * @param n the number of Drivers.
		 */

		for(int i = 0; i < n; i++){
				if(driver[i].position < (0.3 * 4) && (driver[i].tie == false)){
					confident.processState(this);
				}
				else if((Math.round(0.3 * 4) <= driver[i].position) && (driver[i].position < Math.round(0.7 * 4)) && (driver[i].tie == false)){
					calculative.processState(this);
				}
				else if((driver[i].position >= Math.round(0.7 * 4)) || (driver[i].tie == true)){
					reckless.processState(this);
				}
			}

	}

	public DriverStateI getCurrentState(){

		/**
		 * This methode returns the current state of the Driver.
		 */

		return currentState;
	}

	public void setCurrentState(DriverStateI currentState){

		/**
		 * This method sets the current state of the Driver.
		 *
		 * @param currentState the current state that needs to be set for the Driver.
		 */

		this.currentState = currentState;
	}

	public Reckless getRecklessState(){

		/**
		 * This method returns an object of state Reckless.
		 */

		return reckless;
	}

	public void setRecklessState(Reckless reckless){

		/**
		 * This method sets the Reckless state of a Driver.
		 *
		 * @param reckless object of state Reckless.
		 */ 

		this.reckless = reckless;
	}

	public Calculative getCalculativeState(){

		/**
		 * This method returns an object of state Calculative.
		 */

		return calculative;
	}

	public void setCalculativeState(Calculative calculative){

		/**
		 * This method sets the Calculative state of a Driver.
		 *
		 * @param calculative object of state Calculative.
		 */

		this.calculative = calculative;
	}

	public Confident getConfidentState(){

		/**
		 * This method returns an object of state Confident.
		 */

		return confident;
	}

	public void setConfidentState(Confident confident){

		/**
		 * This method sets the Confident state of a Driver.
		 *
		 * @param confident object of state Confident.
		 */

		this.confident = confident;
	}

	@Override
	public String toString(){

		/**
		 * A toString method for debugging purposes.
		 */

		System.out.println("The Driver positions are as follows:");
		for(int i = 0; i < driver.length; i++){
			System.out.println(driver[i].position);
		}
		return null;
	}

}