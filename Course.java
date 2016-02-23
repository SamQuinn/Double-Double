
import java.util.List;
import java.util.LinkedList;
/**
 * 
 */

/**
 * @author Sam Kelly
 * Version Feb 21/2016 1.0
 */
public class Course {
	//defines new and unique course names for each individual course object
	private String courseName;
	
	//used to count the number of courseComponent objects created in a Course 
	private int components = 0;
	
	//stores all components of a course in a linked list
	private List<CourseComponent> courseSections = new LinkedList<CourseComponent>();
	
	//zero argument constructor, so that the expected behavior 
	//is known when a Course object is created without a specified argument
	public Course(){
		courseName = "";
	}
	
	//Course object constructor, takes in an array of Strings containing
	//all the lines of data for a single course (used to define/create courseComponents, etc)
	public Course(String[] sections){
		setName(sections[0]);
		
		//creates a course component for every line in the course sections data,
		//and adds the course component object to the linked list of 
		//components for the course
		for (int i = 0; i < sections.length; i++) {
			courseSections.add(CourseComponent(sections[i]));
			components += 1;
		}
	}
	
	//getter and setter methods for the course name
	//the setName method is used to initially set the value
	//of courseName, and takes in the first line of 
	//the array of lines sent to the course to find the name
	//of the course that the lines belong to
	public void setName(String line){
		String name = "";
		for(int i = 0; i < 7; i++){
			name += line.charAt(i);
		}
		this.courseName = name;
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
	}
	
	public void addComponent(CourseComponent c){
		this.courseSections.add(c);
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
