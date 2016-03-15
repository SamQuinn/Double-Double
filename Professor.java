import java.util.ArrayList;


public class Prof implements Comparable<Prof>{
	
	private ArrayList<Meeting> myMeetings;
	private String myName;

	public Prof(ArrayList<Meeting> a, String b){
		myMeetings = new ArrayList<Meeting>(a);
		myName = b;
	}

	public String getName(){
		return myName;
	}

	public ArrayList<Meeting> getMeetings(){
		return myMeetings;
	}

	public String toString(){
		return myName;
	}
	
	public int compareTo(Prof other){
		 return this.getName().compareTo(other.getName());	
	}
}
