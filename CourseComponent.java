/**
 * 
 */
package version1;
import java.util.*;
/**
 * @author Sam Kelly
 *Mar 4/2016 V1.1
 */
public class CourseComponent {
	private String componentName;
	private ArrayList<Meeting> allMeetings;
	private int meetings = 0;
	
	
	public CourseComponent(ArrayList<String[]> section){
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
	
	public String toString(){
		String course = "";
		course += this.componentName;
		if(meetings > 0){
			course += " Has " + this.meetings + " meetings.";
			course += "They are: " + "\n";

			for(int i = 0; i < this.allMeetings.size(); i++){
				new Meeting.toString(this.allMeetings.get(i));
			}
		}
	}
}
