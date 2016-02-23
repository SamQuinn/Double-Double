/**
*
*Room class for CPSC 101 final project
*
*@author Scott Howes
*@version 22/02/2016
*
*/



public class Room
{

	//class variable(s)
	private String roomNumber = "";


	//constructor takes the full room number including
	//the building number and room number ie) 8-2030
	public Room(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}


	//toString returns the the full room number
	public String toString()
	{
		return roomNumber;
	}

}