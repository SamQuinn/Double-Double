/**
*
*Professor class for Final Project
*
*@author Scott Howes
*@version 22/02/2016
*
*/



public class Professor
{

	//class variable(s)
	private String name = "";


	//contructor which only takes a name
	public Professor(String name)
	{
		this.name = name;
	}


	//gets the Professor's name
	public String getProfessorName()
	{
		return name;
	}


	//return a Professor object
	//not totally sure if this method is needed but adding it can't hurt ;)
	public Professor getProfessor()
	{
		return this;
	}


	//toString which returns the prof's name
	public String toString()
	{
		return name;
	}
	
}