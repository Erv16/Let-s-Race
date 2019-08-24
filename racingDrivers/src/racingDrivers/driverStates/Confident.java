package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

public class Confident extends State implements DriverStateI{

	/**
	 * This class sets a driver context instance's state to Confident.
	 */

	public Confident(){

		/**
		 * The constructor of Confident class. It is used for logging debug messages.
		 */

		myLog.writeMessage("Reached the constructor for the Confident State File",debugLev.CONSTRUCTOR);
	}

	public void processState(DriverContext ctx){

		/** 
		 * Sets the current state to Confident.
		 * <p>
		 * The processState method accepts a driver context instance as an argument.
		 * It sets the receieved driver context instance's current state to Confident.
		 *
		 * @param ctx the driver context instance whose state needs to be set
		 */ 

		ctx.setCurrentState(ctx.getConfidentState());
		res.storeNewResult("Confident\t");
		myLog.writeMessage("The current state of mind of the driver is Confident. State: "+String.valueOf(ctx.getCurrentState()),debugLev.IN_RUN);
	}
}