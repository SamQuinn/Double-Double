
import java.util.*;

public class Meeting {
	
	private String professor;
	private String roomNum;
	private String buildingId;
	private String startTime;
	private String duration;
	private String day;
	private String startDate;
	private String endDate;
	private String courseId;
	private String componentId;
	boolean checkForced = false;
	
	
	
	public Meeting(String[] sa){
		
		if(sa[4].equals("")){
			courseId = sa[0];
			componentId = sa[1];
			startDate = sa[2];
			endDate = sa[3];
			day = sa[7];
			startTime = sa[8];
			duration = sa[9];
			buildingId = sa[10];
			roomNum = sa[11];
			professor = sa[12];
		}
		else{
			courseId = sa[0];
			componentId = sa[1];
			startDate = sa[2];
			endDate = sa[3];
			day = sa[4];
			startTime = sa[5];
			duration = sa[6];
			buildingId = sa[10];
			roomNum = sa[11];
			professor = sa[12];
			
			checkForced = true;
			
		}
		
	}
	
	public String getCourseId(){
		return courseId;
	}
	public String getComponentId(){
		return componentId;
	}
	public String getStartDate(){
		return startDate;
	}
	public String getEndDate(){
		return endDate;
	}
	public String getDayOfWeek(){
		return day;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getDuration(){
		return duration;
	}
	public String getBuildingId(){
		return buildingId;
	}
	public String getRoomNumber(){
		return roomNum;
	}
	public String getProfessor(){
		return professor;
	}
	public boolean checkForced(){
		return checkForced;
	}
	
}
