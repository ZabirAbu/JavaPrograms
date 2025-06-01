

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CW2Phase1 {
	
	/**
	 * Helper method to create a new Activity based on the provided stats. 
	 * @param stats an array of stats to be interpreted as a new Activity
	 * @return  return null if the supplied stats cannot make an Activity; create a Run if there are 2 numbers; create a Swim if there are 3 numbers
	 */
	private static Activity makeActivity(String[] stats) 
			throws InvalidActivityException  // un-comment this line once phase 3 is complete 
	{
		final Activity act;
		int time;
		switch (stats.length) {
		case 2:
			int dist = Integer.parseInt(stats[0]);
			time = Integer.parseInt(stats[1]);
			act = new Run(dist,time);
			break;
		case 3:
			int pSize  = Integer.parseInt(stats[0]);
			int lCount = Integer.parseInt(stats[1]);
			time   = Integer.parseInt(stats[2]);
			act = new Swim(pSize,lCount,time);
			break;
		default:
			act = null;	
		}
		return act;
	}
	
	/**
	 * Test program to read in and process some activity stats data
	 * @param args supply the filename of some activity data
	 */
	public static void main(String[] args) 
		throws InvalidActivityException  
	{
		if (args.length != 1) {
			System.err.println("Usage: java CW2Phase1 <statsfile>");
			System.exit(1);
		}
		
		final String statsFile = args[0];
		double totalEffort = 0.0;
		int totalTime = 0;
		
		// Read in the stats 
		try (Scanner sc = new Scanner(new File(statsFile))) {
			while (sc.hasNext()) {
				final String[] nextStats = sc.nextLine().split("\\s");
				Activity act = makeActivity(nextStats);
				if (act != null) {
					System.out.println(act);
					totalEffort += act.getEffort();
					totalTime   += act.getTime();
				}
			}
			System.out.println();
			System.out.printf("Total effort was: %8.1f%n", totalEffort);
		    System.out.printf("Total time:       %2d:%2d:%2d%n",
                    totalTime/3600, totalTime%3600/60, totalTime%3600%60);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}

	}

}