package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

public class Reckless extends State implements DriverStateI{

	/**
	 * This class sets a driver context instance's state to Reckless.
	 */

	public Reckless(){

		/**
		 * The constructor of Reckless class. It is used for logging debug messages.
		 */

		myLog.writeMessage("Reached the constructor of the Reckless State class",debugLev.CONSTRUCTOR);
	}

	public void processState(DriverContext ctx){

		/** 
		 * Sets the current state to Reckless.
		 * <p>
		 * The processState method accepts a driver context instance as an argument.
		 * It sets the receieved driver context instance's current state to Reckless.
		 *
		 * @param ctx the driver context instance whose state needs to be set
		 */

		ctx.setCurrentState(ctx.getRecklessState());
		res.storeNewResult("Reckless\t");
		myLog.writeMessage("The current state of mind of the driver is Reckless. State: "+String.valueOf(ctx.getCurrentState()),debugLev.IN_RUN);
	}

}