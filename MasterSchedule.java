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
		myCourses = courseCreator();
	}


	public MasterSchedule(File a){
		myCSV = a;
		try{
		scan = new Scanner(myCSV);
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		myLines = organizeCSV();
		myCourses = courseCreator();
	}

	//This method simply breaks the .csv into its lines and splits those lines at commas
	private ArrayList<String[]> organizeCSV(){
		ArrayList<String[]> lines = new ArrayList<String[]>();
		while(scan.hasNextLine()){
			lines.add(scan.nextLine().split(",",13));
		}
		return lines;
	}

	//This method creates the arraylist of course objects by grouping all the lines with the same 
	//course name into an ArrayList<String[]> and passing that to the Course constructor
	private ArrayList<Course> courseCreator(){
		ArrayList<String[]> oneCourse = new ArrayList<String[]>();
		ArrayList<Course> courses = new ArrayList<Course>();
		String currentName = "placeholder";
		int currentNumber = 0;

		//The first iteration of this loop will simply set the initial values for currentName and 
		//currentNumber. After the first iteration, everytime the loop reaches a new course it
		//will bundle all of the components of the previous course and use them to create a course
		//object. Then it will set the currentName and currentNumber variables to the new course
		//and begin bundling again.
		for(int i=0; i<myLines.size(); i++){
			if(!myLines.get(i)[0].equals(currentName)){
				for(int j=currentNumber; j<i; j++){
					oneCourse.add(myLines.get(j));
				}
				courses.add(new Course(oneCourse));
				oneCourse.clear();
				currentName = myLines.get(i)[0];
				currentNumber = i;
			}
		}
		return courses;
	}
}
