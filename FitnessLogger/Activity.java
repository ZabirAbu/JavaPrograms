public abstract class Activity implements Comparable<Activity> { //Activity implements the Comparable interface
	//attributes of Activity class
	private static int activityCounter = 0;
	protected final int activityID;
	protected final int time;
	protected double effort;
	
	//constructor of Activity class
	
	public Activity(int t) { 
		activityID=++activityCounter; //activityID is the same as activityCounter whenever incremented
		time = t;
		}

	public int getID() {
		return activityID;
		}
	    
	public double getEffort() { //method created which returns effort and will have separate ways of calculating effort in Run and Swim classes 
		return effort;
		}
		
	public int getTime() { //getTime() method returns time which is an attribute of type integer
		return time;
		}
	

	abstract public int hashCode(); //abstract method created which is then implemented concretely in Run and Swim classes

	abstract public boolean equals(Object other); //abstract method created which is then implemented concretely in Run and Swim classes
	
	abstract public String toString(); //abstract method created which is then implemented concretely in Run and Swim classes
	
	
	public int compareTo(Activity act) {//compareTo() is a concrete method which compares 2 objects
		if (this.effort > act.effort) {
			return 1; //method returns 1 if the first object is greater than the other object
		} else if (this.effort == act.effort) {
			return 0; //method returns 0 if objects are the same
		} else {
			return -1; //method return -1 if the first object is less than the other object
		}
	}	
}
