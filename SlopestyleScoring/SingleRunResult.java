public class SingleRunResult {
	private int runNumber;
	private float[] scores;

	public SingleRunResult(int i, float[] readScores) {
		runNumber = i;
		scores = readScores;
	}
	//loop through array scores
	
	//find the highest score
	private float maxNumber() {
		float max = scores[0];
		for(int i=1 ; i < scores.length; i++) {
			if (max < scores[i]) {
				max= scores[i];
			}
		}
		return max;
		
	}
	//find the lowest score
	private float minNumber() {
		float minimum = scores[0];
		for(int i=1 ; i < scores.length; i++) {
			if (minimum > scores[i]) {
				minimum = scores[i];
				
			}
		}
		return minimum;
	}
	
	public float getResult() {
		float adder = (float) 0.0;
		for(int i=0; i<scores.length; i++) {
			if (scores[i] != maxNumber() && scores[i] != minNumber()) {
				
			} else {
				adder += scores[i];
			}
			
		} 
		
		return adder/(scores.length-2);
	}
	
	public String toString() 
	{
		boolean var1 = false;
		boolean var2 = false;
		String result = String.format("%7s:", runNumber);
		for(int i=0 ; i < scores.length; i++) {
			if (((scores[i] == maxNumber())&& (var1 == false)) ||  ((scores[i] == minNumber())&& (var2 == false)) ) {
				if (scores[i] == maxNumber()){
					
					var1 = true; }
				if (scores[i] == minNumber()) {
					var2 = true;
				
				}
				result += String.format(" (%.1f)",scores[i]);
			} else {
				result += String.format(" %7.1f ", scores[i]); //floating point format specifier
			}
		}
		return result; 
				
		
	}
	
	
	}
