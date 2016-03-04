
import java.util.*;
/**
 * @author Sam Kelly
 *March 4/2016 V1.0
 */
public class CourseComponent {
	private String componentName;
	private ArrayList<Meeting> allMeetings;
	public static int meetings = 0;
	
	
	public void CourseComponent(ArrayList<String[]> section){
		this.componentName = section.get(0)[1];
		
		for(int i = 0; i < section.size(); i ++){
			this.allMeetings.add(new Meeting(section.get.(i)));
			meetings += 1;
		}
	}
	
	public void setName(String name){
		this.componentName = name;
	}
	public String getName(){
		return this.componentName;
	}
	
	public ArrayList<Meeting> getMeetings(){
		return this.allMeetings;
	}
	
	public void addMeeting(Meeting newM){
		this.allMeetings.add(newM);
		meetings += 1;
	}
	
	public void removeMeeting(Meeting oldM){
		if(this.allMeetings.contains(oldM)){
			this.allMeetings.remove(oldM);
			meetings -= 1;
		} else {
			System.out.println("This course component does not contain the meeting specified.");
		}
		
	}
}
