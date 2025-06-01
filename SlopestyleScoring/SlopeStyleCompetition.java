import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SlopeStyleCompetition {
	
	private static float[] readScores(Scanner sc) {
		float[] scores = new float[7];
		for (int j=0; j<7; ++j) {
			scores[j] = sc.nextFloat();
		}
		return scores;
	}
	
	private static Skier[] setupSkiers(final String fname) {
	  Skier[] theSkiers = null;
		try {
			final List<String> resultLines = Files.readAllLines(Paths.get(fname));
			final int numEntrants = resultLines.size();
			theSkiers = new Skier[numEntrants];
			
			for (int i=0; i<numEntrants; ++i) {
				try (Scanner eLine = new Scanner(resultLines.get(i))) {
					final String name = eLine.next();
					
					SingleRunResult run1 = new SingleRunResult(1, readScores(eLine));
					SingleRunResult run2 = new SingleRunResult(2, readScores(eLine));
					theSkiers[i] = new Skier(name, run1, run2);
				}
			}
		} catch (final IOException e) {
		      System.err.println("Failed reading file of player scores: " + fname);
	    }
		return theSkiers;
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage java SnowStyleResults <resultsFile>");
			System.exit(1);
		}
		
		final String resultsFile = args[0]; 
		final Skier[] theSkiers = setupSkiers(resultsFile);
		final ScoreBoard sb = new ScoreBoard(theSkiers);
		
		System.out.println(sb);
		System.out.printf("The winner is %s (%3.1f)%n", 
		    sb.getWinner().getName(), sb.getWinner().getResult());
	}

}