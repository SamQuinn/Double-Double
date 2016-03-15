3import java.util.ArrayList;


public class Course {
	private ArrayList<Meeting> meetings;
	
	public Course(ArrayList<Meeting> m){
		meetings = new ArrayList<Meeting>(m);
		
	}
	
	public String getCourseID(){
		return meetings.get(0).getCourseID();
	}

	public ArrayList<Meeting> getMeetings(){return meetings; }
	
	//Creates an ArrayList of block objects for every meeting in the course to be passed to the GUI.
	public ArrayList<Block> getBlocks(){
		ArrayList<Block> temp = new ArrayList<Block>();
		for(int i=0; i<meetings.size(); i++){
			int numberOfBlocks = getNumberOfBlocks(meetings.get(i).getDuration());
			String startTime = meetings.get(i).getStartTime();
			for(int j=0; j<numberOfBlocks; j++){
				
				// adds a block at the start time
				temp.add(new Block(startTime, meetings.get(i).getDayOfWeek()));
				
				//moves the startTime variable forward by half an hour to get ready to make the next block on the next loop
				String[] time = startTime.split(":",2);
				int[] times = {Integer.parseInt(time[0]),Integer.parseInt(time[1])};
				if(times[1]==30){
					times[0]++;
					times[1]=00;
				}
				else{
					times[1]=30;
				}
				startTime = (times[0] + ":" + times[1]);
			}
		}
		return temp;
	}
	
	public ArrayList<Block> getLectureBlocks(){
		ArrayList<Block> temp = new ArrayList<Block>();
		for(int i=0; i<meetings.size(); i++){
			if(meetings.get(i).getComponentID().charAt(0) == 'A'){
				int numberOfBlocks = getNumberOfBlocks(meetings.get(i).getDuration());
				String startTime = meetings.get(i).getStartTime();
				for(int j=0; j<numberOfBlocks; j++){
				
					// adds a block at the start time
					temp.add(new Block(startTime, meetings.get(i).getDayOfWeek()));
				
					//moves the startTime variable forward by half an hour to get ready to make the next block on the next loop
					String[] time = startTime.split(":",2);
					int[] times = {Integer.parseInt(time[0]),Integer.parseInt(time[1])};
					if(times[1]==30){
						times[0]++;
						times[1]=00;
					}
					else{
						times[1]=30;
					}
					startTime = (times[0] + ":" + times[1]);
				}
			}
		}
		return temp;
	}
	
	public ArrayList<Block> getLabBlocks(){
		ArrayList<Block> temp = new ArrayList<Block>();
		for(int i=0; i<meetings.size(); i++){
			if(meetings.get(i).getComponentID().charAt(0) == 'L'){
				int numberOfBlocks = getNumberOfBlocks(meetings.get(i).getDuration());
				String startTime = meetings.get(i).getStartTime();
				for(int j=0; j<numberOfBlocks; j++){
				
					// adds a block at the start time
					temp.add(new Block(startTime, meetings.get(i).getDayOfWeek()));
				
					//moves the startTime variable forward by half an hour to get ready to make the next block on the next loop
					String[] time = startTime.split(":",2);
					int[] times = {Integer.parseInt(time[0]),Integer.parseInt(time[1])};
					if(times[1]==30){
						times[0]++;
						times[1]=00;
					}
					else{
						times[1]=30;
					}
					startTime = (times[0] + ":" + times[1]);
				}
			}
		}
		return temp;
	}
	
	public ArrayList<Block> getTutorialBlocks(){
		ArrayList<Block> temp = new ArrayList<Block>();
		for(int i=0; i<meetings.size(); i++){
			if(meetings.get(i).getComponentID().charAt(0) == 'T'){
				int numberOfBlocks = getNumberOfBlocks(meetings.get(i).getDuration());
				String startTime = meetings.get(i).getStartTime();
				for(int j=0; j<numberOfBlocks; j++){
				
					// adds a block at the start time
					temp.add(new Block(startTime, meetings.get(i).getDayOfWeek()));
				
					//moves the startTime variable forward by half an hour to get ready to make the next block on the next loop
					String[] time = startTime.split(":",2);
					int[] times = {Integer.parseInt(time[0]),Integer.parseInt(time[1])};
					if(times[1]==30){
						times[0]++;
						times[1]=00;
					}
					else{
						times[1]=30;
					}
					startTime = (times[0] + ":" + times[1]);
				}
			}
		}
		return temp;
	}
	
	public String toString(){
		return (meetings.get(0).getCourseID() + " " + meetings.get(0).getComponentID());
	}
	
	private static int getNumberOfBlocks(String a){
		String[] time = a.split(":",2);
		int number = Integer.parseInt(time[0])*2;
		if(time[1].equals("30")) number++;
		return number;
	}
}
