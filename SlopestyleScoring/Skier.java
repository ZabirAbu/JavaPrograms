public class Skier {
	private String name;
	private SingleRunResult run1;
	private SingleRunResult run2;


	public Skier(String n, SingleRunResult r1, SingleRunResult r2) {
		name = n;
		run1 = r1;
		run2 = r2;
	}
	
	public String getName() {
		String person = name;
		return person;
	}
		

	public String toString() {
		String result = String.format(" \r%s : %.2f \r", getName(), getResult());
		if (getResult() == run1.getResult()) {
			result += String.format(" %s \r%s%s%5s \r", run1, "[", run2, "]");
		} else {
			result += String.format("%s%s%5s \r %s \r", "[", run1, "]", run2);
		}
		return result;
	}


	public float getResult() {
		float firstRun = run1.getResult();
		float secondRun = run2.getResult();
		if (secondRun > firstRun) {
			return secondRun;
			
		} else {
			return firstRun;
		}
	}
		
}
	

		
/*String result = String.format("%5s:", runNumber);
for(int i=0; i<scores.length; i++) {
	if (scores[i] == maxNumber() || scores[i] == minNumber()) {
		result += String.format(" (%.1f)", scores[i]);
	}else {
		result += String.format("%7.1f", scores[i]);
	}
	
}
result += String.format("  ==%7.2f", scores[i]);
return result;
}*/



