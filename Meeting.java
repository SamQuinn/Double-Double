import java.util.*;

import jdk.nashorn.internal.ir.Block;

public class Meeting {
	
	private String professor;
	private String room;
	private String meetingTime;
	private ArrayList<Block> blocks;
	
	
	
	public Meeting(ArrayList<Meeting> allMeetings){
		
		for(int i = 0; i < section.size(); i ++){
			blocks.add(new Block(allMeetings.get(i)));
		}
		
	}
	
	public void setProfessor(Professor p){
		professor = p.getProfessorName();
	}
	
	public String getProfessor(){
		return professor;
	}
	
	public void setRoom(Room r){
		room = r.getFullRoomNum();
	}
	
	public String getRoom(){
		return room;
	}
	
	public void setMeetingTime(MeetingTime mt){
		meetingTime = mt.toString();
	}
	
	public String getMeetingTime(){
		return meetingTime;
	}
	
	public void addBlock(Block b){
		blocks.add(b);
	}
	
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	public String toString(){
		for (int i =0;i<blocks.size();i++){
			return professor + room + meetingTime + new Block.toString(blocks.get(i));
		}
	}

}

