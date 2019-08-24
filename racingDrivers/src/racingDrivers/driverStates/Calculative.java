package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

public class Calculative extends State implements DriverStateI{

	/**
	 * This class sets a driver context instance's state to Calculative.
	 */

	public Calculative(){

		/**
		 * The constructor of Calculative class. It is used for logging debug messages.
		 */

		myLog.writeMessage("Reached the constructor of the Calculative State File",debugLev.CONSTRUCTOR);
	}

	public void processState(DriverContext ctx){

		/** 
		 * Sets the current state to Calculative.
		 * <p>
		 * The processState method accepts a driver context instance as an argument.
		 * It sets the receieved driver context instance's current state to Calculative.
		 *
		 * @param ctx the driver context instance whose state needs to be set
		 */ 

		ctx.setCurrentState(ctx.getCalculativeState());
		res.storeNewResult("Calculative\t");
		myLog.writeMessage("The current state of mind of the driver is Calculative. State:"+String.valueOf(ctx.getCurrentState()),debugLev.IN_RUN);
	}
}