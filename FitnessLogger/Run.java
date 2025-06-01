import java.util.Objects;

public class Run extends Activity { //Run class inherits the attributes from Activity class 
	//attribute of Run class
	private int distance;
	
	//constructor of Run class
	public Run(int dist, int time) throws InvalidActivityException {
		super(time); //super keyword used to call superclass method(from Activity class) and access the superclass constructor
		
		if (time<=0) { //exception thrown if time is less than or equal to 0
			throw new InvalidActivityException("Recorded time must be greater than 0s");
			}
		
		if (dist<=0 || dist>100000) { //exception thrown if distance is less than or equal to 0 OR if distance is greater than 100000
			throw new InvalidActivityException("Distance must be between 0m and 100000m");
			}
		
		if (dist/time>20) { //exception thrown where the average speed is over 20m/s
			throw new InvalidActivityException("Recorded time and distance are not plausible");
			}
		
		this.distance = dist;
		this.effort = (4*dist)/(float)time;
		}
	

	public int getDistance() {
		return distance;
		}
	
	public String toString() {
		if (getID() < 10) { //toString method pads 0s in front of the Run number when getID is between 1 and 9
			return String.format("R0%d: effort score %.1f (%.1f km in %.1fminutes)", getID(), effort, getDistance()/1000.0, time/60.0);
			}
		else //toString method for getID that is 10 or more
			return String.format("R%d: effort score %.1f (%.1f km in %.1fminutes)", getID(), effort, getDistance()/1000.0, time/60.0);
		}
	
	//hashCode method compares 2 objects based on the distance and time. Also it's faster than the equals method 
	public int hashCode() {
		return Objects.hash(distance, time);
		}

	//equals method checks if 2 objects are the same and compares the value of the objects' attributes
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Run))
			return false;
		Run other = (Run) obj;
		return distance == other.distance && time == other.time;
		}
	}
