
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CW2Phase2 {

	
	/**
	 * Helper method to create a new Activity based on the provided stats. 
	 * @param stats an array of stats to be interpreted as a new Activity
	 * @return  return null if the supplied stats cannot make an Activity; create a Run if there are 2 stats; create a Swim if there are 3 stats
	 * @throws InvalidActivityException 
	 */
	private static Activity makeActivity(String[] stats) throws InvalidActivityException 
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
	   * Helper method to print out the contents of a Set&lt;Activity&gt; in a uniform way
	   *  
	   * @param acts A Set of Activity objects
	   * @param desc Text description of the set
	   */
	  static void displayActivities (final Set<Activity> acts, final String desc) {
	    double totalEffort = 0.0;
	    int totalTime = 0;
	    System.out.println();
	    System.out.printf("%s Activities:%n",desc);
	    for (Activity act : acts) {
	      System.out.printf("%s%n",
	                        act);
	      totalEffort += act.getEffort();
	      totalTime += act.getTime();
	    }

	    // System.out.printf("%nLast activity is %s%n",
	    //                   acts.last());
	    // System.out.printf("First activity is %s%n",
	    //                   acts.first());
	    System.out.printf("Total effort:             %8.2f%n",
	                      totalEffort);
	    System.out.printf("Total time:                %d:%d:%d%n",
	                      totalTime/3600, totalTime%3600/60, totalTime%3600%60);
	    System.out.printf("Count of different activities: %3d%n",
	                      acts.size());

	  }
	  
	/**
	 * Test program to read in and process some activity stats data
	 * @param args supply the filename of some activity data
	 * @throws InvalidActivityException 
	 */
	public static void main(String[] args) throws InvalidActivityException 
			  
	{
		if (args.length != 1) {
			System.err.println("Usage: java CW2Phase2 <statsfile>");
			System.exit(1);
		}
		
		final String statsFile = args[0];

		final SortedSet<Activity> acts1 = new TreeSet<>();
	    final Set<Activity> acts2 = new HashSet<>();
		// Read in the stats 
		try (Scanner sc = new Scanner(new File(statsFile))) {
			while (sc.hasNext()) {
				final String[] nextStats = sc.nextLine().split("\\s");
				Activity act = makeActivity(nextStats);
				if (act != null) {
					if (! acts1.add(act))
						System.out.printf("[SortedSet] Duplicate activity - not added: %s%n",
								act);
				    else
				    	System.out.printf("[SortedSet] Added: %s%n",
				    			act);
				    if (! acts2.add(act))
				    	System.out.printf("[HashSet  ] Duplicate activity - not added: %s%n",
				    			act);
				    else
				    	System.out.printf("[HashSet  ] Added: %s%n",
				    			act);
				}
			}
		    displayActivities(acts1, "SortedSet");
		    displayActivities(acts2, "HashSet");

		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}

	}

}