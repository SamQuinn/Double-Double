
/**
*@Author ErikSearle
*@Version February-27-2016
*/
import java.io.*;
import java.util.*;
import java.lang.*;
public class MasterSchedule{
	File myCSV;
	ArrayList<Course> myCourses;
	ArrayList<String[]> myLines;
	Scanner scan;
	ArrayList<Prof> myProfs;
	ArrayList<Room> myRooms;
	ArrayList<Meeting> myMeetings;
	
	
	//there are two constructors for MasterSchedule which work identically and just depend
	//on whether the .csv file is passed or just the filepath
	public MasterSchedule(String a){
		myCSV = new File(a);
		try{
			scan = new Scanner(myCSV);
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		myLines = organizeCSV();
		myMeetings = new ArrayList<Meeting>();
		myCourses = courseCreator();
		myProfs = profCreator();
		myRooms = roomCreator();
	}
	
	
	public MasterSchedule(File a){
		myCSV = a;
		try{
			scan = new Scanner(myCSV);
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		myLines = organizeCSV();
		myMeetings = new ArrayList<Meeting>();
		myCourses = courseCreator();
		myProfs = profCreator();
		myRooms = roomCreator();

	}
	
	
//	This method simply breaks the .csv into its lines and splits those lines at commas
	private ArrayList<String[]> organizeCSV(){
		ArrayList<String[]> lines = new ArrayList<String[]>();
		while(scan.hasNextLine()){
			lines.add(scan.nextLine().split(",",13));
		}
		return lines;
	}
	
	
//	This method creates the arraylist of course objects by grouping all the lines with the same
//	course name into an ArrayList<String[]> and passing that to the Course constructor
	private ArrayList<Course> courseCreator(){
		ArrayList<Meeting> oneCourse = new ArrayList<Meeting>();
		ArrayList<Course> courses = new ArrayList<Course>();
		String currentName = myLines.get(4)[0];
		int currentNumber = 4;
		
		
//	The first iteration of this loop will simply set the initial values for currentName and
//	currentNumber. After the first iteration, every time the loop reaches a new course it
//	will bundle all of the components of the previous course and use them to create a course
//	object. Then it will set the currentName and currentNumber variables to the new course
//	and begin bundling again.
		for(int i=4; i<myLines.size(); i++){
			if(!myLines.get(i)[0].equals(currentName)){
				for(int j=currentNumber; j<i; j++){
					oneCourse.add(new Meeting(myLines.get(j)));
					myMeetings.add(new Meeting(myLines.get(j)));
				}
				courses.add(new Course(oneCourse));
				oneCourse.clear();
				currentName = myLines.get(i)[0];
				currentNumber = i;
			}
		}
		return courses;
	}

	private ArrayList<Prof> profCreator(){
		ArrayList<Prof> profs = new ArrayList<Prof>();
		ArrayList<Meeting> oneProf = new ArrayList<Meeting>();
		String currentProf = "";

		for(int i=0; i<myMeetings.size(); i++){
			if(!myMeetings.get(i).getProfessor().equals("")){
				if(!Character.isUpperCase(myMeetings.get(i).getProfessor().charAt(1))){
					if(profs.size()==0){
						currentProf = myMeetings.get(i).getProfessor();
						for(int j=i; j<myMeetings.size(); j++){
							if(myMeetings.get(j).getProfessor().equals(currentProf)) oneProf.add(myMeetings.get(j));
						}
						profs.add(new Prof(oneProf, currentProf));
					}
					for(int h=0; h<profs.size(); h++){
						if(myMeetings.get(i).getProfessor().equals(profs.get(h).getName())) break;
						else if(h==profs.size()-1){
							currentProf = myMeetings.get(i).getProfessor();
							for(int j=i; j<myMeetings.size(); j++){
								if(myMeetings.get(j).getProfessor().equals(currentProf)) oneProf.add(myMeetings.get(j));
							}
							profs.add(new Prof(oneProf, currentProf));
						}							
					}
				}
			}
		}
//		Collections.sort(profs);
		return profs;
	}

	private ArrayList<Room> roomCreator(){
		ArrayList<Room> rooms = new ArrayList<Room>();
		ArrayList<Meeting> oneRoom = new ArrayList<Meeting>();
		String currentRoom = "";

		for(int i=0; i<myMeetings.size(); i++){
			if(!myMeetings.get(i).getRoomNumber().equals("")){
				if(rooms.size()==0){
						currentRoom = myMeetings.get(i).getRoomNumber();
						for(int j=i; j<myMeetings.size(); j++){
							if(myMeetings.get(j).getRoomNumber().equals(currentRoom)) oneRoom.add(myMeetings.get(j));
						}
						rooms.add(new Room(oneRoom, currentRoom));
				}
				for(int h=0; h<rooms.size(); h++){
					if(myMeetings.get(i).getRoomNumber().equals(rooms.get(h).getRoomNumber())) break;
					else if(h==rooms.size()-1){
						currentRoom = myMeetings.get(i).getRoomNumber();
						for(int j=i; j<myMeetings.size(); j++){
							if(myMeetings.get(j).getRoomNumber().equals(currentRoom)) oneRoom.add(myMeetings.get(j));
						}
						rooms.add(new Room(oneRoom, currentRoom));
					}							
				}
			}
		}
//		Collections.sort(rooms);
		return rooms;
	}

	public String[] getAllCourseNames(){
		String[] names = new String[myCourses.size()];
		for(int i=0; i<myCourses.size(); i++){
			names[i] = myCourses.get(i).toString();
		}
		return names;
	}
	
	public Object[] getCourses(){
		return myCourses.toArray();
	}

	public Object[] getProfs(){
		return myProfs.toArray();
	}

	public Object[] getRooms(){
		return myRooms.toArray();
	}
}
