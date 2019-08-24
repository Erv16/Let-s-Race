package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

public abstract class State implements DriverStateI{

	/**
	 * An abstract base class that helps in defining objects
	 * of different classes. 
	 * <p>
	 *	All of the classes that extend this class can make use
	 * of the objects defined out here. It is extended by the 
	 * state classes to capture results and contribute to logging.
	 * 
	 * source url: {@link https://www.geeksforgeeks.org/abstract-classes-in-java/}
	 */

	protected Results res = Results.getInstance();
	protected DriverContext ctx;
	protected MyLogger myLog;
	protected DebugLevel debugLev;
}