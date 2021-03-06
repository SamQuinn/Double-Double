import java.util.ArrayList;

public class Room implements Comparable<Room>{

	private ArrayList<Meeting> myMeetings;
	private String myRoomNumber;
	
	public Room(ArrayList<Meeting> a, String b){
		myMeetings = new ArrayList<Meeting>(a);
		myRoomNumber = b;
	}

	public String getRoomNumber(){
		return myRoomNumber;
	}

	public ArrayList<Meeting> getMeetings(){
		return myMeetings;
	}

	public String toString(){
		return myRoomNumber;
	}

	public int compareTo(Room other){
		return this.getRoomNumber().compareTo(other.getRoomNumber());
		}

}
