
package racingDrivers.driver;

import racingDrivers.driverStates.RaceContext;
import racingDrivers.util.FileProcessor;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger; 

/**
 * @author Erwin Joshua Palani
 *
 */
    
    public class Driver {

    	/**
    	 * Returns a parsed Integer value. 
    	 * <p>
    	 * Parsing a String to an Integer value directly raises a NumberFormatException and terminates
		 * the execution of the program. To avoid this default exception from being raised, have created 
		 * the tryParseInt method that parses the String to an Integer value and returns the Integer value 
		 * everytime it reads an input from the file.
		 * <p>
		 * Source url {@link https://codereview.stackexchange.com/questions/19773/convert-string-to-integer-with-default-value}
		 *
    	 * @param str the string value that needs to be parsed 
		 *            into an Integer value
		 * @return the parsed Integer value
    	 */

    	public static Integer tryParseInt(String str){
	    	try{
	    		return Integer.parseInt(str);
	    	}
	    	catch(NumberFormatException nfe){
	    		return null;
	    	}
	    }
	
	public static void main(String[] args){
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used. It checks to see if 
	     * the user has provided an input file, output file and debug level value.
	     */

	    try{

	    	// A validation to check the command line arguments

	    	if(args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")){
	    		System.out.println("Please provide Input File, Output File and Debug value.");
	    		System.exit(0);
	    	}

	    	String inputFile = args[0];
	    	String outputFile = args[1];
	    	Integer debugValue = tryParseInt(args[2]);

 			// A validation to check if the debug value is within the scope

	    	if(debugValue < 0 || debugValue > 4){
	    		System.out.println("The debug value provided is out of scope. Please provide a value between 0 and 4.");
	    		System.exit(0);
	    	}

	    	MyLogger.setDebugValue(debugValue);
	    	FileProcessor fp = new FileProcessor(inputFile);

	    	// Reads the number of drivers participating in the race.

	    	String numDrivers = fp.readLine();
	    	
	    	RaceContext rc = new RaceContext(numDrivers);
	    	rc.initializingRace();
	    	String str = "";

	    	// Reads one line at a time from the input file and forwards it onto RaceContext Class.

	    	while(str != null){
	    		str = fp.readLine();
	    		if(str != null){
	    			rc.processInput(str);
	    		}
	    	}

	    	Results rslt = Results.getInstance();
	    	rslt.writeToFile(outputFile);
	    }
	    catch(Exception e){
	    	System.out.println("Could not parse file.");
	    	e.printStackTrace();
	    	System.exit(0);
	    }
	    
	}  // end public static void main
    }  // end public class Driver