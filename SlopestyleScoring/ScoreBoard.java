/*public class ScoreBoard {
	private Skier[] skiers;

	public ScoreBoard(Skier[] theSkiers) {
		
	}

	
	public String toString() {
		return null;
	}

	public Skier getWinner() {
		
		return null;
	}

} */
// http://java82.blogspot.com/2016/07/java-program-to-print-golf-scoreboard.html

public class ScoreBoard {
	private Skier[] skiers;
	private float[] scores;
	private int total[];
	public ScoreBoard(Skier[] theSkiers) {
		
	}

	
	public String toString() {
		return null;
	}

	public Skier getWinner() {
		{int min=total[1];
        int Winner=1;
        for (int i = 1; i < total.length; i++) {
            if (min > total[i])
            {
                min = total[i];
                Winner=i;
            }
            
        }
        return Skier;
	}

}
