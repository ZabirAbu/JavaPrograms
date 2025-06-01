

import java.util.Objects;

public class Swim extends Activity { //Swim class inherits the attributes from Activity class 
	//attributes of Swim class
	private int poolSize;
	private int numLengths;
	
	//constructor of Swim class
	public Swim(int pSize, int lCount, int time) throws InvalidActivityException {  
		super(time); //super keyword used to call superclass method (from Activity class) and access the superclass constructor
		
		if (time<=0) { //exception thrown if time is less than or equal to 0
			throw new InvalidActivityException("Recorded time must be greater than 0s");
			}
		
		if (pSize<=0 || pSize>100) { //exception thrown if pool size is less than or equal to 0 OR if pool size is greater than 100 
			throw new InvalidActivityException("Pool size must be between 1m and 100m");
			}
		
		if (lCount<=0 || lCount>1000) { //exception thrown if lCount is less than or equal to 0 OR if pool size is greater than 1000 
			throw new InvalidActivityException("Number of lengths must be between 1 and 1000");
			} 
		
		if ((pSize*lCount)/(float)time>4) { //exception thrown if average speed is greater than 4  
			throw new InvalidActivityException("Recorded time and distance is not possible");
			}
		
		this.poolSize = pSize;
		this.numLengths = lCount;
		this.effort = (20.0*(poolSize*numLengths))/(float)time;
		}
	
	public int getPoolSize() {
		return poolSize;
		}
	
	public int getLengths() {
		return numLengths;
		}
	
	public int getDistance() {
		int size = numLengths*poolSize;
		return size;
		}
	
	public String toString() {
		if (getID() < 10) { //toString method pads 0 in front of the Swim number until getID() is equal to 9
			return String.format("S0%d: effort score %.1f (%d x %dm in %.1fminutes)", getID(), effort, numLengths, poolSize, time/60.0);
			}
		
		else //toString method removes the padded 0 from getID() being 10 or more
			return String.format("S%d: effort score %.1f (%d x %dm in %.1fminutes)", getID(), effort, numLengths, poolSize, time/60.0);
		}

	//hashCode method compares 2 objects faster than the equals method
	public int hashCode() {
		return Objects.hash(numLengths, poolSize, time);
		}
	
	//equals method checks if 2 objects are the same and compares the value of the objects' attributes
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof Swim))
			return false;
		Swim other = (Swim) obj;
		return numLengths == other.numLengths && poolSize == other.poolSize && time == other.time;
		}
	}
