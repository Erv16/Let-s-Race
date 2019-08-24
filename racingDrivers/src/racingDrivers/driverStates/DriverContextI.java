package racingDrivers.driverStates;

/**
 * @author Erwin Joshua Palani
 */

public interface DriverContextI {

	/**
	 * An interface that declares all of the methods used by the driver context instances
	 * for initializations, inserting distances, calculating their positions and finally
	 * for calculating their states.
	 */

	public void initDrivers(int n);
	public void insertDistance(int n, String arr[]);
	public void calcPosition(int n);
	public void calcState(int n);
}