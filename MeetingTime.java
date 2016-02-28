/**
 * 
 * @author Ray
 * @version 1.0
 */

import java.text.DecimalFormat;

public class MeetingTime {
	
	private int StartTimeHour;
	private int StartTimeMinute;

	private int DurationHour;
	private int DurationMinute;
	
	private String DayOfWeek = "";
	
	DecimalFormat twodigits = new DecimalFormat("00");
	
	public MeetingTime(String day, int sh, int sm,int dh, int dm){
		
		StartTimeHour = sh;
		StartTimeMinute = sm;
		DurationHour = dh;
		DurationMinute = dm;
		DayOfWeek = day;
			
	}
	
	public String getStartTime(){
		
		return twodigits.format(StartTimeHour) + ":" + twodigits.format(StartTimeMinute);
		
	}
	
	public String getEndTime(){
		
		if((StartTimeMinute+DurationMinute)>=60){
			
			return twodigits.format(StartTimeHour + DurationHour + 1) + ":" + twodigits.format(StartTimeMinute + DurationMinute - 60);	
			
		}
		
		return twodigits.format(StartTimeHour + DurationHour) + ":" + twodigits.format(StartTimeMinute + DurationMinute);
		
	}
	
	public String getDayOfWeek(){
		
		return DayOfWeek;
		
	}
	
	public int getDuration(){
		
		return DurationHour * 60 + DurationMinute;
		
	}
	
	
	public String toString(){
		
		return this.getDayOfWeek() + " from " + this.getStartTime() + " to " + this.getEndTime();
		
	}
		
}
	

