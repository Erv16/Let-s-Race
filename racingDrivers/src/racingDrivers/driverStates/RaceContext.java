package racingDrivers.driverStates;

import racingDrivers.driverStates.DriverContext;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

/**
 * @author Erwin Joshua Palani
 *
 */

public class RaceContext{

	/**
	 * The Race Driver Class just simply forwards operations to 
	 * all its Driver context instances.
	 */

	int numDrivers;
	Results res = Results.getInstance();

	public RaceContext(String n){

		/**
		 * The constructor parses the String input of the number of
		 * drivers to an Integer value.
		 * <p>
		 * A parameterized constructor that receives the number of 
		 * drivers as an input and parses it into an Integer value.
		 * It also validates the number of drivers to see if it is a 
		 * positive value.
		 *
		 * @param n a string argument containing the number of drivers.
		 */

		numDrivers = Integer.parseInt(n);
		
		// A validation to check if the number of drivers provided is valid or not.

		if(numDrivers < 0){
			System.out.println("The number of race drivers cannot be negative. Please provide a valid positive number of race drivers.");
			System.exit(1);
		}

		MyLogger.writeMessage("Reached the constructor of the RaceContext class. This constructor is used to instantiate the numDrivers variable",DebugLevel.CONSTRUCTOR);
	}

	DriverContext dr = new DriverContext();

	public void initializingRace(){

		/**
		 * Forwards the operation of initializing the driver context instances.
		 */

		dr.initDrivers(numDrivers);
	}

	String inputDistance[] = null;

	public void processInput(String str){

		/**
		 * The processInput method processes a single line read from the input file
		 * and provides the distance covered by each individual driver at a particular
		 * moment of time.
		 * <p>
		 * This method breaks down the line read based on white spaces and then invokes
		 * methods that help in associating distances with the respective driver context
		 * instances, calculate their positions and their states respectively. These set
		 * of methods are invoked every single time a single line is read, to process the
		 * driver context instance's chaneg in states.
		 *
		 * @param str the input string that contains the distances covered by every driver.
		 */

		MyLogger.writeMessage("Line Read: "+str,DebugLevel.FILE_PROCESSOR);

		inputDistance = str.split(" ");

		dr.insertDistance(numDrivers, inputDistance);
		dr.calcPosition(numDrivers);
		dr.calcState(numDrivers);

		// As buffered writer doesn't explicitly identify '\n' for adding a new line, 
		// '\r\n' needs to be used. It is used out here to format the output being written 
		// to the file.
		
		res.storeNewResult("\r\n");
	}

}