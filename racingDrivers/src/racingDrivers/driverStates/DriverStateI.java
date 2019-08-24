package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

public interface DriverStateI {

	/**
	 * An Interface that provides the processState method's declaration that is 
	 * used to set a dirver context instance's current state.
	 * <p>
	 * This interface is implemented by the different state classes, and those state
	 * classes provide the implementation for the processState method.
	 */

	public void processState(DriverContext ctx);
}