
package racingDrivers.util;

/**
 * @author Erwin Joshua Palani
 */

public class MyLogger{

  /**
   * The MyLogger class is used for Logging debug updates.
   */

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called. Prints the output to the file.]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed. Prints the output to the file.]
      DEBUG_VALUE=2 [Print to stdout each of the results being written to file. Prints the output to the file.]
      DEBUG_VALUE=1 [Print to stdout updates on FileProcessor and the lines being read from the input file. Prints the output to the file.]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, FILE_PROCESSOR, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {

      /**
       * The setDebugValue is used for identifying which debug case
       * should be invoked based on the argument value.
       *
       * @param levelIn the debug level value
       */

	   switch (levelIn) {
	  	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  	  case 3: debugLevel = DebugLevel.IN_RUN; break;
      	case 2: debugLevel = DebugLevel.IN_RESULTS; break;
      	case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
	  	  case 0: debugLevel = DebugLevel.RELEASE; break;
		  }
    }

    public static void setDebugValue (DebugLevel levelIn) {
	     debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {

      /**
       * The writeMessage method writes all of the debugging messages
       * associated with a particular debug level onto the console.
       * 
       * @param message the actual message that needs to be written
       * @param levelIn the associated debug level
       */

	     if (levelIn == debugLevel)
	       System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {

      /**
       * A toString method to print the debu level
       */ 

	     return "Debug Level is " + debugLevel;
    }
}
