
import java.util.*;
/**
 * 
 */

/**
 * @author Sam Kelly (Updated by Erik Searle)(Updated by Sam Kelly)
 * Version Mar 4/2016 V1.0
 */
public class Course {
	//defines new and unique course names for each individual course object
	private String courseName;
	
	//used to count the number of courseComponent objects created in a Course 
	private int components = 0;
	
	//stores all components of a course in an array list
	private ArrayList<CourseComponent> courseSections = new ArrayList<CourseComponent>();
	
	//zero argument constructor, so that the expected behavior 
	//is known when a Course object is created without a specified argument
	public Course(){
		courseName = "";
	}
	
	//Course object constructor, takes in an array of Strings containing
	//all the lines of data for a single course (used to define/create courseComponents, etc)
	public Course(ArrayList<String[]> sections){
		setName(sections.get(0)[0]);
		
		/* Calls the method to create the CourseComponent objects that will
		 * be part of the Course object
		 */
		divideSections(sections);
	}
	
	//divides Course into sections and creates CourseComponents
	public void divideSections(ArrayList<String[]> s){
		//Creates an array to store the working data for creating a CourseComponent
		ArrayList<String[]> workingComponentList = new ArrayList<String[]>();
		
		//ID and compare are used to determine if lines are part of the same CourseComponent
		//Ex: if they are both equal to A1, they are both part of the lecture 1 CourseComponent
		String ID;
		String compare;
		
		//initializes ID as the first component identity for comparison
		ID = s.get(0)[1];
		
		//loops through every "line" (String[]) of course meeting data
		for(int i = 0; i < s.size(); i++){
			//checks if the current "line" is part of the same CourseComponent
			//example: "A1" == "A1", or "A1" != "L2"
			compare = s.get(i)[1];
			if(compare.equals(ID)){
				//if the line is part of the current CourseComponent set, the line
				//is added to the working set of data that will be used to eventually
				//create the CourseComponent
				workingComponentList.add(s.get(i));
			} else {
				//if the line is not part of the current CourseComponent, the data
				//for the current component is considered complete, and the working set array
				//will be used to create a new CourseComponent, which will be immediately added
				//to the Course object's ArrayList of CourseComponents
				 this.courseSections.addComponent(new CourseComponent(workingComponentList));
				 //changes the current CourseComponent identity for comparison
				ID = s.get(i)[1];
				//continues the for loop right back at the line that was just checked, so that
				//no lines are skipped
				i -= 1;
				
				workingComponentList.clear();
				//empties the array list of all its components, so that it wont add the same components on the next loop through
			}
		}
	}
	
	//getter and setter methods for the course name
	//the setName method is used to initially set the value
	//of courseName, and takes in the first line of 
	//the array of lines sent to the course to find the name
	//of the course that the lines belong to
	public void setName(String line){
		String name = line;
	}
	
	public String getName(){
		return this.courseName;
	}
	
	//getter and setter methods for the List<> of course components in a course object
	public int numberOfComponents(){
		return this.components;
	}
	
	public List<CourseComponent> getAllComponents(){
		return this.courseSections;
	}
	
	public void removeComponent(CourseComponent c){
		this.courseSections.remove(c);
		components -= 1;
	}
	
	public void addComponent(CourseComponent c){
		this.courseSections.add(c);
		components += 1;
	}
	
	//toString() method for a course object
	public String toString(){
		String course = "";
		course += this.courseName;
		if(this.components > 0){
			course += " Has " + this.components + " sections.";
			course += "They are: " + "\n";
			//To print the sections, there needs to be a specific toString() method
			//in the CourseComponent class
			for(int i = 0; i < this.courseSections.length; i++){
				new CourseComponent.toString(this.courseSections.get(i));
			}
		}
	}
}
